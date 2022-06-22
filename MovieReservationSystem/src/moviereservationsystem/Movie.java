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
    private List<ShowTime> showTime;
    private String imageURL;
    

    public Movie(String name, String description, int duration, List<String> startTime, String imageURL) {        
        this.name = name;
        this.description = description;
        this.duration = duration;
        showTime = new ArrayList<>();
        for (int i = 0; i < startTime.size(); i++) {            
            showTime.add(new ShowTime(Integer.parseInt(startTime.get(i))));
        }
        this.imageURL = imageURL;        
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public void setShowTime(List<ShowTime> showTime){
        this.showTime = showTime;
    }

    public List<ShowTime> getShowTime() {
        return showTime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    public String displayShowTime(){
        String str="[";
        for (ShowTime showTime : this.showTime) {
            str += showTime.getShowTime() + ",";
        }
        str+="]";
        return str;
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

    
    @Override
    public String toString(){
        String str = "Movie: "+this.name + "\n" +
                "Movie Description: "+this.description+ "\n" +
                "Movie Duration: "+this.duration+ "\n" +
                "Movie time: "+this.displayShowTime()+ "\n" +
                "Movie image: "+this.imageURL+ "\n";
        return str;
    }
    
    
}
