/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hng
 */
public class Action implements KnowledgeSource {
    
    private List<Movie> movieList;
    
    public Action(List<Movie> movieList){        
        this.movieList = movieList;
    }

    
    @Override
    public List<Movie> MovieInformation() {
        File file = new File("movies.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String[] str = sc.nextLine().split(",");      
                String name = str[0];
                String[] showTime = str[1].split("\\|");               
                int duration = Integer.parseInt(str[2]);
                String description = str[3];
                String url = str[4];
                
                // name, description, duration, showtime, imageurl
                Movie movie = new Movie(name, description, duration, Arrays.asList(showTime),url);
                // after done creating movie blackboard update and display the movie
                movieList.add(movie);               
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MovieReservationSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movieList;
    }

    @Override
    public void reserveTicket() {
        
    }



    @Override
    public void showMovie(List<Movie> movieList) {
        // print the movie list and time table
        for (Movie mv: movieList) {
            System.out.println(mv.toString());
        }        
                
        System.out.println("\nTime table of all movie show times: ");
        // row is time, column is movielist
        //time only from 8am to 10pm with every half hour of display
        double time = 8.00;
        System.out.println("Time:  | Movie");
        for (int i = 0; i < 15; i++) {    
            //print time
            System.out.printf("%-7.2f| ",time);
            if(!movieList.isEmpty()){
                for (Movie list: movieList) {
                    for (ShowTime showtime: list.getShowTime()) {
                        if(showtime.getShowTime()==(int)time)
                            System.out.printf("%-10s ",list.getName());
                        
                    }
                }
            }
            System.out.println();
            time+=1;                            
        }
        System.out.println();
    }

    @Override
    public void closeReserve() {
        // disable button or remove the button from the blackboard
    }

    @Override
    public void closeMovie() {
        System.out.println("All movies have finished show. Please come at next day.");
        System.exit(0);
    }
}
