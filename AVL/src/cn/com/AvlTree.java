package cn.com;

public class AvlTree {
	int partMin;
	private int height(Node node){
		return node==null?-1:node.height;
	}
	
	public Node insert(Node node,int x){
		if(node==null)
		{
			Node newNode=new Node();
			newNode.data=x;
			return newNode;
		}
		
		if(x<node.data)
			node.lchild=insert(node.lchild,x);
		else if(x>node.data)
			node.rchild=insert(node.rchild,x);
		else{
		   System.out.println("重复了");	
		}
		return this.balance(node);
	}
	
	private Node balance(Node node){
		if(node==null)
			return null;
		if(this.height(node.lchild)-this.height(node.rchild)>1){
			if(this.height(node.lchild.lchild)>=this.height(node.lchild.rchild)){
				//单旋转
				return this.rotateWithLeftChild(node);
			}else{
				//双旋转
				return this.doubleWithLeftChild(node);
			}
		}else if(this.height(node.rchild)-this.height(node.lchild)>1){
			if(this.height(node.rchild.rchild)>=this.height(node.rchild.lchild)){
				//单旋转
				return this.rotateWithRightChild(node);
			}else{
				//双旋转
				return this.doubleWithRightChild(node);
			}
		}else
			{
			   node.height=Math.max(this.height(node.lchild),this.height(node.rchild))+1;
			   return node;
			}
	}
	
	private Node rotateWithLeftChild(Node node){
		Node temp=node.lchild;
		node.lchild=node.lchild.rchild;
		temp.rchild=node;
		temp.rchild.height=Math.max(this.height(temp.rchild.lchild), this.height(temp.rchild.rchild))+1;
		temp.height=Math.max(this.height(temp.lchild), temp.rchild.height)+1;
		return temp;
	}
	
	private Node rotateWithRightChild(Node node){
		Node temp=node.rchild;
		node.rchild=node.rchild.lchild;
		temp.lchild=node;
		temp.lchild.height=Math.max(this.height(temp.lchild.lchild), this.height(temp.lchild.rchild))+1;
		temp.height=Math.max(temp.lchild.height, this.height(temp.rchild))+1;
		return temp;
	}
	
	private Node doubleWithLeftChild(Node node){
		node.lchild=this.rotateWithRightChild(node.lchild);
		return this.rotateWithLeftChild(node);
	}
	
	private Node doubleWithRightChild(Node node){
		node.rchild=this.rotateWithLeftChild(node.rchild);
		return this.rotateWithRightChild(node);
	}
	
	public Node remove(int x,Node node){
		if(node==null)
			return null;
		if(x<node.data){
			node.lchild=remove(x,node.lchild);
		}else if(x>node.data){
			node.rchild=remove(x,node.rchild);
		}else if(node.lchild!=null&&node.rchild!=null){
			this.findMin(node.rchild);
			node.data=this.partMin;
			node.rchild=remove(this.partMin,node.rchild);
		}else{
			node=(node.lchild!=null)?node.lchild:node.rchild;
		}
		
		return this.balance(node);
			
		}
	
	//递归寻找最小值
		public void findMin(Node node){
			if(node==null)
				return;
			if(node.lchild==null)
			{
				this.partMin=node.data;
				System.out.println("最小值: "+node.data);
				return;
			}else
				findMin(node.lchild);
				
		}
		
		public void preOrderTraverse(Node node){
			if(node==null)
				return;
			System.out.print(node.data+" ");
			preOrderTraverse(node.lchild);
			preOrderTraverse(node.rchild);
		}
		public void inOrderTraverse(Node node){
			if(node==null)
				return;
			inOrderTraverse(node.lchild);
			System.out.print(node.data+" ");
			inOrderTraverse(node.rchild);
		}
	
	}

