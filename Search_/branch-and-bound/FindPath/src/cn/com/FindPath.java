package cn.com;


import java.util.LinkedList;
import java.util.Queue;

/*布线问题，使用分支限界法，分支定界法基于宽度有限的搜索方法
* 难点在于找到终点之后,需要逆着得到路径,可以在每个节点中加入pre
* */
public class FindPath {
    int n;
    int m;
    int [][]grid;

    Queue<Node> queue;
    Node startingPoint;
    Node endingPoint;
    public FindPath(int n,int m,int [][]grid,Node startingPoint, Node endingPoint){
        this.n=n;
        this.m=m;
        this.grid=grid;
        this.queue=new LinkedList<>();
        this.startingPoint=startingPoint;
        this.endingPoint=endingPoint;
    }

    public void runFindPath(){
        Node here=this.startingPoint;
        do{
            //上下左右
            Node up=new Node();
            up.pre=here;
            up.row=here.row-1;
            up.col=here.col;
            if(up.row>=0&&this.grid[up.row][up.col]!=-1)
            {
                this.queue.offer(up);
            }

            Node down=new Node();
            down.pre=here;
            down.row=here.row+1;
            down.col=here.col;
            if(down.row<n&&this.grid[down.row][down.col]!=-1)
            {
                this.queue.offer(down);
            }

            Node left=new Node();
            left.pre=here;
            left.row=here.row;
            left.col=here.col-1;
            if(left.col>=0&&this.grid[left.row][left.col]!=-1)
            {
                this.queue.offer(left);
            }

            Node right=new Node();
            right.pre=here;
            right.row=here.row;
            right.col=here.col+1;
            if(right.col<m&&this.grid[right.row][right.col]!=-1)
            {
                this.queue.offer(right);
            }
            here=this.queue.poll();
        }while(!(here.row==this.endingPoint.row&&here.col==this.endingPoint.col));

        while(here!=null){
            System.out.println(here.row+" "+here.col);
            here=here.pre;
        }
    }


}
