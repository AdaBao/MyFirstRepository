package cn.com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/*
* 迪杰斯特拉算法求最短路径
*
* 1 首先选择起始节点作为当前 "待扩展节点"
* 2 dis数组表示起始节点到各个节点的距离,初始除了到第0个节点也就是起始节点的距离为0,到剩下节点的距离都是无穷大,这里用65535表示
* 3 需要一个有序集合来表示已经被选中的节点以及它们的顺序(程序中的ArrayList和visited数组即为此),表示已经找到的最短路径的部分路径,待扩展节点是刚刚加入集合的节点即当前的最后一个节点,这部分路径的长度用pathLen来表示
* 4 有若干个与待扩展节点直接相连并且尚未被访问的节点,待扩展节点是curPoint,与待扩展节点直接相连的节点是i,如果pathLen+this.adjMat[curPoint][i]<dis[i],则更新dis[i]即起始节点到i节点的距离
* 5 从dis数组中挑选值最小的元素所对应的节点并且该节点尚未被访问,将该新节点加入3所提到的有序集合(更新ArrayList和visited数组),新节点也即下一个待扩展节点
* 6 重复4和5直至找到终点
* */
public class MGraph {
    int vertexNum;
    int [][]adjMat;//邻接矩阵

    public MGraph(int vertexNum,int [][]adjMat){
        this.vertexNum=vertexNum;
        this.adjMat=adjMat;
    }

    public void getShortestPath(int target){
        boolean []visited=new boolean[this.vertexNum];//节点是否已经被访问即是否已经被加入到了最短路径中
        int[] dis=new int[this.vertexNum];//表示起始节点到各个节点的距离
        for(int i=1; i<this.vertexNum; i++){
            visited[i]=false;
            dis[i]=65535;
        }
        visited[0]=true;
        dis[0]=0;

        List<Integer> list1=new LinkedList<>();//最短路径,链表中元素的顺序即为路径中节点的顺序
        list1.add(new Integer(0));
        int curPoint=0;//当前待扩展节点,就是已经找到的部分最短路径的最后一个节点
        int pathLen=0;//最短路径的长度

        while(curPoint!=target){
            for(int i=1; i<this.vertexNum; i++){
                if(!visited[i]){
                    if(pathLen+this.adjMat[curPoint][i]<dis[i]){
                        dis[i]=pathLen+this.adjMat[curPoint][i];
                    }
                }
            }

            int minLen=65535;
            int nextPoint=-1;
            for(int i=1; i<this.vertexNum; i++){
                if(!visited[i]){
                    if(dis[i]<minLen)
                    {
                        minLen=dis[i];
                        nextPoint=i;
                    }
                }
            }

            list1.add(new Integer(nextPoint));
            visited[nextPoint]=true;
            curPoint=nextPoint;
        }

        Iterator<Integer> iterator=list1.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }
}
