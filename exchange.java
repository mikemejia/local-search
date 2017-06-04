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
public class exchange {
    int [] temp;
    int initial;
    
    
    public int [] exx(int [] a,int start, int position){
        
        int [] array = new int[a.length];
        System.arraycopy(a, 0, array, 0, a.length);
        ;
        array[start] = a[position];
        array[position] = a[start];
        
        return array; 
            }
    public int best(int[] a, int i, int [] weight, int [][] ar){
        temp = a;
        int [] array = new int[a.length];
        
        WCT e = new WCT();
        initial=e.a(ar, weight, a, i);
        System.arraycopy(a, 0, array, 0, a.length);
        System.arraycopy(array, 0, temp, 0, array.length);
        
        for(int x = 0; x < i; x++){
         array = exx(a,0,x);
//         System.out.println("inside"+Arrays.toString(array));
         int set =e.a(ar, weight, array, i);
         if(set < initial){
         initial = set;
         setarray(array);
         }
                 }
            return initial;}
    public void setarray(int [] ee){
        
    System.arraycopy(ee, 0, temp, 0, ee.length);
    
    }
    public int [] getarray(){
        
    return temp;
    }
}
