package cn.com;

//�Զ�������ĳ�ִ������ʹ���Ϊ�����������Ĺ��̳������������������ǰ�һ�ö�����ת�����˫������
public class ThreadedBinaryTree {
	Node root;
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	Node pre=null;//ʼ��ָ��ǰ�ڵ��ǰ��
	int index=0;
	//�����������������,���� ABC##DE#G##F###
	public  Node preOrderCreateTree(Object []o){
			if("#".equals(o[index])){
				index++;
				return null;
			}
			Node node=new Node();
			node.data=o[index];
			node.lchild=null;
			node.rchild=null;
			
			index++;
			
			node.lchild=preOrderCreateTree(o);
			node.rchild=preOrderCreateTree(o);
			return node;
		}
	
	//��������preOrderCreateTree
	public void createTree(Object []o){
		this.root=this.preOrderCreateTree(o);
	}

	//������������������� 
	public void inThreading(Node root){
		if(root==null)
			return;
		
		inThreading(root.lchild);
		if(root.lchild==null)//ǰ��
			{
			 
			    root.lchild=pre;
			    root.tag1=1;
			}
		if(pre!=null&&pre.rchild==null){//���
			
			pre.rchild=root;
			pre.tag2=1;
		}
		
		pre=root;
		inThreading(root.rchild);
	}
	
    //�����������������
	public void inOrderTraverse_Thr(){
		Node currentNode=this.root;
		
		while(currentNode!=null){
			while(currentNode.tag1==0)
				currentNode=currentNode.lchild;//���ҵ�����ߵĽڵ�    ��Ϊ��������������ҵ�˳��    ������Ҫ�ҵ�����ߵĽڵ�
			System.out.print(currentNode.data+" ");
		    while(currentNode.tag2==1)//���ϵĴ�ӡ��̽ڵ�   ֱ����̽ڵ����������Ϊֹ
		    {
		    	currentNode=currentNode.rchild;
		    	System.out.print(currentNode.data+" ");
		    }
		    
		    currentNode=currentNode.rchild;//��currentNodeָ���������ĵ�һ���ڵ�
		}
	}
	
	//�������
		public void preTraverse(Node root){
			if(root==null)
				return;
			System.out.print(root.data+" ");
			preTraverse(root.lchild);
			preTraverse(root.rchild);
		}

}
