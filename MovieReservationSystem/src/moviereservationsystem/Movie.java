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
    private double price;
    private List<Double> showTime;

    public Movie(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        showTime = new ArrayList<>();
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
}
