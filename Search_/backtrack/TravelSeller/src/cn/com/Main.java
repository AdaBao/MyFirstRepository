package cn.com;

public class Main {
    public static void main(String[] args){
        int n=5;
        int [][]adjMat={{0,10,65535,4,12},{10,0,15,8,5},{65535,15,0,7,30},{4,8,7,0,6},{12,5,30,6,0}};

        Graph graph=new Graph(5,adjMat);
        graph.backTrack(1);
        graph.print();
    }
}
