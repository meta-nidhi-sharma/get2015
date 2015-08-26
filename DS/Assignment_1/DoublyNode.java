package DSAssignment1;
/**
 * @ Nidhi
 * Date: 25 august,2015
 * Description: DoublyNode containing nodes of doublyLinkedList
 */
public class DoublyNode
{
	private int value;
	private DoublyNode next;
	private DoublyNode prev;
	//Constructor
	public DoublyNode()
	{
		this.value=0;
		this.next=null;
		this.prev=null;
	}
	//constructor
	public DoublyNode(int value,DoublyNode next,DoublyNode prev)
	{
		this.value=value;
		this.next=next;
		this.prev=prev;
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
	public DoublyNode getNext()
	{
		return next;
	}
	/********************
	 * Set node next
	 **********************/
	public void setNext(DoublyNode next)
	{
		this.next = next;
	}
	/*****************************
	 * Get node value
	 * @return node previous value
	 *******************************/
	public DoublyNode getPrev()
	{
		return prev;
	}
	/********************
	 * Set node previous
	 **********************/
	public void setPrev(DoublyNode prev)
	{
		this.prev = prev;
	}
}
