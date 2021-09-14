/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static p3.Shared.h1;
import static p3.Shared.h2;
import static p3.Shared.h3;

class Shared
{
    static boolean h1=false;
    static boolean h2=false;
    static boolean h3=false;
    static int t1=0;
    static int t2=0;
    static int t3=0;
    public Shared()
    {
        h1=false;
        h2=false;
        h3=false;
    }
    static public void setAll(int num)
    {
        t1=num;
        t2=num;
        t3=num;
    }
}
public class SPThread extends Thread {
    String id;
    int t;
    Shared Shared;
    Semaphore sem;
    String str="";

    public SPThread(String id,int time,Semaphore sem)
    {
        this.id=id;
        this.t=time;
        this.sem=sem;   

    }
    @Override
    public void run(){
    try{
        try{
            
            //System.out.println("here");
            if(Shared.h1==false)
            {
                sem.acquire();
                str=str+"("+Shared.t1+")"+this.id+" uses head 1 (time : "+this.t+")";
                System.out.println(str);
                Shared.h1=true;
                Thread.sleep(this.t*1000);
                
                Shared.t1+=this.t;
                Shared.h1=false;
                sem.release();
            }
            else if(Shared.h2==false)
            {
                sem.acquire();
                str=str+"("+Shared.t2+")"+this.id+" uses head 2 (time : "+this.t+")";
                System.out.println(str);
                Shared.h2=true;
                Thread.sleep(this.t*1000);
                
                Shared.t2+=this.t;
                Shared.h2=false;
                sem.release();
            }
            else if(Shared.h3==false)
            {
                sem.acquire();
                str=str+"("+Shared.t3+")"+this.id+" uses head 3 (time : "+this.t+")";
                System.out.println(str);
                Shared.h3=true;
                Thread.sleep(this.t*1000);
                
                Shared.t3+=this.t;
                Shared.h3=false;
                sem.release();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        FileWriter fr = new FileWriter("p2-1out.txt",true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter pr = new PrintWriter(br);
        pr.println(str);
        pr.close();
        br.close();
        fr.close();
        
        
    }
    catch(IOException ex)
    {
            Logger.getLogger(SPThread.class.getName()).log(Level.SEVERE, null,ex);
    }

    
    }
}
