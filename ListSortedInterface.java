/*	Andrew Coleman
	CSC-2020 10:00 AM
*/

import java.util.Iterator;

public interface ListSortedInterface	{
	/**
	 *  Checks to see if the list is empty and returns a boolean value. <BR>
	 *  Preconditions: none. 
	 *  Postconditions: Returns true if empty, false if it is not empty. 
	 */
	public boolean isEmpty();

	/**
	 *  Returns the current size of the list. <BR>
	 *  Preconditions: none. 
	 *  Postconditions: Returns an interger of the size. 
	 */
	public int size();

	/**
	 *  Adds a Comparable item to the list. <BR>
	 *  Preconditions: Requires a Comparable item to insert into the list. 
	 *  Postconditions: Inserts the Comparable item in the list. 
	 *  Throws: Throws a ListException if you try and add a duplicate entry into the list. 
	 */
	public void add(Comparable item) throws ListException;

	/**
	 *  Removes an item from the list. <BR>
	 *  Preconditions: Requires a Comparable item to remove. 
	 *  Postconditions: Removes the item from the list. 
	 *  Throws: Throws a ListException if the item is not found.
	 */
	public void remove(Comparable item) throws ListException;

	/**
	 *  Returns an item in the list at the specified index. <BR>
	 *  Preconditions: A valid integer index value. 
	 *  Postconditions: Returns a Comparable object at the said index. 
	 *  Throws: Throws a ListException if the index value is out of range. 
	 */
	public Comparable get(int index) throws ListException;

	/**
	 *  Removes all entries in the list. <BR>
	 *  Preconditions: None. 
	 *  Postconditions: Removes all items in the list. 
	 */
	public void removeAll();

	/**
	 *  Creates an Iterator to cycle through the list. <BR>
	 *  Preconditions: None. 
	 *  Postconditions: Returns the Iterator for the list. 
	 */
	public Iterator iterator();
}
