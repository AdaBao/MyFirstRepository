package cn.com;

public class Main {
    public static void main(String[] args){
        /*int n=5,capacity=10;
        int weight[]={2,6,4,1,5};
        int value[]={6,9,6,1,4};*/
        int n=5,capacity=11;
        int weight[]={3,5,7,8,9};
        int value[]={4,6,7,9,10};
       /* int n=5,capacity=10;
        int weight[]={2,2,6,5,4};
        int value[]={6,3,5,4,6};*/
        Graph graph=new Graph(n,weight,value,capacity);
        graph.backTrack(0);
        graph.print();
    }
}
