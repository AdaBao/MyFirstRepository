package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MGraph graph=new MGraph();
		/*��������:
		 * ���붥����:7
			������������ֵ:A B C D E F G
			�����ڽӾ���:
			0 -1 1 1 -1 1 -1
			-1 0 1 -1 -1 -1 -1
			1 1 0 1 -1 -1 -1
			1 -1 1 0 -1 -1 -1
			-1 -1 -1 -1 0 -1 1
			1 -1 -1 -1 -1 0 1
			-1 -1 -1 -1 1 1 0
			���:A C B D F G E 
		 * */
		graph.DFSTraverse();
		

	}

}
