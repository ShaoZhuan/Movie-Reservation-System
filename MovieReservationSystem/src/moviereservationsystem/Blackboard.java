/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

import GUI.ShowtimeButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author hng
 */
public class Blackboard extends JFrame{
    
    private Action action;    
    private static JFrame f;
    JPanel mainPanel;


    public Blackboard(Action action, List<Movie> movieList) throws SQLException{   
        this.action = action; 
        f = new JFrame("Movie Reservation System");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        action.loadData(movieList);
        displayTime(7.00);
    }
    
    //special method for supporting the updating process carried out by knowledge sources
    public void update(List<Movie> list,List<ShowtimeButton> buttons) throws MalformedURLException, IOException, SQLException{
        // sort the list according to duration
        for(Movie movie: list){
            URL url = new URL(movie.getImageURL());
            Image image = ImageIO.read(url);
            JLabel img = new JLabel();
            JLabel title = new JLabel(movie.getName());
            img.setPreferredSize(new Dimension(300, 300));
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
            img.setIcon(imageIcon);

            //Inner Panel
            var panel = new JPanel();
            panel.setLayout(new GridLayout(0, 2, 10, 10));
            panel.setBackground(Color.GREEN);
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            var leftPanel = new JPanel();
            var rightPanel = new JPanel();

            leftPanel.setLayout(new GridLayout(0, 2, 10, 10));
            rightPanel.setLayout(new GridLayout(0, 5, 10, 10));
            leftPanel.add(img);
            leftPanel.add(title);             
            action.addButton(rightPanel, movie.getId(),buttons);
            panel.add(leftPanel);
            panel.add(rightPanel);
            mainPanel.add(panel);
            
        }
        
        
        var scroll = new JScrollPane(mainPanel);
        f.getContentPane().add(scroll, BorderLayout.CENTER);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        
        
        
    }
    
    public void displayTime(double time){
        
    }
}
