package cn.com;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MGraph graph=new MGraph();
		/*���붥����:9
			������������ֵ:A B C D E F G H I
			�����ڽӾ���:
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
