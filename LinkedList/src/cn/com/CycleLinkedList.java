package cn.com;

/*
 * 单循环链表
 * */
public class CycleLinkedList {
	Node head;//头节点
	int size;//链表大小
	//Node currentNode;
	
	//初始化头节点和链表大小
	public CycleLinkedList(){
		head=new Node();
		size=0;
	}
	
	public Node getHead(){
		return head;
	}
	public int getSize(){
		return size;
	}
	/*public Node getCurrentNode(){
		return currentNode;
	}
	
	public void setCurrentNode(Node currentNode){
		this.currentNode=currentNode;
	}*/
	
	public Node deleteNode(Node preNode){
		if(this.size==0){
			return null;
		}else{
			Node node=preNode.getNextNode();
			preNode.setNextNode(preNode.getNextNode().getNextNode());
			this.size--;
			return node;
		}
	}
	
	//newNode插入preNode之后
	public void insertNode(Node newNode,Node preNode){
		newNode.setNextNode(preNode.getNextNode());
		preNode.setNextNode(newNode);
		this.size++;
	}
	
}
