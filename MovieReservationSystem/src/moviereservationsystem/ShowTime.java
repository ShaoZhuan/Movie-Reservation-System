/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

/**
 *
 * @author hng
 */
public class ShowTime {
    
    private static final int capacity = 20;
    private int showTime;
    private int num;
    
    public ShowTime(int showTime){
        this.showTime = showTime;
        this.num = 0;
    }
    
    public boolean isFull(){
        return num>=capacity;
    }
    
    public int getShowTime(){
        return showTime;
    }
    
    public void inc(){
        num++;        
    }
    
    public int getNum(){
        return num;
    }
    
}
