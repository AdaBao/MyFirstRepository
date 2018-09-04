package cn.com;

public class Node implements Comparable<Node> {
	public char data;
	public Node lchild;
	public Node rchild;
	public int frequency;
	public String code="";
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.frequency>o.frequency)
		  return 1;
		else if(this.frequency==o.frequency)
			return 0;
		else return -1;
	}
}
