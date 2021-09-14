/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ques1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P1 {

   ////output will be sucessfully written to file once program running is stopped
    
    public static void main(String[] args) throws InterruptedException, Exception  {
        String data="";
        try {
            File f1=new File("P1-1in.txt");
            Scanner myReader = new Scanner(f1);
            while (myReader.hasNext())
            {   data = myReader.nextLine();
                System.out.println(data);
            }
      myReader.close(); 
      
      int []arr=new int[4]; //to store int 
      char []chararr=new char[4]; //to store alphabets
      
      int j=0;
      char[] str = data.toCharArray(); int i1=0;
        for (int i = 0; i < str.length; i++) 
        {
            if(str[i]=='0'||str[i]=='1'||str[i]=='2'||str[i]=='3'||str[i]=='4')
            {
                int a=Integer.parseInt(String.valueOf(str[i]));
                arr[i1]=a;
                i1++;
            }
            else if(str[i]>=65&&str[i]<=90){
                chararr[j++]=str[i];
            }
        }
        
            Semaphore sem=new Semaphore(1);
            char dir;
            int count=0;
            if(Shared.t1+Shared.t2<150){
            for(int i=0;i<4;i++)
            {
            for(int j1=0;j1<arr[i];j1++){
            count++;
            WarThread w=new WarThread(sem,chararr[i],Integer.toString(count));
            w.start();
            
            }
            }
            }
            else
            {
            System.out.println("Limit Reached!");
            }
              } catch (FileNotFoundException ex) {
            Logger.getLogger(P1.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}
