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
public class tanspose {
    
    public int [] tran(int [] a, int value){
    int []r= new int[a.length];
    int temp1 = a[value];
    int temp2 = a[value-1];
    System.arraycopy(a, 0, r, 0, a.length);
    r[value]=temp2;
    r[value-1]=temp1;
    return r;
    }
    
}
