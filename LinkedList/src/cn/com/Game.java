package cn.com;

import java.util.Scanner;

/*
 * ��Ϸ����N����Χ��һ��Ȧ���ӵ�һ���˿�ʼ������������Mʱ�������˳���Ϸ��ֱ��ʣ�����һ���ˡ�
 * */

/*����:
 * ��ֹ����:ֻʣ���һ����
 * if��֧:�Ƿ�����M
 * �������:ͷ�ڵ�
 * ��ʼ����:����������,��ǰ�ڵ��ǰ��,�����С
 * ���в���:ɾ���ڵ�
 *   */
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CycleLinkedList cycleLinkedList=new CycleLinkedList();
		int number=0,selected=0;
		Scanner scanner=new Scanner(System.in);
		number=scanner.nextInt();
		selected=scanner.nextInt();
		Node preNode=cycleLinkedList.getHead();
		for(int i=0;i<number;i++){
			Node newNode=new Node(i+1,null);
		    cycleLinkedList.insertNode(newNode, preNode);
		    preNode=newNode;
		}
		
		//count������ʾ����Ĵ�С
		int count=cycleLinkedList.getSize();
		//��ʾ��ǰ�ڵ��ǰһ�ڵ�
		preNode=cycleLinkedList.getHead();
		//��ʾ����
		int j=1;
	    //�жϵ�ǰ�����С�Ƿ�Ϊ1
		while(count!=1){
			//���������,�ֱ���ѡ�к�δѡ��
			
			if(j%selected==0)
			{
			    //�õ���ǰ�ڵ�
				Node nextNode=preNode.getNextNode();
				//�жϵ�ǰ�ڵ��Ƿ�Ϊͷ�ڵ�
				if(nextNode.getValue()==null)
					{
					    nextNode=nextNode.getNextNode();
					    System.out.println((Integer)nextNode.getValue());
					    preNode=cycleLinkedList.getHead();
					    cycleLinkedList.deleteNode(cycleLinkedList.getHead());
					}else{
						System.out.println((Integer)nextNode.getValue());
						//preNode=preNode.getNextNode().getNextNode();
					    cycleLinkedList.deleteNode(preNode);
					}
				j=1;
				count=cycleLinkedList.getSize();
			}
			else
				{
				   //�жϵ�ǰ�ڵ��Ƿ�Ϊͷ�ڵ�,����ǵĻ�,���α�������
				   if(preNode.getNextNode().getValue()!=null)
					   j++;
				   preNode=preNode.getNextNode();
				}
		}
		System.out.println("Last one: "+(Integer)cycleLinkedList.getHead().getNextNode().getValue());
	}

}
