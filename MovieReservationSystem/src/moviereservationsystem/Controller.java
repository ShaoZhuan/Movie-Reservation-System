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
public class Controller implements Runnable {

    private Action action;
    private List<Movie> movieList;
    private static Blackboard bb;
    private Timer timer;
    private boolean update = true;

    public Controller(List<Movie> movieList) {

        movieList = new ArrayList<>();
        action = new Action(movieList);
        bb = new Blackboard(action);
        timer = new Timer();
    }

    @Override
    public void run() {
        List<ShowTime> removeList;
        List<Movie> removeMVlist;
        // use thread monitoring blackboard state
        movieList = action.MovieInformation();
        // check the closing time        
        while (!timer.timeReach()) {
            removeList = new ArrayList<>();
            removeMVlist = new ArrayList<>();
            double time = timer.getTime();
            // sleep for 1 seconds and wake up to check loop
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            //check for close reservation
            for (Movie movie : movieList) {
                for (ShowTime showTime : movie.getShowTime()) {
                    if ((showTime.getShowTime() - time) <= 1.0 && (showTime.getShowTime() - time) >= 0) {
                        //disable button
                        removeList.add(showTime);
                        update = true;
                    }
                }
                if (!removeList.isEmpty()) {
                    movie.getShowTime().removeAll(removeList);
                    if (movie.getShowTime().isEmpty()) {
                        removeMVlist.add(movie);
                    }
                }
            }
            if (!removeList.isEmpty()) {
                movieList.removeAll(removeMVlist);
            }
            if (update) {
                bb.update(movieList);
                update = false;
            }

        }
    }
}

