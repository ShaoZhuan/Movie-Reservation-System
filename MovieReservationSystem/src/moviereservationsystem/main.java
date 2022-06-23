/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author hng
 */
public class main{
    private static List<Movie> movieList;       

    public static void main(String[] args) {
        movieList = new ArrayList<>();
        Controller controller = new Controller();
        Timer timer = new Timer();
        Thread t1 = new Thread(controller);
        t1.start();
        Thread t2 = new Thread(timer);
        t2.start();
    }

}
