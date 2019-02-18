package cn.com;

/*旅行售货员问题,依旧是用回溯方法来解决*/
public class Graph {
    int n;
    int adjMat[][];
    int []path;
    int curL;
    int []bestPath;
    int bestL;

    public  Graph(int n, int adjMat[][]){
        this.n=n;
        this.adjMat=adjMat;
        this.path=new int[n];
        for(int i=0; i<n; i++)
            this.path[i]=i;
        this.bestPath=new int[n];
        for(int i=0; i<n; i++)
            this.bestPath[i]=i;
        this.bestL=65535;
    }

    public void backTrack(int t){
        if(t==n-1){
            if(this.adjMat[this.path[t-1]][this.path[t]]!=65535&&this.adjMat[this.path[t]][this.path[0]]!=65535&&this.curL+this.adjMat[this.path[t-1]][this.path[t]]+this.adjMat[this.path[t]][this.path[0]]<bestL)
            {
                for(int i=0; i<n; i++)
                    this.bestPath[i]=this.path[i];
                this.bestL=this.curL+this.adjMat[this.path[t-1]][this.path[t]]+this.adjMat[this.path[t]][this.path[0]];

            }
        }

        for(int i=t; i<n; i++){
            if(this.adjMat[this.path[t-1]][this.path[t]]!=65535&&this.adjMat[this.path[t-1]][this.path[t]]+this.curL<bestL){
                swap(t,i);
                this.curL=this.curL+this.adjMat[this.path[t-1]][this.path[t]];
                backTrack(t+1);
                this.curL=this.curL-this.adjMat[this.path[t-1]][this.path[t]];
                swap(t,i);
            }
        }
    }

    public void swap(int i,int j){
        int temp=this.path[i];
        this.path[i]=this.path[j];
        this.path[j]=temp;
    }

    public void print(){
        for(int i=0; i<n; i++)
            System.out.print(this.bestPath[i]+" ");
        System.out.println();
    }
}
