package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object []o={1,2,3,0,0,4,5,0,6,0,0,7,0,0,0};
		ChildBroTree tree=new ChildBroTree();
		
		//先序遍历创建树
		//Node root=tree.preCreateTree(o,null);
		//tree.setRoot(root);
		
		Object []pre={1,2,3,4,5,6,7};
		Object []inOrder={3,2,5,6,4,7,1};
		
		//先序加后序遍历创建树
		Node root=tree.preAndInorderCreateTree(pre, inOrder);
		tree.setRoot(root);
		tree.traverse(tree.getRoot());
		System.out.println();
		tree.traverseInOrder(tree.getRoot());
		
		
	}

}
