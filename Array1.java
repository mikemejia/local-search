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
public class Array1 {
    int[][]sum;
    boolean first;
    int[][]arry;
    int[]duedates;
    int[]priority;
    int x,y;
    boolean Randombl, transpose, insert, exchange, part2, aa;
    public Array1(int mch, int jbs){
        
        x = jbs;
        y= mch;
        arry = new int[mch][jbs]; 
        sum = new int[mch][jbs];
        duedates = new int[jbs];
        priority=new int[jbs];
    }
    public void update(int machines, int jobs, String val){
    String a = val.trim();
    arry[machines][jobs]= Integer.parseInt(val);
    }
    public void duearray(int pos, String a){
        duedates[pos] = Integer.parseInt(a);
    }
    public void priorityarray(int pos, String a){
        priority[pos] = Integer.parseInt(a);
        
    }
    public void truevalue(boolean firs, boolean tra, boolean exc, boolean ins, boolean initial,boolean part, boolean aaL){
        first = firs;
        transpose = tra;
        insert = ins;
        exchange = exc;
        Randombl = initial;
        part2 = part;
        aa = aaL;
    }
    public void sum(){
        
        RZ rz = new RZ(arry, priority, Randombl, first, transpose, insert, exchange, part2, aa);
        sum[0][0]=arry[0][0];
    for(int i = 0; i<y;i++){
        if(i>0){
        this.sum[i][0]= arry[i][0]+sum[i-1][0];
        }
                }
    for(int i = 1; i <x;i++){
        if(i>0){
        sum[0][i]= arry[0][i]+sum[0][i-1];
        }
                }
    for(int i = 1; i < x;i++){
        for(int r = 1; r < y;r++){
          if(sum[r-1][i]>sum[r][i-1])
        this.sum[r][i]= arry[r][i]+sum[r-1][i];
          else{
        this.sum[r][i]= arry[r][i]+sum[r][i-1];}
        }
    }
    
    }

    }

