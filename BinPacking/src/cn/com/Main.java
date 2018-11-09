/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner=new Scanner(System.in);
        int binCount=3;
        BigDecimal [] weight={new BigDecimal(0.1),new BigDecimal(0.2),new BigDecimal(0.3),new BigDecimal(0.4),new BigDecimal(0.5),new BigDecimal(0.7),new BigDecimal(0.8)};
        FFD(binCount,weight);
        
//        for(int i=0; i<weight.length; i++)
//            System.out.print(weight[i]+" ");
        
    }
    
    //首次适应递减算法，先要排序，先把所有物品降序排序，然后使用首次适应算法
    static void FFD(int binCount,BigDecimal []weight ){
        if(weight==null||weight.length==0)
            return;
        
        //自定义的比较器用于降序排序
        MyComparator myComparator=new MyComparator();
        Arrays.sort(weight, myComparator);
        
        //用于记录装箱情况和箱子容量
        ArrayList [] record=new ArrayList[binCount];
        for(int i=0; i<record.length; i++){
            record[i]=new ArrayList<Integer>();
        }
        BigDecimal []remainingCapacity=new BigDecimal[binCount];
        for(int i=0; i<binCount; i++){
            remainingCapacity[i]=new BigDecimal(1);
        }
        
        //装箱
        for(int i=0; i<weight.length; i++){
            for(int j=0; j<binCount; j++){
               //要设置保留1位小数，因为double类型不能之间判断是否相等，由于十进制和二进制之间的转换，导致真正存储的浮点数并不是真实的结果，即使是使用了高精度浮点数BigDecimal。或者可以让两个double做减法去判断是否相等。
                if(weight[i].setScale(1, BigDecimal.ROUND_HALF_UP).compareTo(remainingCapacity[j].setScale(1, BigDecimal.ROUND_HALF_UP))<0||weight[i].setScale(1, BigDecimal.ROUND_HALF_UP).compareTo(remainingCapacity[j].setScale(1, BigDecimal.ROUND_HALF_UP))==0)
                {
                    record[j].add(new Integer(i));
	            remainingCapacity[j]=remainingCapacity[j].subtract(weight[i]);  
                     //System.out.print(remainingCapacity[j].setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()+" ");
                    break;
                }
                
//                if(j==binCount-1)
//                    return;
            }
        }
       for(int i=0; i<record.length; i++){
           for(int j=0; j<record[i].size(); j++){
               System.out.print(weight[(Integer)record[i].get(j)].setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()+" ");
           }
           System.out.println();
       }
          
    }
    
    
    
    
}


