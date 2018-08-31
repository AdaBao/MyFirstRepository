package cn.com;

/*采用数组实现循环队列
 * */

/*在循环队列中，当出现front=rear的情况时，队列可能为空，也可能已满
 *这里采用的方式是设置tag
 * */

public class CircleQueue1 {
    private int [] queue;
    private int front;
    private int rear;
    private int tag=0;//如果队列满，则tag=1，如果队列为空，则tag=0
    
    public CircleQueue1(){
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
    	tag=0;
    }
    
    
    public void enQueue(int e){
    	if(full()){
    		System.out.println("队列已满");
    		return;
    	}
    	queue[rear]=e;
    	rear=(rear+1)%10;
    	tag=1;
    }
    
    public int length(){
    	return (rear-front+10)%10;
    }
    
    public boolean empty(){
    	if(front==rear&&tag==0)
    		return true;
    	else
    		return false;
    }
    
    public boolean full(){
    	if(front==rear&&tag==1)
    		return true;
    	else 
    		return false;
    }
    
   
}
