package cn.com;

import java.util.Arrays;

/*二叉查找树*/
public class BinarySearchTree {
	BinaryNode root;
	int partMin;//表示子树最小值
	
	//在调用递归函数之前,先进行若干判断,并把数组排序和判断数组是否有重复元素
	public void _buildTree(int[] values){
		if(values==null)
		{
			root=null;
			return;
		}else if(values.length==0){
			root=null;
			return;
		}else{
			Arrays.sort(values);
			for(int i=0; i<values.length; i++){
				if(i==values.length-1)
				{}else{
					if(values[i]==values[i+1]){
						System.out.println("数组中存在重复元素");
						return;
					}
				}
			}
			
			this.root=this.buildTree(values,0,values.length-1);
		}
	}
	
	//建立二叉查找树采用递归的方法,先找到中间元素,中间元素是根节点,不断地递归下去,每次调用函数的时候不要去构造新的数组,否则会报栈溢出的异常
	public BinaryNode buildTree(int[] values,int start,int end){
		if(start>end) return null;
		int middleIndex=(start+end)/2;
		BinaryNode node=new BinaryNode();
		node.data=values[middleIndex];
		
		//int [] lvalues=new int[middleIndex-start];
		//int [] rvalues=new int[end-middleIndex];
		node.lchild=buildTree(values,start,middleIndex-1);
		node.rchild=buildTree(values,middleIndex+1,end);
		
		return node;
	}
	
	public void inOrderTraverse(BinaryNode node){
		if(node==null)
			return;
		inOrderTraverse(node.lchild);
		System.out.print(node.data+" ");
		inOrderTraverse(node.rchild);
	}
	
	//中序遍历验证
	public void _inOrderTraverse(){
		this.inOrderTraverse(root);
	}
	
	public void preOrderTraverse(BinaryNode node){
		if(node==null)
			return;
		System.out.print(node.data+" ");
		preOrderTraverse(node.lchild);
		preOrderTraverse(node.rchild);
	}
	
	//先序遍历验证
	public void _preOrderTraverse(){
		this.preOrderTraverse(root);
	}
    
	//判断是否包含x
	public boolean contains(BinaryNode node, int x){
		if(node==null)
			return false;
		
		if(x<node.data)
		return contains(node.lchild,x);
		else if(x>node.data)
		return contains(node.rchild,x);
		else
		return true;
	}
	
	public void _contains(int x){
		boolean match=this.contains(root, x);
		if(match)
			System.out.println("存在");
		else
			System.out.println("不存在");
	}
	
	//递归寻找最小值
	public void findMin(BinaryNode node){
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
	
	public void _findMin(){
		this.findMin(root);
	}
	
	//循环寻找最大值
	public void findMax(BinaryNode root){
		if(root==null)
			return;
		while(root.rchild!=null){
			root=root.rchild;
		}
		System.out.println("最大值: "+root.data);
		
	}
	
	public void _findMax(){
		this.findMax(this.root);
	}
	
	public BinaryNode insert(int x,BinaryNode node){
		if(node==null)
		{
			BinaryNode newNode=new BinaryNode();
			newNode.data=x;
			return newNode;
		}
		if(x<node.data){
			node.lchild=insert(x,node.lchild);
		}else if(x>node.data){
			node.rchild=insert(x,node.rchild);
		}else{
			System.out.println("已存在");
		}
		
		return node;//返回树根
	}
	
	public void _insert(int x){
		this.root=this.insert(x, this.root);
	}
	
	//删除节点
	public BinaryNode  remove(int x,BinaryNode node){
		if(node==null)
			{
			  System.out.println("不存在");
			  return null;
			}
		if(x<node.data)
		{
			node.lchild=remove(x,node.lchild);
		}else if(x>node.data){
			node.rchild=remove(x,node.rchild);
		}else if(node.rchild!=null&&node.lchild!=null){
			this.findMin(node.rchild);
			node.data=this.partMin;
			node.rchild=remove(this.partMin,node.rchild);
		}else{
			return (node.lchild==null)?node.rchild:node.lchild;
		}
		
		return node;
	}
	
	public void _remove(int x){
		this.remove(x, root);
	}
}
