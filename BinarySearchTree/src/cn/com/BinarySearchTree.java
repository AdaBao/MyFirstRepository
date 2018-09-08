package cn.com;

import java.util.Arrays;

/*���������*/
public class BinarySearchTree {
	BinaryNode root;
	int partMin;//��ʾ������Сֵ
	
	//�ڵ��õݹ麯��֮ǰ,�Ƚ��������ж�,��������������ж������Ƿ����ظ�Ԫ��
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
						System.out.println("�����д����ظ�Ԫ��");
						return;
					}
				}
			}
			
			this.root=this.buildTree(values,0,values.length-1);
		}
	}
	
	//����������������õݹ�ķ���,���ҵ��м�Ԫ��,�м�Ԫ���Ǹ��ڵ�,���ϵصݹ���ȥ,ÿ�ε��ú�����ʱ��Ҫȥ�����µ�����,����ᱨջ������쳣
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
	
	//���������֤
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
	
	//���������֤
	public void _preOrderTraverse(){
		this.preOrderTraverse(root);
	}
    
	//�ж��Ƿ����x
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
			System.out.println("����");
		else
			System.out.println("������");
	}
	
	//�ݹ�Ѱ����Сֵ
	public void findMin(BinaryNode node){
		if(node==null)
			return;
		if(node.lchild==null)
		{
			this.partMin=node.data;
			System.out.println("��Сֵ: "+node.data);
			return;
		}else
			findMin(node.lchild);
			
	}
	
	public void _findMin(){
		this.findMin(root);
	}
	
	//ѭ��Ѱ�����ֵ
	public void findMax(BinaryNode root){
		if(root==null)
			return;
		while(root.rchild!=null){
			root=root.rchild;
		}
		System.out.println("���ֵ: "+root.data);
		
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
			System.out.println("�Ѵ���");
		}
		
		return node;//��������
	}
	
	public void _insert(int x){
		this.root=this.insert(x, this.root);
	}
	
	//ɾ���ڵ�
	public BinaryNode  remove(int x,BinaryNode node){
		if(node==null)
			{
			  System.out.println("������");
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
