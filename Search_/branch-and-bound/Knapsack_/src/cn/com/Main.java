package cn.com;

public class Main {
    public static void main(String[] args){
        /*int n=4;
        int []w={3,5,2,1};
        int []v={9,10,7,4};
        int c=7;*/

        /*int n=5,c=10;
        int w[]={2,6,4,1,5};
        int v[]={6,9,6,1,4};*/

        /*int n=5;
        int []w={2,2,6,5,4};
        int []v={6,3,5,4,6};
        int c=10;*/

        int n=5,c=11;
        int w[]={3,5,7,8,9};
        int v[]={4,6,7,9,10};

        Knapsack knapsack=new Knapsack(n,w,v,c);
        knapsack.branchAndBound();
        knapsack.showResult();
    }
}
