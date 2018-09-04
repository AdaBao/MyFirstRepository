package cn.com;

import java.util.Queue;
public class BinaryTree {
	Node root;
	int index=0;

	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
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
	
	//先序遍历
	public void preTraverse(Node root){
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preTraverse(root.lchild);
		preTraverse(root.rchild);
	}
	
	//层序遍历,借助队列，每次让根节点出队，让子节点入队
	public void levelTraverse(Node root,Queue<Object> queue){
		if(root==null)
			return;
		queue.offer(root);
		
		while(!queue.isEmpty()){
			root=(Node) queue.poll();
			System.out.print(root.data+" ");
			if(root.lchild!=null)
				queue.offer(root.lchild);
			if(root.rchild!=null)
				queue.offer(root.rchild);
		}
	}

}
