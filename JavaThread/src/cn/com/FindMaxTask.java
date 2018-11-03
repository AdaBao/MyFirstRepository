package cn.com;

import java.util.concurrent.Callable;

public class FindMaxTask implements Callable<Integer>{
	int []array;
	
	public FindMaxTask(int[] array){
		if(array==null||array.length==0)
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.array=array;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int max=this.array[0];
		for(int i=1; i<this.array.length; i++){
			if(this.array[i]>max)
				max=this.array[i];
		}
		return max;
	}

}
