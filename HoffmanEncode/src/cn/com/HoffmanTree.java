package cn.com;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class HoffmanTree {
	Node root;
	List nodeList;
	
	
	public void initNodeList(String str){
		nodeList=new LinkedList<Node>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<str.length(); i++){
			String var=String.valueOf(str.charAt(i));
			if(!map.containsKey(var)){
				map.put(var, 1);
			}else{
				int time=map.get(var);
				map.put(var,time+1);
			}
		}
		
		for(Entry<String,Integer> entry:map.entrySet()){
			Node node=new Node();
			String key=entry.getKey();
			Integer value=entry.getValue();
			node.data=key.charAt(0);
			node.frequency=value;
			node.lchild=null;
			node.rchild=null;
			this.nodeList.add(node);
		}
		Collections.sort(this.nodeList);
	}
	
	//建立树的同时进行编码,每个节点除了根节点外都有一个code,code值为0或者1
	public void buildTree(){
		while(this.nodeList.size()>1){
			Node lchild=(Node)nodeList.get(0);
			Node rchild=(Node)nodeList.get(1);
			lchild.code="0";
			rchild.code="1";
			nodeList.remove(0);
			nodeList.remove(0);
			Node parentNode=new Node();
			parentNode.frequency=lchild.frequency+rchild.frequency;
			parentNode.lchild=lchild;
			parentNode.rchild=rchild;
			nodeList.add(parentNode);
			Collections.sort(nodeList);
		}
		
		root=(Node)nodeList.get(0);
	}
	
	//先序遍历输出编码   方法并不是字符串的累加,每次编码多一个0,就乘2;多个1,就乘2加1.code的初始值为1,所以每个字符的编码串的第一位都会多个1
	public void outputCode(Node node,int code){
		if(node.code.equals("0"))
		{
			code=code*2;
		}else if(node.code.equals("1")){
			code=code*2+1;
		}else{//根节点没有code
			code=1;
		}
		
		if(node.lchild==null&&node.rchild==null){//说明当前节点是叶子节点
			String result = Integer.toBinaryString(code);//将整型转化未二进制
			System.out.print(node.data+" ");
			if(result.length()==1)
				System.out.println(result);
			else{
				System.out.println(result.substring(1));
			}
			return;
		}
		
		outputCode(node.lchild,code);
		outputCode(node.rchild,code);
			
	}
	
	public Node getRoot(){
		return this.root;
	}

}
