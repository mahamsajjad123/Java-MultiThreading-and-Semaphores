/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static printer.Shared.h1;
import static printer.Shared.h2;
import static printer.Shared.h3;

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
public class PThread extends Thread {
    String id;
    int t;
    Shared Shared;
    String str="";
    File file = new File("p2-1out.txt");

    public PThread(String id,int time)
    {
        this.id=id;
        this.t=time;
       
    }
    
    @Override
    public void run(){
    try{
        try{
            if(Shared.h1==false)
            {
                Shared.h1=true;
                Thread.sleep(this.t*1000);
                str="("+Shared.t1+")"+this.id+" uses head 1 (time : "+this.t+")";
                System.out.println(str);
                Shared.t1+=this.t;
                Shared.h1=false;
                
            }
            else if(Shared.h2==false)
            {
                Shared.h2=true;
                Thread.sleep(this.t*1000);
                str="("+Shared.t2+")"+this.id+" uses head 2 (time : "+this.t+")";
                System.out.println(str);
                
                Shared.t2+=this.t;
                Shared.h2=false;
                
            }
            else if(Shared.h3==false)
            {
                Shared.h3=true;
                Thread.sleep(this.t*1000);
               str="("+Shared.t3+")"+this.id+" uses head 3 (time : "+this.t+")";
                System.out.println(str);
                Shared.t3+=this.t;
                Shared.h3=false;
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        //////////////////////////////////
        FileWriter fr = new FileWriter(file,true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter pr = new PrintWriter(br);
        pr.println(str);
        pr.close();
        br.close();
        fr.close();
    }
    catch(IOException ex)
    {
            Logger.getLogger(PThread.class.getName()).log(Level.SEVERE, null,ex);
    }
    ////////////////////////////////////////////////////////////////////////
    
    }
}
