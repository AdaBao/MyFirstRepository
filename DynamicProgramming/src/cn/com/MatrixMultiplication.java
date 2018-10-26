package cn.com;

//矩阵乘法的顺序安排,重要公式在 矩阵乘法.jpg中
public class MatrixMultiplication {
	int[] c;// 表示每个矩阵的列数,c[0]表示第一个矩阵的行数,c[i]表示第i个矩阵的列数
	long[][] m;// m[i][j]表示i和j之间的最小乘法次数,i和j都从1开始
	int[][] lastChange;// 用于记录乘法顺序,i和j都从1开始

	public MatrixMultiplication(int[] c) {
		this.c = c;
		this.m = new long[c.length][c.length];
		for (int i = 1; i < c.length; i++)
			m[i][i] = 0;
		this.lastChange = new int[c.length][c.length];
	}

	public void optMatrix() {
		int n = c.length - 1;
		for (int k = 1; k <= n - 1; k++) { // k=right-left

			for (int left = 1; left <= n - k; left++) {

				int right = left + k;
				this.m[left][right] = Long.MAX_VALUE;

				for (int i = left; i < right; i++) {
					long _m = this.m[left][i] + this.m[i + 1][right] + c[left - 1] * c[i] * c[right];
					if (_m < this.m[left][right]) {
						this.m[left][right] = _m;
						lastChange[left][right] = i;
					}
				}

			}
		}
		
		
				System.out.print(m[1][c.length-1]);
			
	}
}
