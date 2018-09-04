package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HoffmanTree tree=new HoffmanTree();
		String str="BADCADFEED";
		tree.initNodeList(str);
		tree.buildTree();
		tree.outputCode(tree.getRoot(), 1);

	}

}
