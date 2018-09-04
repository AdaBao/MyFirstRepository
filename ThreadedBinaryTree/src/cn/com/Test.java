package cn.com;



public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o[]={"A","B","C","#","#","D","E","#","G","#","#","F","#","#","#"};
		ThreadedBinaryTree tree=new ThreadedBinaryTree();
		tree.createTree(o);
		tree.preTraverse(tree.getRoot());
		System.out.println();
		tree.inThreading(tree.getRoot());
		
		System.out.println();
		tree.inOrderTraverse_Thr();
		
	}
}
