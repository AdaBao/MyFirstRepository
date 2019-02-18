package cn.com;

/*回溯法解决n后问题*/
public class Graph {
    int n;
    int x[][];
    int num=0;
    public Graph(int n){
        this.n=n;
        this.x=new int[n+1][n+1];

        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++){
                this.x[i][j]=0;
            }
    }

    public boolean place(int t,int k){
        for(int i=1; i<=n; i++){
            if(t!=i&&x[i][k]==1)
                return false;
        }

        int row=t;
        int col=k;
        while(++row<=n&&++col<=n){
            if(x[row][col]==1)
                return false;
        }
        row=t;
        col=k;
        while(++row<=n&&--col>=1){
            if(x[row][col]==1)
                return false;
        }
        row=t;
        col=k;
        while(--row>=1&&--col>=1){
            if(x[row][col]==1)
                return false;
        }
        row=t;
        col=k;
        while(--row>=1&&++col<=n){
            if(x[row][col]==1)
                return false;
        }
        return true;
    }

    public void backtrace(int t){
        if(t>n)
        {
            this.num++;
            return;
        }
        for(int i=1; i<=this.n; i++){
            if(place(t,i))
            {
                this.x[t][i]=1;
                backtrace(t+1);
                this.x[t][i]=0;
            }
        }
    }

}
