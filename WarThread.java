/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ques1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Shared 
{
    static int t1 = 0;
    static int t2 = 0;
    static int c = 0;
    static String temp="";
    public static void print() throws Exception
    {
        FileWriter f1=new FileWriter("p1-out.txt");
        f1.write(Shared.temp);
    }
}
public class WarThread extends Thread{
    Semaphore sem;
    String threadName;
    char dir;
    public WarThread(Semaphore s,char direction, String tName){
        super("WAR - "+tName);
        this.dir=direction;
        this.sem=s;
        this.threadName="WAR - "+tName;
    }
    @Override
    public void run()
    {
        
        try{
            while(Shared.c<150){
        if(this.dir=='N')
        {
            Shared.c++;
            String s;
            s=this.getName();
            s= s + " (Loaded)";
            Shared.temp=Shared.temp+(s+" : Wating at the Intersection. Going towards Dock2");
            this.sem.acquire();
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 1.");
            Thread.sleep(200);
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 2.");
             Thread.sleep(200);
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 3.");
            Shared.temp=Shared.temp+(s+" : Crossed the intersection.");
            Shared.t2++;
            Shared.temp=Shared.temp+("Total crossed in Track1 : "+Shared.t1+"  Track2 : "+Shared.t2);
            sem.release();
            this.dir='S';
            FileWriter f1=new FileWriter("p1-out.txt");
            f1.write(Shared.temp);
        }
        else if(this.dir=='S')
        {
            String s;
            Shared.c++;
            s=this.getName();
            s= s + " (Unloaded)";
            Shared.temp=Shared.temp+(s+" : Wating at the Intersection. Going towards Storage2");
            this.sem.acquire();
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 1.");
            Thread.sleep(200);
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 2.");
             Thread.sleep(200);
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 3.");
            Shared.temp=Shared.temp+(s+" : Crossed the intersection.");
            Shared.t2++;
            Shared.temp=Shared.temp+("Total crossed in Track1 : "+Shared.t1+"  Track2 : "+Shared.t2);
            sem.release();
            this.dir='N';
            FileWriter f1=new FileWriter("p1-out.txt");
            f1.write(Shared.temp);
        }
        else if(this.dir=='E')
        {
            Shared.c++;
            String s;
            s=this.getName();
            s= s + " (Unloaded)";
            Shared.temp=Shared.temp+(s+" : Wating at the Intersection. Going towards Storage1.");
            this.sem.acquire();
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 1.");
            
            Thread.sleep(200);
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 2.");
             Thread.sleep(200);
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 3.");
            Shared.temp=Shared.temp+(s+" : Crossed the intersection.");
            Shared.t1++;
            Shared.temp=Shared.temp+("Total crossed in Track1 : "+Shared.t1+"  Track2 : "+Shared.t2);
            sem.release();
            this.dir='W';
            FileWriter f1=new FileWriter("p1-out.txt");
            f1.write(Shared.temp);
        }
        else if(this.dir=='W')
        {
            Shared.c++;
            String s;
            s=this.getName();
            s= s + " (Loaded)";
            Shared.temp=Shared.temp+(s+": Wating at the Intersection. Going towards Dock1.");
            this.sem.acquire();
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 1.");
            Thread.sleep(200);
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 2.");
             
             Thread.sleep(200);
            Shared.temp=Shared.temp+(s+" : Crossing intersection Checkpoint 3.");
            Shared.temp=Shared.temp+(s+" : Crossed the intersection.");
            Shared.t1++;
            Shared.temp=Shared.temp+("Total crossed in Track1 : "+Shared.t1+"  Track2 : "+Shared.t2);
            sem.release();
            this.dir='E';
            FileWriter f1=new FileWriter("p1-out.txt");
            f1.write(Shared.temp);
        }
        }
        }
        catch (InterruptedException exc) {
                    Shared.temp=Shared.temp+(exc);
        } catch (IOException ex) {
            Logger.getLogger(WarThread.class.getName()).log(Level.SEVERE, null, ex);
        }/* catch (IOException ex) {
            Logger.getLogger(WarThread.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
