/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl1;

import java.util.Arrays;

/**
 *
 * @author Michael
 */
public class Exchangewh {
    
    public int []here(int[][] arry,int [] pri ,int start,int [] a, int length){
    exchange bb = new exchange();
    WCT cc = new WCT();
    int best = cc.a(arry, pri, a, length);
    int [] sta = a;
    for(int i = start; i < length - 1; i++){
        cc.a(arry, pri, a, length);
        a = bb.exx(a, start, i);
        int [] betterarray = here(arry,pri,start+1,a,length-1);
       // System.out.println(Arrays.toString(betterarray));
        int check = cc.a(arry, pri,betterarray, a.length);
           if(check < best){
               best = check;
               System.arraycopy(betterarray, 0, sta, 0, length);
           }
    }
    
    
    return sta;}
    
}
