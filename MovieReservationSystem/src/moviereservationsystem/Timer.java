/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hng
 */
public class Timer implements Runnable{
    
    private static double time;
    public static boolean updated;
    public static boolean reach=false;
    public Timer(){
        time=7.00;
        updated = true;
    }
    
    public void increment(){
        time+=1;
        updated = true;
    }
    
    public boolean timeReach(){
        return reach;
    }
    
    
    public double getTime(){
        return time;
    }
    
    public void run(){
        // count time until cinema closed
        while(time != 22.00){
            System.out.println("Current Time: "+time);
            try {
                updated=false;
                // sleep for around 10s then wake up update time
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
            increment();
        }
        reach=true;
    }
    
}
