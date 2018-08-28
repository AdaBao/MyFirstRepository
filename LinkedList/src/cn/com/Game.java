package cn.com;

import java.util.Scanner;

/*
 * 游戏规则：N个人围成一个圈，从第一个人开始传花，当数到M时，该人退出游戏，直到剩下最后一个人。
 * */

/*分析:
 * 终止条件:只剩最后一个人
 * if分支:是否数到M
 * 特殊情况:头节点
 * 初始变量:报数计数器,当前节点的前驱,链表大小
 * 命中操作:删除节点
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
		
		//count用来表示链表的大小
		int count=cycleLinkedList.getSize();
		//表示当前节点的前一节点
		preNode=cycleLinkedList.getHead();
		//表示报数
		int j=1;
	    //判断当前链表大小是否为1
		while(count!=1){
			//分两种情况,分别是选中和未选中
			
			if(j%selected==0)
			{
			    //得到当前节点
				Node nextNode=preNode.getNextNode();
				//判断当前节点是否为头节点
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
				   //判断当前节点是否为头节点,如果是的话,本次报数不算
				   if(preNode.getNextNode().getValue()!=null)
					   j++;
				   preNode=preNode.getNextNode();
				}
		}
		System.out.println("Last one: "+(Integer)cycleLinkedList.getHead().getNextNode().getValue());
	}

}
