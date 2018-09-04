package cn.com;

//对二叉树以某种次序遍历使其变为线索二叉树的过程称作是线索化，等于是把一棵二叉树转变成了双向链表
public class ThreadedBinaryTree {
	Node root;
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	Node pre=null;//始终指向当前节点的前驱
	int index=0;
	//采用先序遍历创建树,形如 ABC##DE#G##F###
	public  Node preOrderCreateTree(Object []o){
			if("#".equals(o[index])){
				index++;
				return null;
			}
			Node node=new Node();
			node.data=o[index];
			node.lchild=null;
			node.rchild=null;
			
			index++;
			
			node.lchild=preOrderCreateTree(o);
			node.rchild=preOrderCreateTree(o);
			return node;
		}
	
	//用来调用preOrderCreateTree
	public void createTree(Object []o){
		this.root=this.preOrderCreateTree(o);
	}

	//中序遍历线索化二叉树 
	public void inThreading(Node root){
		if(root==null)
			return;
		
		inThreading(root.lchild);
		if(root.lchild==null)//前驱
			{
			 
			    root.lchild=pre;
			    root.tag1=1;
			}
		if(pre!=null&&pre.rchild==null){//后继
			
			pre.rchild=root;
			pre.tag2=1;
		}
		
		pre=root;
		inThreading(root.rchild);
	}
	
    //中序遍历线索二叉树
	public void inOrderTraverse_Thr(){
		Node currentNode=this.root;
		
		while(currentNode!=null){
			while(currentNode.tag1==0)
				currentNode=currentNode.lchild;//先找到最左边的节点    因为中序遍历是左中右的顺序    所以需要找到最左边的节点
			System.out.print(currentNode.data+" ");
		    while(currentNode.tag2==1)//不断的打印后继节点   直到后继节点存在右子树为止
		    {
		    	currentNode=currentNode.rchild;
		    	System.out.print(currentNode.data+" ");
		    }
		    
		    currentNode=currentNode.rchild;//让currentNode指向右子树的第一个节点
		}
	}
	
	//先序遍历
		public void preTraverse(Node root){
			if(root==null)
				return;
			System.out.print(root.data+" ");
			preTraverse(root.lchild);
			preTraverse(root.rchild);
		}

}
