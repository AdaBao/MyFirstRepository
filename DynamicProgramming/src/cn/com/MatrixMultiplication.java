package cn.com;

//����˷���˳����,��Ҫ��ʽ�� ����˷�.jpg��
public class MatrixMultiplication {
	int[] c;// ��ʾÿ�����������,c[0]��ʾ��һ�����������,c[i]��ʾ��i�����������
	long[][] m;// m[i][j]��ʾi��j֮�����С�˷�����,i��j����1��ʼ
	int[][] lastChange;// ���ڼ�¼�˷�˳��,i��j����1��ʼ

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
