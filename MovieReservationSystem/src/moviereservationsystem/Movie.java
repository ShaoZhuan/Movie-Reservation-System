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
public class Movie {
    
    private String name;
    private String description;
    private int duration;    
    private int startTime;
    private String imageURL;

    public Movie(String name, String description, int duration, int startTime, String imageURL) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.startTime = startTime;
        this.imageURL = imageURL;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public String toString(){
        String str = "Movie: "+this.name + "\n" +
                "Movie Description: "+this.description+ "\n" +
                "Movie Duration: "+this.duration+ "\n" +
                "Movie time: "+this.startTime+ "\n" +
                "Movie image: "+this.imageURL+ "\n";
        return str;
    }
    
    
}
