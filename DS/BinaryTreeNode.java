package TreeSort;
/**
* @author Nidhi Sharma
* Date: 4 September,2015
* Description :  Binary tree Node having binary tree type node
*/
public class BinaryTreeNode
{
	int nodeValue;		//holds node value
	BinaryTreeNode left;		//holding node in left
	BinaryTreeNode right;		//holding right node
	//Constructor
	public BinaryTreeNode() 
	{
		left = null;
		right = null;
	}
	//Constructor setting node value
	public BinaryTreeNode(int nodeValue) 
	{
		this.nodeValue = nodeValue;
		left = null;
		right = null;
	}
	/**********************
	 * To get Node value
	 * @return node value
	 **********************/
	public int getNodeValue() 
	{
		return nodeValue;
	}
	/**********************
	 * To set Node value
	 **********************/
	public void setNodeValue(int nodeValue)
	{
		this.nodeValue = nodeValue;
	}
	/**********************
	 * To get left node
	 * @return left node
	 **********************/
	public BinaryTreeNode getLeft()
	{
		return left;
	}
	/**********************
	 * To set left node
	 **********************/
	public void setLeft(BinaryTreeNode left)
	{
		this.left = left;
	}
	/**********************
	 * To get right node
	 * @return right node
	 **********************/
	public BinaryTreeNode getRight() 
	{
		return right;
	}
	/**********************
	 * To set right node
	 *****************/
	public void setRight(BinaryTreeNode right)
	{
		this.right = right;
	}
}

