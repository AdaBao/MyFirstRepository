package cn.com;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MGraph graph=new MGraph();
		/*输入顶点数:9
			输入各个顶点的值:A B C D E F G H I
			输入邻接矩阵:
			 0  1 -1 -1 -1  1 -1 -1 -1
			 1  0  1 -1 -1 -1  1 -1  1
			-1  1  0  1 -1 -1 -1 -1  1
			-1 -1  1  0  1 -1  1  1  1
			-1 -1 -1  1  0  1 -1  1 -1
			 1 -1 -1 -1  1  0  1 -1 -1
			-1  1 -1  1 -1  1  0  1 -1
			-1 -1 -1  1  1 -1  1  0 -1
			-1  1  1  1 -1 -1 -1 -1  0
			A B F C G I E D H 
		 * */
		graph.BFSTraverse();

	}

}
