/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Michael
 */
public class Impl1 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        boolean part = false, aa = false; 
        boolean best = false, transpose= false, exchange = true, insert= false, initial = false;
//        String bestorfirst =args[0];
//        if(args[0].trim().equalsIgnoreCase("part2")){
//            part = true;
//            if(args[1].trim().equalsIgnoreCase("1")){
//            aa = true;}
//            if(args[2].trim().equalsIgnoreCase("rand"))
//            {initial = true;}
//    }
//        else{
//        String neighbor =args[1];
//        String RandomorRZ = "args[2]";
//       
//        
//        if(bestorfirst.trim().equalsIgnoreCase("first")){
//        best = true;
//        }
//        
//        if (neighbor.trim().equalsIgnoreCase("exchange")){
//            transpose = true;
//        }
//        else if (neighbor.trim().equalsIgnoreCase("exchange")){
//            exchange = true;}
//        else if (neighbor.trim().equalsIgnoreCase("insert")){
//            insert = true;}
//        if(RandomorRZ.trim().equals("rand")){
//        initial = true;
//        }}
//for(int er = 0; er < 2; er++){
    String tt;
//    if(er == 0){
//    tt = "100_20_";
//    }
//    else
        
       tt= "50_20_";
for(int sss = 1; sss<2; sss++){
        String r = Integer.toString(sss);
        if(sss < 10) r = "0" +r;
        File file = new File("C:\\Users\\Michael\\Downloads\\instances\\instances\\"+tt+r);
        Scanner in = new Scanner(file);
        int jb = in.nextInt();
        int machines = in.nextInt();
        Array1 a = new Array1(machines,jb);
        for(int i = 0; i<jb;i++){
                for(int y = 0;y < machines;y++){
                in.next();
                String val = in.next();
                a.update(y, i, val);
                }
        }
        in.next();
        for(int i = 0; i < jb; i++){
            in.next();//-1
            a.duearray( i,in.next());// due
            in.next();//-1
            a.priorityarray(i,in.next());//priority 
        }
        a.truevalue(best, transpose, exchange, insert, initial, part, aa);
        a.sum();
        in.close();
       }
//    }
    }
    public static File getfile(){
        JFileChooser chooser = new JFileChooser();
        int result;
        result = chooser.showOpenDialog(chooser);
        if (result == JFileChooser.APPROVE_OPTION) {
        File select = chooser.getSelectedFile(); 
        return select;
        }
        return null;
    }
    }

