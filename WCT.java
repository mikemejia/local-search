/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl1;

/**
 *
 * @author Michael
 */
public class WCT {
   
    public int a(int arry[][], int weight[], int a[], int e){
        int wct = 0;
        
        
        int sum[][]= new int[arry.length][e];
        sum[0][0]=arry[0][a[0]];
        
    for(int i = 0; i<arry.length;i++){
        if(i>0){
        sum[i][0]= arry[i][a[0]]+sum[i-1][0];
        }
        if(i==arry.length-1){
           wct = wct + (sum[i][0]*weight[a[0]]);
           
                }
    }
    for(int i = 1; i <e;i++){
        if(i>0){
        sum[0][i]= arry[0][a[i]]+sum[0][i-1];
        }
                }
    for(int i = 1; i < e;i++){
        for(int r = 1; r < arry.length;r++){
          if(sum[r-1][i]>sum[r][i-1])
        sum[r][i]= arry[r][a[i]]+sum[r-1][i];
          else{
        sum[r][i]= arry[r][a[i]]+sum[r][i-1];}
          if(r==arry.length-1){
           wct = wct + (sum[r][i]*weight[a[i]]);
           
          }
          
        }
    }
    
    return wct;
    }
}
