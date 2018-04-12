package bit.bth;



public class TreeNode {
	public TreeNode(){
		value=0;
		leftNode=null;
		rightNode=null;
		parentNode=null;
	}
	private int value;
	private TreeNode leftNode;
	private TreeNode rightNode;
	private TreeNode parentNode;
	public int getValue() {
		return value;
	}
	public TreeNode getParentNode() {
		return parentNode;
	}
	public void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
}
