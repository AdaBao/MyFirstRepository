package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MGraph graph=new MGraph();
		/*测试用例:
		 * 输入顶点数:7
			输入各个顶点的值:A B C D E F G
			输入邻接矩阵:
			0 -1 1 1 -1 1 -1
			-1 0 1 -1 -1 -1 -1
			1 1 0 1 -1 -1 -1
			1 -1 1 0 -1 -1 -1
			-1 -1 -1 -1 0 -1 1
			1 -1 -1 -1 -1 0 1
			-1 -1 -1 -1 1 1 0
			输出:A C B D F G E 
		 * */
		graph.DFSTraverse();
		

	}

}
