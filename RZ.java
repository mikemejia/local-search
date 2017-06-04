/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Michael
 */


public class RZ {
    int[][]startarry;
    int[]order;
    int [] a;
    int bestvalue;
    int [] orr;
    public RZ(int[][] array,int[]pri,boolean rand, boolean first, boolean trans, boolean inser,boolean exch, boolean part2, boolean aa){//first true best false
        a = new int[array[0].length]; // creates the jobs length
        
        if(rand){
        RandInitial rr = new RandInitial();
        a = rr.rand(a.length);
        
        }
        else{
        HashMap hm = new HashMap(array[0].length);
        //the hash map is to save 
        startarry = new int[array.length][array[0].length];
        order = new int [array[0].length];
        /* This for loop will copy all the values of the passing array
         * The first row is copied over while every row afterwards is
         * copied over as well as added with the previous value before it.
         * then the last row after being added with the previous is then divided by
         * its weight to give it the T value for the RZ*/
         for(int i = 0; i < array[0].length;i++){
        for(int r = 0; r< array.length;r++){
          if(r==0)
          startarry[r][i]=array[r][i];
          else
              startarry[r][i]=array[r][i]+startarry[r-1][i];
          if(r==array.length-1){
              double q = startarry[r][i]/pri[i];
           // the order is that the arrays were inputed from are now inputed into
           // hash map that has the value of T with the order in which it was inputed
           hm.put(Integer.toString(i), q); 
          }
        }
         }
         /* The hash map is then sorted by the T value which is still paired
         with the job number for that T*/
   
   Object [] r = hm.entrySet().stream()
   .sorted(Map.Entry.comparingByValue()).toArray();
   /*The for loop gets the job # and removes the rest of the string as the object
   gouped the job number And the T value together job#=TValue
   */
   for(int i = 0; i < array[0].length; i++){
    a[i] = Integer.parseInt(r[i].toString().substring(0, r[i].toString().indexOf("=")));
   
   }
        }
   WCT cc = new WCT();
   Setaray set = new Setaray();
   /* Creates an array with the next value to be compared is but in the beginning
   position.
   The first for loop adds a value to the length of the array every time until
   it becomes ends with the length of the array
   The second array goes through every possible combination if it is searching for
   the best value*/
  int we = cc.a(array, pri,a,array[0].length);
  
  int [] temp = a;
  
   if(part2 == false){
       if(exch){
       for(int i = 0; i < array[0].length-1;i++){
       int r = 0;
       System.out.print(i+"  ");
       bestvalue = cc.a(array, pri, a, a.length);
       for(int inner = i;inner <array[0].length;inner++){
       orr = a;
       
       exchange ins = new exchange();
       orr = ins.exx(orr, i, inner);
       System.out.println(Arrays.toString(orr));
       int init = cc.a(array, pri, orr, a.length);
       
       if(init < bestvalue){
       System.arraycopy(orr, 0, temp, 0, a.length);
       this.bestvalue = init;
       }
       }
       }
       System.arraycopy(temp, 0, a, 0, a.length);
       System.out.println(bestvalue);
       }
       else{
       if(inser){
           insert ins = new insert();
       for(int i = 0; i < array[0].length-1;i++){
       int r = 0;
       bestvalue = cc.a(array, pri, a, a.length);
       for(int inner = i;inner <array[0].length;inner++){
       orr = a;
       orr = ins.arrayinsert(orr, i, inner);
       System.out.println(Arrays.toString(orr));
       int init = cc.a(array, pri, orr, a.length);
       
       if(init < bestvalue){
       System.arraycopy(orr, 0, temp, 0, a.length);
       this.bestvalue = init;
       }
       }
       }
       System.arraycopy(temp, 0, a, 0, a.length);
       System.out.println(bestvalue);
       }
       
   for(int i = 0; i < array[0].length;i++){
       
        set.returnarray(i+1, array.length, array, a);
        
         orr = set.order();
         int [] tempor;
      if(i >= 1){
        int weg = cc.a(array, pri,a, i+1);
        bestvalue = weg;
        
        
        
        
      for(int g = 0; g < i;g++){
          if(g==0){
              int q =cc.a(array, pri, orr, i+1);
                if (q < bestvalue){
                   bestvalue = q;
                   System.arraycopy(orr, 0, temp, 0, temp.length);
                                    }  
                   }
          
          if(g >0 && trans){
            tanspose tt = new tanspose();
            orr = tt.tran(orr, g);
            int e =cc.a(array, pri, orr, i+1);
          if (e < bestvalue){
             bestvalue = e;
             System.arraycopy(orr, 0, temp, 0, a.length);
             if(first){break;}

                             }
                   }
//          if(g >0 && inser){
//            insert ins = new insert();
//            orr = ins.arrayinsert(orr, g);
//            int e =cc.a(array, pri, orr, i+1);
//          if (e < bestvalue){
//             bestvalue = e;
//             System.arraycopy(orr, 0, temp, 0, a.length);
//             if(first){break;}
//                             }
//                   }
          
          
                                }
      
      if(cc.a(array, pri, temp,i+1)<cc.a(array, pri, orr, i+1)){
          
      System.arraycopy(temp, 0, a, 0, a.length);
      }
                }
//       if(i == 3){System.exit(0);}
   }
       }
   System.out.println(bestvalue);
        }
   boolean tranp = true;
   boolean excha = false;
   boolean insert = false;
   
   if(part2 && aa){
       
       int initial = 1;
       
        int i = 0;
        
       bestvalue = cc.a(array, pri,a, array[0].length);
       while(initial<array[0].length - 1){
           orr = a;
       
       if(tranp && i < array[0].length -1){
          for(int k = i; k < a.length-1;k++){
            tanspose tt = new tanspose();
            orr = tt.tran(orr, k+1);
            int e =cc.a(array, pri, orr, a.length);
          if (e < bestvalue){
              i=k;
             initial = 1;
             bestvalue = e;
             System.arraycopy(orr, 0, a, 0, a.length);
             break;
             }
//          else{i=i+1;}
       }
          
              excha = true;
          tranp = false;
             }
            
         if(excha && i < array[0].length -3){
             for(int k = i; k < a.length-1;k++){
            exchange vv = new exchange();
//            orr = vv.exx(orr, k+3);
            int e =cc.a(array, pri, orr, a.length);
          if (e < bestvalue){
              
              
              initial = 1;
             bestvalue = e;
             System.arraycopy(orr, 0, a, 0, a.length);
             break;
                             }
//          else{}      
             }
            insert = true; excha = false; 
          
          
            }
         
         if(insert && i < array[0].length -2){
             for(int k = i; k < a.length-1;k++){
            exchange vv = new exchange();
//            orr = vv.exx(orr, k+2);
            int e =cc.a(array, pri, orr, a.length);
            
          if (e < bestvalue){
             
              i=k;
              initial = 1;
             bestvalue = e;
             System.arraycopy(orr, 0, a, 0, a.length);
             break;
                             }
//          else{ }  }   
            tranp = true; insert = false; 
          
         }
            }    initial = initial + 1;
           
         if(i > array[0].length -3){
             i =0;}
           
           
           
           
           
       }
       System.out.println(bestvalue);
//         for(int i = 0; i < array[0].length;i++){
//        set.returnarray(i+1, array.length, array, a);
//        int [] orr = set.order();
//      if(i >= 1){
//        int weg = cc.a(array, pri,a, i+1);
//        bestvalue = weg;
        
     }

   
   else if(part2 && aa == false){
         int initial = 1;
       
        int i = 0;
        
        bestvalue = cc.a(array, pri,a, array[0].length);
        while(initial<array[0].length - 1){
            orr = a;
            if(tranp && i < array[0].length -1){
          for(int k = i; k < a.length-1;k++){
            tanspose tt = new tanspose();
            orr = tt.tran(orr, k+1);
            int e =cc.a(array, pri, orr, a.length);
          if (e < bestvalue){
              i=k;
             initial = 1;
             bestvalue = e;
             System.arraycopy(orr, 0, a, 0, a.length);
             break;
             }
//          else{i=i+1;}
       }
          
              insert = true;
          tranp = false;
             }
            
            if(insert && i < array[0].length -2){
             for(int k = i; k < a.length-1;k++){
            exchange vv = new exchange();
//            orr = vv.exx(orr, k+2);
            int e =cc.a(array, pri, orr, a.length);
            
          if (e < bestvalue){
             
              i=k;
              initial = 1;
             bestvalue = e;
             System.arraycopy(orr, 0, a, 0, a.length);
             break;
                             }
//          else{ }  }   
            excha = true; insert = false; 
          
         }
            }      
          if(excha && i < array[0].length -3){
             for(int k = i; k < a.length-1;k++){
            exchange vv = new exchange();
//            orr = vv.exx(orr, k+3);
            int e =cc.a(array, pri, orr, a.length);
          if (e < bestvalue){
              
              
              initial = 1;
             bestvalue = e;
             System.arraycopy(orr, 0, a, 0, a.length);
             break;
                             }
//          else{}      
             }
            tranp = true; excha = false; 
          
          
            }
         
        
         initial = initial + 1;
           
         if(i > array[0].length -3){
             i =0;}
         
         }       
                 System.out.println(bestvalue);
                 }
    
    

    }
}
   
    

