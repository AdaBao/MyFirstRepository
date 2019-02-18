package cn.com;

public class Main {
    public static void main(String[] args){
        int n=9;
        int m=7;
        int [][]grid={
                {1,1,1,1,-1,1,1},
                {1,1,-1,1,1,1,1},
                {1,1,-1,1,-1,-1,1},
                {1,1,-1,1,1,1,1},
                {1,1,1,1,1,-1,1},
                {1,1,1,-1,-1,-1,1},
                {1,1,1,1,1,-1,1},
                {1,1,1,1,1,1,1},
                {1,1,-1,1,-1,1,1}
        };

        Node startingPoint=new Node();
        startingPoint.pre=null;
        startingPoint.row=2;
        startingPoint.col=1;

        Node endingPoint=new Node();
        endingPoint.pre=null;
        endingPoint.row=5;
        endingPoint.col=6;

        FindPath findPath=new FindPath(9,7,grid,startingPoint,endingPoint);
        findPath.runFindPath();

    }
}
