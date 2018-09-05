package cn.com;

import java.util.Scanner;
import java.util.Stack;

/*�������ʽ��,�������������ӡ����,����׺���ʽת��Ϊ���ʽ��,ÿ�ζ���һ������,���������
 * ������,��ѹջ;��������ǲ�����,�ʹ�ջ�е����������γ�һ������,����������ջ*/
//a b + c d e + * *
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String expression=scanner.nextLine();
		String[] expressionArr=expression.split(" ");
		Stack stack=new Stack<Node>();
		for(int i=0; i<expressionArr.length; i++){
			if((!expressionArr[i].equals("+"))&&(!expressionArr[i].equals("*"))){
				Node node=new Node();
				node.c=expressionArr[i].charAt(0);
				stack.push(node);
			}else{
				Node node=new Node();
				node.c=expressionArr[i].charAt(0);
				//node.lchild=(Node)stack.pop();
				//node.rchild=(Node)stack.pop();
				Node rchild=(Node)stack.pop();
				Node lchild=(Node)stack.pop();
				node.lchild=lchild;
				node.rchild=rchild;
				stack.push(node);
			}
		}
		
		Node root=(Node)stack.pop();
		
	   preTraverse(root);

	}
	
	//���������ӡ��
	static void preTraverse(Node root){
		if(root==null)
			return;
		System.out.print(root.c+" ");
		preTraverse(root.lchild);
		preTraverse(root.rchild);
		
	}

}
