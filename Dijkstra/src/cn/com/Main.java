package cn.com;

public class Main {
    public static void main(String[] args){
        int vertexNum=6;
        int [][]adjMat={{0,1,12,65535,65535,65535},
                {65535,0,9,3,65535,65535},
                {65535,65535,0,65535,5,65535},
                {65535,65535,4,0,13,15},
                {65535,65535,65535,65535,0,4},
                {65535,65535,65535,65535,65535,0}
        };

        MGraph mGraph=new MGraph(vertexNum,adjMat);
        mGraph.getShortestPath(vertexNum-1);
    }
}
