/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author leequan
 */
public class ShowtimeButton extends JButton {

    private int showtimeId, movieId, capacity, available;
    private String showtime;


    public ShowtimeButton() {
    }

    public ShowtimeButton(int showtimeId, int movieId, String showtime, int capacity) {
        super(showtime);
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.showtime = showtime;
        this.capacity = capacity;
        this.available = capacity;
    }



    public void setDisabled() {
        this.setEnabled(false);
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

}
