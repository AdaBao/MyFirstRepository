package cn.com;

//����ѭ������Ľڵ�,ÿ���ڵ����Ԫ�� ����һ���ڵ������
public class Node {
      Object element;
      Node nextNode;
      
      //��ͷ�ڵ�Ĺ��췽��,Ԫ�ز�Ϊnull
      public Node(Object element,Node nextNode){
    	  this.element=element;
    	  this.nextNode=nextNode;
      }
      //ͷ�ڵ�Ĺ��췽��,Ԫ��ֵΪnull,��һ���ڵ�ָ������
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
