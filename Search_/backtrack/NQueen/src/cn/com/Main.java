package cn.com;

public class Main {
    public static void main(String[] args){
        Graph graph=new Graph(8);
        graph.backtrace(1);
        System.out.println(graph.num);
    }
}
