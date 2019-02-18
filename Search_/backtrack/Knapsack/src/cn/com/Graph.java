package cn.com;

/*
* 回溯法解决01背包问题,代码还可以再改进,在求解01背包问题之前对物体按照单位重量的价值
* 进行排序,限界条件中(bound)就可以让剩下物体按照单位重量价值的递减顺序逐个放,直至把背包
* 放满,得到理想的最优解的价值,这样更合理
* */
public class Graph {
    int n;//物体数量
    int []weight;//每个物体的重量
    int []value;//每个物体的价值
    int capacity;//背包容量
    int w;//当前已放入物体的总重量
    int v;//当前已放入物体的总价值
    int []x;//当前已放入的物体
    int bestv;//
    int bestx[];//最佳物体放入

    public Graph(int n,int[] weight,int[] value,int capacity){
        this.n=n;
        this.weight=weight;
        this.value=value;
        this.capacity=capacity;
        this.w=0;
        this.v=0;
        this.x=new int[n];
        for(int i=0; i<n; i++)
            this.x[i]=0;
        this.bestx=new int[n];
        for(int i=0; i<n; i++)
            this.bestx[i]=0;
    }

    public void backTrack(int t){
        if(t>=n){
            bestv=0;
            for(int i=0; i<n; i++){
                this.bestx[i]=this.x[i];
                if(this.x[i]==1)
                    bestv=bestv+this.value[i];
            }
            return;
        }

        if(this.w+this.weight[t]<=capacity){
            this.w=this.w+this.weight[t];
            this.v=this.v+this.value[t];
            this.x[t]=1;
            backTrack(t+1);
            this.w=this.w-this.weight[t];
            this.v=this.v-this.value[t];
            this.x[t]=0;
        }

        if(this.bound(t)>this.bestv){
            this.x[t]=0;
            backTrack(t+1);
        }

    }

    public int bound(int t){
        int totalValue=this.v;
        for(int i=t+1; i<this.n; i++)
            totalValue=totalValue+this.value[i];
        return totalValue;
    }

    public void print(){
        for(int i=0; i<n; i++){
            if(this.bestx[i]==1)
                System.out.print(i+" ");
        }
        System.out.println();
    }
}
