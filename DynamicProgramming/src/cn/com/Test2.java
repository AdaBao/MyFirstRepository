package cn.com;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=4;
		int capacity=8;
		int[] w={0,2,3,4,5};//��һ��Ԫ�ؿ���
		int[] value={0,3,4,5,6};//��һ��Ԫ�ؿ���
		KnapsackProblem kp=new KnapsackProblem(count,value,w,capacity);
		kp.findMax();
		kp.findWhat();

	}

}
