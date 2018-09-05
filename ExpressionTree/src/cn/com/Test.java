package cn.com;

import java.util.Scanner;
import java.util.Stack;

/*构建表达式树,并用先序遍历打印出来,将后缀表达式转化为表达式树,每次读入一个符号,如果符号是
 * 操作数,则压栈;如果符号是操作符,就从栈中弹出两棵树形成一棵新树,并将新树入栈*/
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
	
	//先序遍历打印树
	static void preTraverse(Node root){
		if(root==null)
			return;
		System.out.print(root.c+" ");
		preTraverse(root.lchild);
		preTraverse(root.rchild);
		
	}

}
