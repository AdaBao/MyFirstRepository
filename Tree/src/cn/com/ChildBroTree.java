package cn.com;

public class ChildBroTree {
    Node root;
    int index=0;
    /*public ChildBroTree(Node root){
    	this.root=root;
    }*/
    
    public Node getRoot(){
    	return root;
    }
    
    public void setRoot(Node root){
    	this.root=root;
    }
    //采用先序遍历
    public void traverse(Node node){
    	if(node==null)
    		return;
    	System.out.print(node.data+" ");
    	if(node.firstChild!=null)
    		traverse(node.firstChild);
    	if(node.rightBro!=null)
    		traverse(node.rightBro);
    	
    }
    
    //采用先序遍历创建树,形如 ABC##DE#G##F###  1,2,3,0,0,4,5,0,6,0,0,7,0,0,0
    public Node preCreateTree(Object []o,Node root){
    	if((Integer)o[index]==0)
    		{
    		    index=index+1;
    		    return null;
    		}
    	root=new Node(0,null,null);
    	root.data=o[index];
    	index=index+1;
    	
    	root.firstChild=preCreateTree(o,root.firstChild);
        root.rightBro=preCreateTree(o,root.rightBro);
        return root;
    }
    
    //先序和中序创建二叉树,所有节点的值不能重复
    public Node preAndInorderCreateTree(Object []pre, Object []inOrder){
    	Node root=null;
    	int root_index1=0;
    	root=new Node(0,null,null);
    	root.data=pre[index];
    	index=index+1;
    	for(int i=0; i<inOrder.length; i++){
    		if(root.data==inOrder[i])
    		{
    			root_index1=i;
    			break;
    		}
    	}
		 
    	if(root_index1==0)
    		root.firstChild=null;
    	else{
		    Object[] newInOrder=new Object[root_index1];
		    System.arraycopy(inOrder, 0, newInOrder, 0, root_index1);
		    root.firstChild=preAndInorderCreateTree(pre,newInOrder);
    	}
    	
    	
    	if(root_index1==inOrder.length-1)
    		root.rightBro=null;
    	else{
		    Object[] newInOrder1=new Object[inOrder.length-root_index1-1];
		    System.arraycopy(inOrder, root_index1+1, newInOrder1, 0, newInOrder1.length);
		    root.rightBro=preAndInorderCreateTree(pre,newInOrder1);
    	}
    	return root;
    }
    
    /*public void preCreateTree1(Object []o,int index){
    	index=index+1;
    	preCreateTree(o,index,this.root.firstChild);
    	preCreateTree(o,index,this.root.rightBro);
    }*/
    
  //采用中序遍历
    public void traverseInOrder(Node node){
    	if(node==null)
    		return;
    	traverseInOrder(node.firstChild);
    	System.out.print(node.data+" ");
    	traverseInOrder(node.rightBro);
    	
    }
}
