package bit.bth;
import java.util.Scanner;

public class FirstClass {
	static int index=0;
	public static void main(String[] args) {
	  int treeNodeNum=0;
	  Scanner scanner=new Scanner(System.in);
	  String treeValueStr= scanner.nextLine();
	  String []treeValueArray=treeValueStr.split(" ");
	  treeNodeNum=treeValueArray.length;
	  int []treeNodeValue=new int[treeNodeNum];
	  for(int i=0; i<treeNodeNum; i++){
		  treeNodeValue[i]=Integer.parseInt(treeValueArray[i]);
	  }
	  
	  TreeNode head=new TreeNode();
	  TreeNode curNode=head;
	  curNode.setParentNode(null);
	  buildBinaryTree(curNode,treeNodeValue);
	 
	  System.out.print("please input value you want:");
	  int key=scanner.nextInt();
	  TreeNode result=searchBST(head,key);
	  
	  if(result==null)
		  System.out.println("not exist");
	  else
		  System.out.println("exist");
	  System.out.print("please input value you want to insert:");
	  key=scanner.nextInt();
	  insertValue(head,key);
	   System.out.print("please input value you want to delete:");
	   key=scanner.nextInt();
	 TreeNode rootNode= deleteValue(head,key);
	 if(rootNode!=null){
		 head=rootNode;
	 }
	 PreTraverse(head);
	}
	
	public static void buildBinaryTree(TreeNode curNode,int []treeNodeValue){
		curNode.setValue(treeNodeValue[index]);
		
		index++;
		if(treeNodeValue[index]!=-1)
		{
			TreeNode leftNode=new TreeNode();
			curNode.setLeftNode(leftNode);
			leftNode.setParentNode(curNode);
			buildBinaryTree(curNode.getLeftNode(),treeNodeValue);
		}
		
		index++;
		if(treeNodeValue[index]!=-1)
		{
			TreeNode rightNode=new TreeNode();
			curNode.setRightNode(rightNode);
			rightNode.setParentNode(curNode);
			buildBinaryTree(curNode.getRightNode(),treeNodeValue);
		}
	}
	
	public static TreeNode searchBST(TreeNode node, int key){
		if(node==null) return null;
		if(node.getValue()==key)
			{
			   return node;
			}
		if(key<node.getValue())
			return searchBST(node.getLeftNode(),key);
		else
			return searchBST(node.getRightNode(),key);
	}

	public static void PreTraverse(TreeNode curNode){
		System.out.print(curNode.getValue()+" ");
		if(curNode.getLeftNode()!=null)
		{
			PreTraverse(curNode.getLeftNode());
		}
		
		if(curNode.getRightNode()!=null)
		{
			PreTraverse(curNode.getRightNode());
		}
		
	}
	public static void insertValue(TreeNode curNode,int value){
		if(curNode.getValue()==value){
			System.out.println("value has existed!");
		}else if(value<curNode.getValue()){
			if(curNode.getLeftNode()==null){
				TreeNode node=new TreeNode();
				node.setValue(value);
				curNode.setLeftNode(node);
				System.out.println("insert success");
			}else{
				insertValue(curNode.getLeftNode(),value);
			}
		}else{
			if(curNode.getRightNode()==null){
				TreeNode node=new TreeNode();
				node.setValue(value);
				curNode.setRightNode(node);
				System.out.println("insert success");
			}else{
				insertValue(curNode.getRightNode(),value);
			}
		}
	}

	public static TreeNode deleteValue(TreeNode curNode,int value){
		
		TreeNode node=searchBST(curNode,value);
		if(node==null)
			curNode=null;
		else{
			TreeNode leftNode=node.getLeftNode();
			TreeNode rightNode=node.getRightNode();
			
			if(leftNode==null&&rightNode==null){
				if(node.getParentNode()==null)
				{
					System.out.println("Tree has only one node");
				}
				else{
					TreeNode parentNode=node.getParentNode();
					parentNode.setLeftNode(null);
					parentNode.setRightNode(null);
				}
			}else if(leftNode==null&&rightNode!=null){
				
				if(node.getParentNode()==null){
					curNode=node.getRightNode();
					curNode.setParentNode(null);
				}else{
					
					
					//node.getParentNode().setRightNode(node.getRightNode());
					if(node.getParentNode().getLeftNode()==node){
						node.getParentNode().setLeftNode(node.getRightNode());
						
					}else{
						node.getParentNode().setRightNode(node.getRightNode());
					}
				}
				//node.setRightNode(node.getRightNode());
				
			}else if(leftNode!=null&&rightNode==null){

				
				if(node.getParentNode()==null){
					curNode=node.getLeftNode();
					curNode.setParentNode(null);
				}else{
					//node.getParentNode().setLeftNode(node.getLeftNode());
					
					if(node.getParentNode().getLeftNode()==node){
						node.getParentNode().setLeftNode(node.getLeftNode());
					}else{
						node.getParentNode().setRightNode(node.getLeftNode());
					}
				}
			}else{
				TreeNode node_=node.getLeftNode();
				while(node_.getRightNode()!=null){
					node_=node_.getRightNode();
				}
				
				node_.setRightNode(node.getRightNode());
				if(node.getParentNode()!=null)//如果不是根节点
				node.getParentNode().setLeftNode(node.getLeftNode());
				else
				{
					curNode=node.getLeftNode();
				}
			}
		}
		return curNode;
	}
}

