/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl1;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Michael
 */
public class RandInitial {
    /*This randomizes the order and will then return the array
    */
    
    public int [] rand(int a){
    Integer[] arr = new Integer[a]; 

for (int i = 0; i < arr.length; i++) { 
    arr[i] = i; 
} 
int [] arry = new int[arr.length];
Collections.shuffle(Arrays.asList(arr)); 
for(int i= 0; i< arr.length; i++){
arry[i] = arr[i];
}



    return arry;}
    
}
