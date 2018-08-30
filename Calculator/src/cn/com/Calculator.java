package cn.com;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*使用栈来求四则运算表达式的值,方法是先将表达式转化为逆波兰式,然后再计算
 * 转化过程和计算过程都会用到栈
 * */

/*转化为逆波兰的准则：从左到右遍历中缀表达式的每个数字和符号，若是数字就输出，
 * 即成为后缀表达式的一部分；若是符号，则判断其与栈顶符号的优先级，是右括号或者优先级
 * 低于或者等于栈顶符号，则栈顶元素以此出栈并输出，并将当前符号进栈，一直到最终输出后缀表达式为止
 * */
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);      
        String expression=scanner.nextLine();//原表达式
        expression.replace(" ", "");//去掉表达式所有的空格       
        List<String> expressionList=new LinkedList<String>();//分隔后的表达式
        Stack stack1=new Stack<Character>();//用来存运算符,包括括号
        List<String> expressionRPN=new LinkedList<String>();//逆波兰表达式
        for(int i=0; i<expression.length(); i++){//首先要将输入的表达式分隔
        	if(!(expression.charAt(i)<='9'&&expression.charAt(i)>='0')){//如果是符号，就直接加入expressionList中
        		expressionList.add(expression.charAt(i)+"");
        		continue;
        	}
        	//如果不是符号，那么需要不断读取数字字符直到长度超出或者读到符号为止，并将得到的数字加入expressionList中
        	int end=i;
        	while(end+1<expression.length()&&expression.charAt(end+1)<='9'&&expression.charAt(end+1)>='0')
        			end++;        		
        	
        	expressionList.add(expression.substring(i, end+1));
        	i=end;
        }
        
        //System.out.println(expressionList);
        
        for(String str : expressionList){//遍历expressionList
        	if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")||str.equals("(")||str.equals(")")){//如果是符号
        		
        		    //如果符号是右括号
        			if(str.equals(")")){
        				//不断出栈，并将出栈的元素加入逆波兰表达式中，直到遇到左括号
        				while(true){
        					char c=((String)stack1.pop()).charAt(0);
        					if(c=='(')
        						break;
        					expressionRPN.add(c+"");
        				}
        			}else{//如果符号不是右括号
        				while(true){//循环的结束条件要根据栈顶元素和当前逆波兰表达式中获取到的字符的比较结果
        					if(stack1.isEmpty()){stack1.push(str);break;}
        					char c=((String)stack1.peek()).charAt(0);
        					
        					//比较栈顶元素和当前逆波兰表达式中获取到的字符，如果栈顶的优先级高于或者等于，则出栈，并将出栈的元素加入到逆波兰表达式中，并且一直循环，最后将当前逆波兰表达式中获取到的字符入栈
        					if((c=='*'||c=='/')&&(str.equals("+")||str.equals("-"))||(c=='*'||c=='/')&&(str.equals("*")||str.equals("/"))||(c=='+'||c=='-')&&(str.equals("+")||str.equals("-"))){
        						stack1.pop();
        						expressionRPN.add(c+"");
        					}else
        					{
        						stack1.push(str);
        						break;
        					}
        					
        				}
        			}
        			
        			
        		
        	}else{//如果是数
        		expressionRPN.add(str);//将数加入逆波兰表达式中
        	}
        }
        
        while(!stack1.isEmpty()){
        	expressionRPN.add((String)stack1.pop()+""); 
        }
        
        Stack stack2=new Stack<String>();
        for(String str:expressionRPN){
        	if(str.equals("+")){
        	 String	str1=(String)stack2.pop();
        	 String str2=(String)stack2.pop();
        	 stack2.push(Integer.parseInt(str1)+Integer.parseInt(str2)+""); 
        	}else if(str.equals("-")){
        	 String	str1=(String)stack2.pop();
           	 String str2=(String)stack2.pop();
           	 stack2.push(Integer.parseInt(str2)-Integer.parseInt(str1)+""); 
        		
        	}else if(str.equals("*")){
        	String	str1=(String)stack2.pop();
           	 String str2=(String)stack2.pop();
           	 stack2.push(Integer.parseInt(str1)*Integer.parseInt(str2)+"");
        	}else if(str.equals("/")){
        	String	str1=(String)stack2.pop();
           	 String str2=(String)stack2.pop();
           	 stack2.push(Integer.parseInt(str2)/Integer.parseInt(str1)+"");
        	}else{
        		stack2.push(str);
        	}
        }
        
        System.out.println(stack2.peek());
 
	}
	
	

}
