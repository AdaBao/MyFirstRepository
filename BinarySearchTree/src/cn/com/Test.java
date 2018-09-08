package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree=new BinarySearchTree();
		int values[]={4,7,2,3,1,0,5};
		tree._buildTree(values);
		//tree._inOrderTraverse();
		//System.out.println();
		//tree._preOrderTraverse();
		tree._contains(4);
		tree._contains(0);
		tree._contains(3);
		System.out.println();
		tree._contains(10);
		tree._contains(6);
		tree._contains(8);
		tree._findMin();
		tree._findMax();
		tree._insert(5);
		tree._insert(6);
		tree._insert(8);
		tree._insert(-1);
		tree._preOrderTraverse();
		tree._remove(1);
		System.out.println();
		tree._preOrderTraverse();
		

	}

}
