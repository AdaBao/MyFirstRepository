package cn.com;

/*��������ʵ��ѭ������
 * */

/*��ѭ�������У�������front=rear�����ʱ�����п���Ϊ�գ�Ҳ��������
 *������õķ�ʽ������tag
 * */

public class CircleQueue1 {
    private int [] queue;
    private int front;
    private int rear;
    private int tag=0;//�������������tag=1���������Ϊ�գ���tag=0
    
    public CircleQueue1(){
    	queue=new int[10];
    	front=0;
    	rear=0;
    }
    
    public void deQueue(){
    	if(empty()){
    		System.out.println("����Ϊ��");
    		return;
    	}
    	//System.out.println(queue[front]);
    	front=(front+1)%10;
    	tag=0;
    }
    
    
    public void enQueue(int e){
    	if(full()){
    		System.out.println("��������");
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
