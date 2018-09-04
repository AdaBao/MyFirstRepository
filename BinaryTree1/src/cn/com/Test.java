package cn.com;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bTree=new BinaryTree();
		Object o[]={"A","B","C","#","#","D","E","#","G","#","#","F","#","#","#"};
		Node root=bTree.preOrderCreateTree(o);
		bTree.setRoot(root);
		bTree.preTraverse(bTree.getRoot());
		System.out.println();
		Queue<Object> queue=new LinkedList<Object>();
		bTree.levelTraverse(root, queue);
	}

}
