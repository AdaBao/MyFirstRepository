package cn.com;

//这是循环链表的节点,每个节点包括元素 和下一个节点的引用
public class Node {
      Object element;
      Node nextNode;
      
      //非头节点的构造方法,元素不为null
      public Node(Object element,Node nextNode){
    	  this.element=element;
    	  this.nextNode=nextNode;
      }
      //头节点的构造方法,元素值为null,下一个节点指向自身
      public Node(){
    	  this.element=null;
    	  this.nextNode=this;
      }
      
      public Object getValue(){
    	  return element;
      }
      public Node getNextNode(){
    	  return nextNode;
      }
      public void setValue(Object element){
    	  this.element=element;
      }
      public void setNextNode(Node nextNode){
    	  this.nextNode=nextNode;
      }
}
