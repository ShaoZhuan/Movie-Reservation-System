/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hng
 */

public class Controller implements Runnable{

    private Action action;
    private List<Movie> movieList;
    private List<Movie> removeList;
    private static Blackboard bb;
    private Timer timer;
    private boolean update=true;
    
    public Controller(List<Movie> movieList){
        removeList = new ArrayList<>();
        movieList = new ArrayList<>();
        action = new Action(movieList);
        bb = new Blackboard(action);
        timer = new Timer();
    }
    
    @Override
    public void run() {
        // use thread monitoring blackboard state
        movieList = action.MovieInformation();                
        // check the closing time        
        while(timer.getTime()<22.00){                 
            double time = timer.getTime();
            // sleep for 1 seconds and wake up to check loop
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            //check for close reservation
            for (Movie movie : movieList) {
                if((movie.getStartTime()-time)<=1.0 && (movie.getStartTime()-time)>=0){
                    //disable button
                    removeList.add(movie);
                    update= true;
                }
            }            
            if(!removeList.isEmpty()){                
                if(movieList.size()==1){
                    movieList.clear();
                }
                else{
                    movieList.removeAll(removeList);  
                }
            }
            if(timer.getTime()!=time || update){
                bb.update(movieList);
                update=false;
            }
            
        }
    }
    
    
}
