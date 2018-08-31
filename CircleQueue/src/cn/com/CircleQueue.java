package cn.com;

/*��������ʵ��ѭ������
 * */

/*��ѭ�������У�������front=rear�����ʱ�����п���Ϊ�գ�Ҳ��������
 *������õķ�ʽ�ǿճ�һ��Ԫ��
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
    		System.out.println("����Ϊ��");
    		return;
    	}
    	//System.out.println(queue[front]);
    	front=(front+1)%10;
    }
    
    
    public void enQueue(int e){
    	if(full()){
    		System.out.println("��������");
    		return;
    	}
    	queue[rear]=e;
    	rear=(rear+1)%10;
    }
    
    public int length(){
    	return (rear-front+10)%10;//����֮����ȡģ����Ϊ��front==rear��ʱ�򣬶���Ϊ�գ������ȡģ�������
    }
    
    public boolean empty(){
    	if(front==rear)
    		return true;
    	else
    		return false;
    }
    
    public boolean full(){
    	if((rear+1)%10==front)//����֮����Ҫȡģ����Ϊrear���ָ���������һλ����ôrear+1�ĳ��Ⱦͻᳬ������ĳ���
    		return true;
    	else 
    		return false;
    }
    
   
}
