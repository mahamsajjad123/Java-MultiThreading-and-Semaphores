/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, FileNotFoundException{
        
        FileWriter fr=null;
        try {
            File f1=new File("P2-1in.txt");
            Scanner sc=new Scanner(f1);
            File f2=new File("P2-1out.txt");
            if(f2.exists()==true){
            f2.delete();
            }
            int total=Integer.valueOf(sc.nextLine());
            String[] jobs=new String[total];
            int z=0;
            Semaphore sem=new Semaphore(3);
            for(int k=0;k<total;k++)
            {
                jobs[z]=sc.nextLine();
                z++;
            }   String[] ids=new String[total];
            int[] time=new int[total];
            for(int i=0;i<total;i++)
            {
                String[] words=jobs[i].split("\\s");
                ids[i]=words[0];
                time[i]=Integer.valueOf(words[1]);
            }   SPThread p1=null;
            SPThread p2 = null;
            SPThread p3=null;
            for(int i=0;i<total;)
            {
                
                if(ids[i].charAt(0)=='M'){
                    
                    p1=new SPThread(ids[i],time[i],sem);
                    //p1.setPriority(10-Integer.parseInt(String.valueOf(ids[i].charAt(1))));
                    i++;
                    p1.start();
                    //p1.join();
                    if(i==total)
                        break;
                    
                    if(ids[i].charAt(0)=='M'){
                        p2=new SPThread(ids[i],time[i],sem);
                        //p2.setPriority(10-Integer.parseInt(String.valueOf(ids[i].charAt(1))));
                        i++;
                        p2.start();
                        //p2.join();
                        if(i==total)
                            break;
                        if(ids[i].charAt(0)=='M'){
                            p3=new SPThread(ids[i],time[i],sem);
                            //p3.setPriority(10-Integer.parseInt(String.valueOf(ids[i].charAt(1))));
                            i++;
                            p3.start();
                            //p3.join();
                        }
                    }
                    try{
                        if(ids[i].charAt(0)=='C'){
                            if(p1!=null)
                                while(p1.isAlive()){}
                            if(p2!=null)
                                while(p2.isAlive()){};
                                if(p3!=null)
                                    while(p3.isAlive()){};
                                    Shared.setAll(Collections.max(Arrays.asList(Shared.t1,Shared.t2,Shared.t3)));}
                    }
                    catch(NullPointerException ne)
                    {
                        System.out.println(ne);
                    }
                    
                }
                else if(ids[i].charAt(0)=='C'){
                    
                    p1=new SPThread(ids[i],time[i],sem);
                    //p1.setPriority(10-Integer.parseInt(String.valueOf(ids[i].charAt(1))));
                    i++;
                    p1.start();
                    //p1.join();
                    if(i==total)
                        break;
                    if(ids[i].charAt(0)=='C'){
                        p2=new SPThread(ids[i],time[i],sem);
                        //p2.setPriority(10-Integer.parseInt(String.valueOf(ids[i].charAt(1))));
                        i++;
                        p2.start();
                        //p2.join();
                        if(i==total)
                            break;
                        if(ids[i].charAt(0)=='C'){
                            p3=new SPThread(ids[i],time[i],sem);
                            //p3.setPriority(10-Integer.parseInt(String.valueOf(ids[i].charAt(1))));
                            i++;
                            p3.start();
                            //p3.join();
                        }
                    }
                    try{
                        if(ids[i].charAt(0)=='M'){
                            if(p1!=null)
                                while(p1.isAlive()){}
                            if(p2!=null)
                                while(p2.isAlive()){}
                            if(p3!=null)
                                while(p3.isAlive()){}
                            //while(p1.isAlive() || p2.isAlive() || p3.isAlive());
                            Shared.setAll(Collections.max(Arrays.asList(Shared.t1,Shared.t2,Shared.t3)));}
                    }
                    
                    catch(NullPointerException ne)
                    {
                        System.out.println(ne);
                    }
                }
                
            }  
            while(p1.isAlive() || p2.isAlive() || p3.isAlive());
            String str="("+Collections.max(Arrays.asList(Shared.t1,Shared.t2,Shared.t3))+") Done";
            System.out.println(str);
            File file = new File("p2-1out.txt");
            fr = new FileWriter(file,true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.println(str);
            pr.close();
            br.close();
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(P3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(P3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
}
    

