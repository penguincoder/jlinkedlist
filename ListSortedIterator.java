/*	Andrew Coleman
	CSC-2020 10:00 AM
*/

import java.util.Iterator;

public class ListSortedIterator implements Iterator	{
	/** Index keeps the current position in the data collection and listsize the the size of the list (only used for error checking) */
	private int index, listsize;

	/** the collection of data */
	private ListSortedInterface mylist;

	/**
	 *  Creates the Iterator for the specified list. <BR>
	 *  Preconditions: An object that implements the ListSortedInterface. 
	 *  Postconditions: none.
	 */
	public ListSortedIterator (ListSortedInterface list)	{
		index = 1;
		listsize = list.size();
		mylist = list;
	}

	/**
	 *  Resets all private integer values in the object to defaults, ie when the collection changes. <BR>
	 *  Preconditions: None.
	 *  Postconditions: Defaults all private integer values. 
	 */
	private void reset ()	{
		index = 1; listsize = mylist.size();
	}

	/**
	 *  Determines if there are more objects in the collection. <BR>
	 *  Preconditions: None. 
	 *  Postconditions: Returns a boolean value true if there are more objects, false otherwise. 
	 *  Throws: Throws a ListException if the data has been changed. 
	 */
	public boolean hasNext ()	{
		if (listsize != mylist.size())	{
			reset();
			throw new ListException ("Changes have been made to the collection.");
		}
		return (index <= listsize);
	}

	/**
	 *  Returns an Object at the current position in the collection. <BR>
	 *  Preconditions: None. 
	 *  Postconditions: Returns the current Object in the collection.
	 *  Throws: Throws a ListException if the data has been changed, or if the end of the list has been reached. 
	 */
	public Object next ()	{
		if (listsize != mylist.size())	{
			reset ();
			throw new ListException ("Changes have been made to the collection.");
		}
		if (index <= listsize)	{
			index++;
			return ((Object) mylist.get (index - 1));
		}
		else
			throw new ListException ("End of collection has been reached.");
	}

	/**
	 *  Removes the current item in the list. <BR>
	 *  Preconditions: None. 
	 *  Postconditions: Removes the current item from the list. 
	 */
	public void remove ()	{
		mylist.remove (mylist.get (index));
	}
}
