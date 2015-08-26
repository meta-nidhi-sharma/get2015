package DSAssignment1;
/**
 * @ Nidhi
 * Date: 25 august,2015
 * Description: Node containing value and next
 */
public class Node
{
	private int value;
	private Node next;
	
	Node()
	{
		this.value=0;
		this.next=null;
	}
	
	public Node(int value,Node next)
	{
		this.value=value;
		this.next=next;
	}

	/********************
	 * Get node value
	 * @return value
	 **********************/
	public int getValue() 
	{
		return value;
	}
	/********************
	 * set node value
	 **********************/
	public void setValue(int value) 
	{
		this.value = value;
	}
	/********************
	 * Get node next value
	 * @return next value
	 **********************/
	public Node getNext() 
	{
		return next;
	}
	/********************
	 * Set node next
	 **********************/
	public void setNext(Node next) 
	{
		this.next = next;
	}
}
