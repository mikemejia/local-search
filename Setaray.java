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
public class Setaray {
    
    int [][]input;
    int [] neworder;
    public void returnarray(int x, int y, int[][]arr,int[]order){
        
        neworder = new int[order.length];
        
        System.arraycopy( order, 0, neworder, 0, order.length );
        input = new int[y][x];
    for(int i = 0; i < y;i++){
        //System.out.print(i+" ");
        for(int r = 1; r < x;r++){
        if(r == 1){
//        input[i][0]=arr[i][order[x-1]];
        neworder[0]=order[x-1];
        //System.out.print(order[x-1]);
        }
//        input[i][r]=arr[i][order[r-1]];
        neworder[r]=order[r-1];
       // System.out.print(" "+order[r-1]+" ");
        }
      }
//    for(int i = y; i < arr[0].length;i++){
//            for(int r = x; r < arr.length;i++){
//                System.out.print(r);
//            input[i][r]=arr[i][order[r]];
//            }}
    
    
    }
    public int [] order(){
    
    return neworder;
    }
}
