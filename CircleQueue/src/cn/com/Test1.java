package cn.com;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleQueue1 queue=new CircleQueue1();
		
		for(int i=1; i<=11; i++)
			{
			    queue.enQueue(i);
		
			}
		
		for(int i=1; i<=10; i++)
		{
			queue.deQueue();
		}
		queue.deQueue();
		queue.deQueue();
		/*queue.enQueue(100);
		queue.enQueue(200);
		
		
		for(int i=0; i<8; i++)
			queue.deQueue();
		System.out.println(queue.length());*/
		
	}

}
