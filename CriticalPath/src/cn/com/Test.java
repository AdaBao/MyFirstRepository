package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MGraph graph=new MGraph();
		graph.init();
		graph.criticalPath();
	}

}

/*��������:
  ����ڵ���:
9
��������ڵ��ֵ:
1 2 3 4 5 6 7 8 9
�����ڽӾ���:
 0  6  4  5 -1 -1 -1 -1 -1
-1  0 -1 -1  1 -1 -1 -1 -1
-1 -1  0  0  1 -1 -1 -1 -1
-1 -1 -1  0 -1  2 -1 -1 -1
-1 -1 -1 -1  0 -1  9  7 -1
-1 -1 -1 -1 -1  0 -1  4 -1
-1 -1 -1 -1 -1 -1  0 -1  2
-1 -1 -1 -1 -1 -1 -1  0  4
-1 -1 -1 -1 -1 -1 -1 -1  0

1
2
5
7
9
* */
