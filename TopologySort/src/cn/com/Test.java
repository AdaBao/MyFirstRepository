package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MGraph graph=new MGraph();
		graph.init();
		graph.topologySort();

	}

}

/*
 * 测试用例:
 输入节点数:
14
输入各个节点的值:
0 1 2 3 4 5 6 7 8 9 10 11 12 13
输入邻接矩阵:
0 -1 -1 -1  1  1 -1 -1 -1 -1 -1  1 -1 -1
-1  0  1 -1  1 -1 -1 -1  1 -1 -1 -1 -1 -1
-1 -1  0 -1 -1  1  1 -1 -1  1 -1 -1 -1 -1
-1 -1  1  0 -1 -1 -1 -1 -1 -1 -1 -1 -1  1
-1 -1 -1 -1  0 -1 -1  1 -1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1  0 -1 -1  1 -1 -1 -1  1 -1
-1 -1 -1 -1 -1  1  0 -1 -1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1 -1  0 -1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1 -1  1  0 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1 -1 -1 -1  0  1  1 -1 -1
-1 -1 -1 -1 -1 -1 -1 -1 -1 -1  0 -1 -1  1
-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1  0 -1 -1
-1 -1 -1 -1 -1 -1 -1 -1 -1  1 -1 -1  0 -1
-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1  0
0
1
3
2
4
6
5
8
7
12
9
10
11
13
 */