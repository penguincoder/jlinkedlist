/*	Andrew Coleman
	CSC-2020 10:00 AM
*/

import java.util.Iterator;

public class ListSortedReferenceBased implements ListSortedInterface	{

	/** The Node that points to the first item in the collection */
	private Node head;

	/** Keeps track of the current size of the collection */
	private int size;

	/**
	 *  Sets up the instance variables to default values. <BR>
	 *  Preconditions: None. 
	 *  Postconditions: Sets the default values for the instance variables. 
	 */
	public ListSortedReferenceBased ()	{
		head = null;
		size = 0;
	}

	public boolean isEmpty ()	{
		return (size == 0);
	}

	public int size ()	{
		return size;
	}

	public void removeAll ()	{
		head = null; size = 0;
	}

	public Iterator iterator ()	{
		return new ListSortedIterator (this);
	}

	/**
	 *  Finds the Node of a specified Comparable item. <BR>
	 *  Preconditions: Requires a Comparable object. 
	 *  Postconditions: Returns a Node of the item, null if it is not found.
	 */
	private Node find (Comparable item)	{
		Node curr = head;
		while (curr != null)	{
			if ( ((Comparable) curr.getItem()).compareTo(item) == 0)
				return curr;
			curr = curr.getNext();
		}
		return null;
	}

	/**
	 *  Finds the Node at the specified index in the collection. <BR>
	 *  Preconditions: Assumes an integer in the valid range (1 - size()). 
	 *  Postconditions: Returns the node at the index. 
	 */
	private Node find (int index)	{
		Node curr = head;
		for (int skip = 1; skip < index; skip++)
			curr = curr.getNext();
		return curr;
	}

	/**
	 * Locates the last Node that is less than the passed Comparable object. <BR>
	 * Preconditions: Requires a Comparable object, and assumes that size > 1.
	 * Postconditions: Returns a Node directly before where the passed object should be in the collection, or null if it should be the first item. 
	 */
	private Node findplace (Comparable item)	{
		/* curr will compare itself to item until it is too big, then prev is in the correct place */
		Node curr = head.getNext(), prev = head;
		/* must check to see if the first item is the item searched for */
		if (((Comparable) prev.getItem()).compareTo(item) > 0)
			return null;
		/* while not at the end of the list and the item in curr is less than item */
		while (curr != null && ((Comparable) curr.getItem()).compareTo(item) < 0)	{
			prev = curr;
			curr = curr.getNext();
		}
		return prev;
	}

	public void add (Comparable item) throws ListException	{
		/* is item in the collection? */
		if (find (item) == null)	{
			/* curr will be the active Node in the collection */
			Node curr = head;
			/* temp will be the inserted Node */
			Node temp;
			/* if the list is empty, just put in temp */
			if (size == 0)
				head = new Node (item);
			/* if the size of the collection is 1, then check to see if the Node is bigger or less */
			else if (size == 1)	{
				if ( ((Comparable) curr.getItem()).compareTo (item) > 0)	{
					temp = new Node (item, head);
					head = temp;
				}
				else	{
					temp = new Node (item);
					head.setNext(temp);
				}
			}
			/* well, the collection must be > 1 so now use the nifty findplace and figure out the Node that temp should be placed after */
			else	{
				curr = findplace (item);
				if (curr == null)
					temp = new Node (item, head);
				else {
					temp = new Node (item, curr.getNext());
					curr.setNext (temp);
				}
			}
			/* increment the all important size */
			size++;
		}
		else	{
			/* use a variable and one throw rather than two different throws... less typing i suppose */
			String s;
			if (size == 0)
				s = " or list is empty";
			else
				s = "";
			throw new ListException ("Item is already in data collection" + s + ".");
		}
	}

	public void remove (Comparable item) throws ListException	{
		/* if the item is in fact in the collection */
		if (find (item) == null)
			throw new ListException ("Item is not in the data collection.");
		else	{
			/* if there is more than 2 objects in the collection then find the previous Node */
			if (size > 2)	{
				Node curr = findplace(item);
				/* just skip over the item to remove */
				curr.setNext (curr.getNext().getNext());
			}
			/* if the size is 2, then one or the other is the item in question */
			else if (size == 2)	{
				/* must cast... Node and Object only */
				if (((Comparable) head.getItem()).compareTo(item) == 0)
					head = head.getNext();
				else
					head.setNext(null);
			}
			/* if the size is 1, well, just remove it all */
			else
				head = null;
			/* and they will all remove exactly 1, so 1 decrement for all cases */
			size--;
		}
			
	}

	public Comparable get (int index) throws ListException	{
		/* must check and see if index is within the range of the collection */
		if (index > 0 && index <= size)	{
			Node curr = head;
			for (int skip = 1; skip < index; skip++)
				curr = curr.getNext ();
			/* must cast to Comparable since Node uses Object(s) */
			return ((Comparable) curr.getItem());
		}
		else
			throw new ListException ("Index is out of range.");
	}

	/**
	 * Returns a string containing each Node separated by newlines. <BR>
	 * Preconditions: None.
	 * Postconditions: Returns a string containing an easy to read format of the collection. 
	 */
	public String toString ()	{
		String result = "";
		/* i save 1 line of code if i use the iterator, rather than looping through the list */
		/* besides, i haven't used the iterator anywhere else */
		Iterator allyourbase = iterator();
		while (allyourbase.hasNext ())
			result += allyourbase.next() + "\n";
		return result;
	}
}
