package cn.com;

/*
 * ��ѭ������
 * */
public class CycleLinkedList {
	Node head;//ͷ�ڵ�
	int size;//�����С
	//Node currentNode;
	
	//��ʼ��ͷ�ڵ�������С
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
	
	//newNode����preNode֮��
	public void insertNode(Node newNode,Node preNode){
		newNode.setNextNode(preNode.getNextNode());
		preNode.setNextNode(newNode);
		this.size++;
	}
	
}
