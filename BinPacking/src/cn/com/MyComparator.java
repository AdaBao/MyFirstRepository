/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public  class MyComparator implements Comparator<BigDecimal>{

        @Override
        public int compare(BigDecimal o1, BigDecimal o2) {
            if(o1.compareTo(o2)>0)
                return -1;
            else if(o1.compareTo(o2)==0)
                return 0;
            else
                return 1;
        }

    }
