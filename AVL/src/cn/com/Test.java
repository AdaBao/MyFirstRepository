package cn.com;

public class Test {
	public static void main(String[] args){
		AvlTree tree=new AvlTree();
		Node root=null;
		
		
			root=tree.insert(root, 3);
			root=tree.insert(root, 2);
			root=tree.insert(root, 1);
			root=tree.insert(root, 4);
			root=tree.insert(root, 5);
			root=tree.insert(root, 6);
			root=tree.insert(root, 7);
			root=tree.insert(root, 16);
			root=tree.insert(root, 15);
			root=tree.insert(root, 14);
			root=tree.insert(root, 13);
			root=tree.insert(root, 12);
			root=tree.insert(root, 11);
			root=tree.insert(root, 10);
			root=tree.insert(root, 8);
			root=tree.insert(root, 9);
		
		
		tree.preOrderTraverse(root);
		System.out.println();
		tree.inOrderTraverse(root);
		System.out.println();
		
		root=tree.remove(7, root);
		tree.preOrderTraverse(root);
		System.out.println();
		tree.inOrderTraverse(root);
	}

}
