public class Node	{
	private Object item;
	private Node next;

	public Node (Object item)	{
		this.item = item;
		next = null;
	}

	public Node (Object item, Node next)	{
		this.item = item;
		this.next = next;
	}

	public void setItem (Object item)	{
		this.item = item;
	}

	public void setNext (Node next)	{
		this.next = next;
	}

	public Object getItem ()	{
		return item;
	}

	public Node getNext ()	{
		return next;
	}
}
