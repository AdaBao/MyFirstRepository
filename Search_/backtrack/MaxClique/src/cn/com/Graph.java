package cn.com;

/*
* 使用回溯的方法来解决最大团问题，回溯法在问题的解空间树中，按深度优先策略，
* 从根结点出发搜索解空间树。算法搜索至解空间树的任意一点时，先判断该结点是否包含问题的解。
* 如果肯定不包含，则跳过对该结点为根的子树的搜索，逐层向其祖先结点回溯；否则，进入该子树，
* 继续按深度优先策略搜索。
 * */

public class Graph {
    int vertexNum; //从1开始
    int adjMat[][];//邻接矩阵
    int cn=0;//当前团的顶点数量
    int bestn=0;//最好的团的顶点数量
    int []x;//当前的团
    int []bestx;//最好的团

    public Graph(){
        this.vertexNum=5;
        this.adjMat=new int[this.vertexNum+1][this.vertexNum+1];
        for(int i=1; i<=this.vertexNum; i++)
            for(int j=i+1; j<=this.vertexNum; j++)
            {
                this.adjMat[i][j]=0;
            }
        this.adjMat[2][1]=1;
        this.adjMat[2][3]=1;
        this.adjMat[1][3]=1;
        this.adjMat[1][4]=1;
        this.adjMat[1][5]=1;
        this.adjMat[3][4]=1;
        this.adjMat[3][5]=1;
        this.adjMat[4][5]=1;

        this.adjMat[1][2]=1;
        this.adjMat[3][2]=1;
        this.adjMat[3][1]=1;
        this.adjMat[4][1]=1;
        this.adjMat[5][1]=1;
        this.adjMat[4][3]=1;
        this.adjMat[5][3]=1;
        this.adjMat[5][4]=1;

        this.x=new int[this.vertexNum+1];
        this.bestx=new int[this.vertexNum+1];

        for(int i=1; i<=this.vertexNum; i++){
            this.x[i]=0;
            this.bestx[i]=0;
        }

    }

    public boolean place(int t){
        boolean b=true;
        for(int i=1; i<=this.vertexNum; i++){
            if(this.x[i]==1){
                if(this.adjMat[t][i]!=1){
                    b=false;
                    break;
                }
            }
        }
        return b;
    }

    public void backstrack(int t){
        if(t>this.vertexNum){

            for(int i=1; i<=this.vertexNum; i++){
                this.bestx[i]=this.x[i];
            }
            bestn=cn;
            //this.print();
            return;
        }
        if(place(t)){
           this.x[t]=1;
           cn++;
           backstrack(t+1);
           this.x[t]=0;
           cn--;
        }
        if(cn+(this.vertexNum-t+1)>bestn){
            this.x[t]=0;
            backstrack(t+1);
        }
    }

    public void print(){
        for(int i=1; i<=this.vertexNum; i++){
            if(this.bestx[i]==1)
            System.out.print(i+" ");
        }
    }
}
