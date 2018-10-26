package cn.com;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner=new Scanner(System.in);
		int vertexNum=vertexNum=Integer.parseInt(scanner.nextLine());
		String str=scanner.nextLine();
		String[] vertexs=str.split(" ");
		int[][]arc=new int[vertexNum][vertexNum];
		for(int i=0; i<vertexNum; i++)
			for(int j=0; j<vertexNum; j++)
				arc[i][j]=scanner.nextInt();
		
		ShortestPath  sp=new ShortestPath(vertexNum, vertexs,arc);
		sp.shortestPath();

	}

}


/*9
0 1 2 3 4 5 6 7 8
0 1 5 65535 65535 65535 65535 65535 65535
1 0 3 7 5 65535 65535 65535 65535
5 3 0 65535 1 7 65535 65535 65535
65535 7 65535 0 2 65535 3 65535 65535
65535 5 1 2 0 3 6 9 65535
65535 65535 7 65535 3 0 65535 5 65535
65535 65535 65535 3 6 65535 0 2 7
65535 65535 65535 65535 9 5 2 0 4
65535 65535 65535 65535 65535 65535 7 4 0
0 1 2 4 3 6 7 8 
 * */
