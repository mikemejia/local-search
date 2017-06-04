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
public class insert {
    
    public int [] arrayinsert(int [] array, int start, int position){
    int [] a = new int[array.length];
    System.arraycopy(array, 0, a, 0, array.length);
    int num = array[start];
    for(int i = start; i < array.length; i++){
        a[i] = a[start+1];
        if(position == i){
        a[i]=position;
        break;
        }
        
    }
    
    
    return a;}
    
}
