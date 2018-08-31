package cn.com;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleQueue queue=new CircleQueue();
		//CircleQueue queue1=new CircleQueue();
		for(int i=1; i<=9; i++)
			{
			    queue.enQueue(i);
		
			}
		
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(100);
		queue.enQueue(200);
		
	
		
		for(int i=0; i<8; i++)
			queue.deQueue();
		System.out.println(queue.length());
		
		
	}

}
