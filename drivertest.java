/*	Andrew Coleman
	CSC-2020 10:00 AM
*/

public class drivertest	{
	public static void main (String[] args)	{
		ListSortedInterface list = new ListSortedReferenceBased();
		try	{
		list.add("b");
		System.out.print(list + "\n\n");
		list.add("a");
		System.out.print(list + "\n\n");
		list.add("d");
		System.out.print(list + "\n\n");
		list.add("c");
		System.out.print(list + "\n\n");
		list.remove("a");
		System.out.print(list + "\n\n");
		list.remove("d");
		System.out.print(list + "\n\n");

		System.out.println(list.get(2));
		}
		catch (ListException e)	{
			System.out.println(e);
		}
	}
}