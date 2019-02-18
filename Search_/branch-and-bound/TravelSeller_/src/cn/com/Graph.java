package cn.com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*旅行售货员问题,*/
public class Graph {
    int n;
    int adjMat[][];
    int bestCost;
    Node bestN;
    Queue<Node> queue;

    public  Graph(int n, int adjMat[][]){
        this.n=n;
        this.adjMat=adjMat;
        this.bestCost=65535;
        this.queue=new LinkedList<>();
        Node node=new Node();
        node.cityQuantity=1;
        node.totalCost=0;
        node.path=new int[1];
        node.path[0]=0;
        this.queue.offer(node);
    }

    public void branchAndBound(){
        while(!this.queue.isEmpty()){
            Node here=this.queue.poll();
            if(here.cityQuantity==this.n){
                if(here.totalCost+this.adjMat[here.path[here.cityQuantity-1]][0]<this.bestCost){
                    bestN=here;
                    bestCost=here.totalCost+this.adjMat[here.path[here.cityQuantity-1]][0];
                    continue;
                }
            }
            for(int i=0; i<this.n; i++){
                if(this.adjMat[here.path[here.cityQuantity-1]][i]<65535&&this.adjMat[here.path[here.cityQuantity-1]][i]>0&&!contain(here.path,i)&&here.totalCost+this.adjMat[here.path[here.cityQuantity-1]][i]<bestCost)
                {
                    Node next=new Node();
                    next.totalCost=here.totalCost+this.adjMat[here.path[here.cityQuantity-1]][i];
                    next.cityQuantity=here.cityQuantity+1;
                    next.path=new int[next.cityQuantity];
                    System.arraycopy(here.path,0,next.path,0,here.path.length);
                    next.path[next.cityQuantity-1]=i;
                    this.queue.offer(next);
                }
            }


        }
    }

    public boolean contain(int path[],int city){
        for(int i=0; i<path.length; i++){
            if(path[i]==city)
                return true;
        }
        return false;
    }


    public void print(){
       int[] path=this.bestN.path;
       for(int i=0; i<path.length; i++){
           System.out.print(path[i]+" ");
       }
    }
}
