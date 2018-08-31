package cn.com;

/*采用数组实现循环队列
 * */

/*在循环队列中，当出现front=rear的情况时，队列可能为空，也可能已满
 *这里采用的方式是空出一个元素
 * */

public class CircleQueue {
    private int [] queue;
    private int front;
    private int rear;
    
    public CircleQueue(){
    	queue=new int[10];
    	front=0;
    	rear=0;
    }
    
    public void deQueue(){
    	if(empty()){
    		System.out.println("队列为空");
    		return;
    	}
    	//System.out.println(queue[front]);
    	front=(front+1)%10;
    }
    
    
    public void enQueue(int e){
    	if(full()){
    		System.out.println("队列已满");
    		return;
    	}
    	queue[rear]=e;
    	rear=(rear+1)%10;
    }
    
    public int length(){
    	return (rear-front+10)%10;//这里之所以取模是因为当front==rear的时候，队列为空，如果不取模结果不对
    }
    
    public boolean empty(){
    	if(front==rear)
    		return true;
    	else
    		return false;
    }
    
    public boolean full(){
    	if((rear+1)%10==front)//这里之所以要取模是因为rear如果指向数组最后一位，那么rear+1的长度就会超过数组的长度
    		return true;
    	else 
    		return false;
    }
    
   
}
