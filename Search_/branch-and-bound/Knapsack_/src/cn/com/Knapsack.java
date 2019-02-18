package cn.com;

import java.util.LinkedList;
import java.util.Queue;

public class Knapsack {
    int n;//物体个数
    int []w;//物体重量
    int []v;//物体价值
    int c;//背包容量
    int []mapping;//排序后的物体与先前顺序之间的映射
    Queue<Node> queue;//
    int bestP;
    Node bestN;

    public Knapsack(int n,int []w,int []v,int c){
        this.n=n;
        this.w=w;
        this.v=v;
        this.c=c;
        this.mapping=new int[n];
        for(int i=0; i<n; i++)
            this.mapping[i]=i;
        float []unit_price=new float[n];
        for(int i=0; i<n; i++){
            unit_price[i]=(float)v[i]/w[i];
        }

        for(int i=0; i<n-1; i++){
            for(int j=n-1; j>=i+1; j--){
                if(unit_price[j]>unit_price[j-1]){
                    swap(unit_price,j,j-1);
                    swap(w,j,j-1);
                    swap(v,j,j-1);
                    swap(mapping,j,j-1);
                }
            }
        }

        this.queue=new LinkedList<>();

    }

    public   void swap(float []arr, int i, int j){
        float temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public  void swap(int []arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public void branchAndBound(){
        Node first=new Node();
        first.no=-1;
        first.parent=null;
        first.totalV=0;
        first.totalW=0;

        this.queue.offer(first);

        while(!queue.isEmpty()){
            Node here=this.queue.poll();
            if(here.no==this.n-1)//到了叶子节点(最后一个物体)
            {
                if(here.totalV>bestP)
                {
                    bestP=here.totalV;
                    bestN=here;
                }
                continue;
            }
            int childNo=here.no+1;
            if(here.totalW+this.w[childNo]<=this.c){
                Node leftNode=new Node();
                leftNode.place=true;
                leftNode.no=childNo;
                leftNode.parent=here;
                leftNode.totalW=here.totalW+this.w[childNo];
                leftNode.totalV=here.totalV+this.v[childNo];
                queue.offer(leftNode);
            }

            if(here.totalV+bound(childNo,this.c-here.totalW)>bestP){
                Node rightNode=new Node();
                rightNode.place=false;
                rightNode.no=childNo;
                rightNode.parent=here;
                rightNode.totalW=here.totalW;
                rightNode.totalV=here.totalV;
                queue.offer(rightNode);
            }
        }
    }

    public int bound(int t,int rc){
        if(t>=n)
            return 0;
        int rp=0;
        while(t<n&&rc-this.v[t]>0){
            rp=rp+this.v[t];
            rc=rc-this.v[t];
            t=t+1;
        }

        if(t<n&&rc>0){
            rp=rp+rc*(this.v[t]/this.w[t]);
        }
        return rp;

    }

    public void showResult(){
        Node node=bestN;
        while(node.no!=-1){
            if(node.place==true)
            System.out.print(this.mapping[node.no]+" ");
            node=node.parent;
        }
    }
}
