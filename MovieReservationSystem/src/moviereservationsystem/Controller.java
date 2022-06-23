/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

import GUI.ShowtimeButton;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hng
 */

public class Controller implements Runnable{

    private Action action;
    private static List<Movie> movieList;    
    private static Blackboard bb;
    private Timer timer;    
    private JPanel MoviePanel = new JPanel();
    private List<ShowtimeButton> buttons;
    JPanel mainPanel;
    
    private static JFrame f;
    public Controller(){
        this.buttons = new ArrayList<>();        
        movieList = new ArrayList<>();
        action = new Action(movieList);
        bb = new Blackboard(action);
        timer = new Timer();
    }
    
    public void GUI() throws IOException, SQLException {
        f = new JFrame("Movie Reservation System");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        // retrive data from database
        action.loadData(movieList);  
        bb.displayTime(7.00,mainPanel);
        bb.update(movieList,mainPanel,buttons,f);
    }
    
    @Override
    public void run() {
        try {
            GUI();
            // use thread monitoring blackboard state
            // check the closing time
            while(timer.getTime()<22.00){
                double time = timer.getTime();
                bb.displayTime(time,mainPanel);
                // sleep for 1 seconds and wake up to check loop
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                //compare button with time
                for (ShowtimeButton sb : buttons){
                    if(Double.parseDouble(sb.getShowtime())-time<=1.0){
                        sb.setDisabled();                        
                    }
                }                
            }
            action.closeMovie();
            
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
