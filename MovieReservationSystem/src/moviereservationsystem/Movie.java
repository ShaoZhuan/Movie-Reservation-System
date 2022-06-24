package moviereservationsystem;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    
    private int id;
    private String name;
    private String description;
    private int duration;    

    private String imageURL;
    
    public Movie(int id, String name, String description, int duration, String imageURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.imageURL = imageURL;

    }

    public int getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public void setDuration(int duration) {
        this.duration = duration;

    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
//    public String displayShowTime(){
//        String str="[";
//        for (ShowTime showTime : this.showTime) {
//            str += showTime.getShowTime() + ",";
//        }
//        str+="]";
//        return str;
//    }

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
                "Movie image: "+this.imageURL+ "\n";
        return str;
    }
    
    
}
