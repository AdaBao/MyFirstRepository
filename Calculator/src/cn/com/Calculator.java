package cn.com;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*ʹ��ջ��������������ʽ��ֵ,�������Ƚ����ʽת��Ϊ�沨��ʽ,Ȼ���ټ���
 * ת�����̺ͼ�����̶����õ�ջ
 * */

/*ת��Ϊ�沨����׼�򣺴����ұ�����׺���ʽ��ÿ�����ֺͷ��ţ��������־������
 * ����Ϊ��׺���ʽ��һ���֣����Ƿ��ţ����ж�����ջ�����ŵ����ȼ����������Ż������ȼ�
 * ���ڻ��ߵ���ջ�����ţ���ջ��Ԫ���Դ˳�ջ�������������ǰ���Ž�ջ��һֱ�����������׺���ʽΪֹ
 * */
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);      
        String expression=scanner.nextLine();//ԭ���ʽ
        expression.replace(" ", "");//ȥ�����ʽ���еĿո�       
        List<String> expressionList=new LinkedList<String>();//�ָ���ı��ʽ
        Stack stack1=new Stack<Character>();//�����������,��������
        List<String> expressionRPN=new LinkedList<String>();//�沨�����ʽ
        for(int i=0; i<expression.length(); i++){//����Ҫ������ı��ʽ�ָ�
        	if(!(expression.charAt(i)<='9'&&expression.charAt(i)>='0')){//����Ƿ��ţ���ֱ�Ӽ���expressionList��
        		expressionList.add(expression.charAt(i)+"");
        		continue;
        	}
        	//������Ƿ��ţ���ô��Ҫ���϶�ȡ�����ַ�ֱ�����ȳ������߶�������Ϊֹ�������õ������ּ���expressionList��
        	int end=i;
        	while(end+1<expression.length()&&expression.charAt(end+1)<='9'&&expression.charAt(end+1)>='0')
        			end++;        		
        	
        	expressionList.add(expression.substring(i, end+1));
        	i=end;
        }
        
        //System.out.println(expressionList);
        
        for(String str : expressionList){//����expressionList
        	if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")||str.equals("(")||str.equals(")")){//����Ƿ���
        		
        		    //���������������
        			if(str.equals(")")){
        				//���ϳ�ջ��������ջ��Ԫ�ؼ����沨�����ʽ�У�ֱ������������
        				while(true){
        					char c=((String)stack1.pop()).charAt(0);
        					if(c=='(')
        						break;
        					expressionRPN.add(c+"");
        				}
        			}else{//������Ų���������
        				while(true){//ѭ���Ľ�������Ҫ����ջ��Ԫ�غ͵�ǰ�沨�����ʽ�л�ȡ�����ַ��ıȽϽ��
        					if(stack1.isEmpty()){stack1.push(str);break;}
        					char c=((String)stack1.peek()).charAt(0);
        					
        					//�Ƚ�ջ��Ԫ�غ͵�ǰ�沨�����ʽ�л�ȡ�����ַ������ջ�������ȼ����ڻ��ߵ��ڣ����ջ��������ջ��Ԫ�ؼ��뵽�沨�����ʽ�У�����һֱѭ������󽫵�ǰ�沨�����ʽ�л�ȡ�����ַ���ջ
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
        			
        			
        		
        	}else{//�������
        		expressionRPN.add(str);//���������沨�����ʽ��
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
