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
	
	//�����������������,���� ABC##DE#G##F###
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
	
	//�������
	public void preTraverse(Node root){
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preTraverse(root.lchild);
		preTraverse(root.rchild);
	}
	
	//�������,�������У�ÿ���ø��ڵ���ӣ����ӽڵ����
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
