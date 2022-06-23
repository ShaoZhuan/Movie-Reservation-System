/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import database.DBConnection;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.sql.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {

    private static JFrame f = new JFrame("Movie Reservation System");
//    private JButton[] buttons = new JButton[20]; //array of JComboBoxes\;
    private JPanel MoviePanel = new JPanel();
    static ArrayList<ShowtimeButton> buttons = new ArrayList<>();
    JPanel mainPanel;
    JPanel buttonPanel = new JPanel();
    DBConnection db = new DBConnection();

    public GUI() throws IOException, SQLException {
        generateTimetable();
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        buttons.get(2).setDisabled();
    }

    private void generateTimetable() throws IOException, SQLException {
        JButton jButton9 = new JButton("abc");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        mainPanel.add(jButton9);
        ResultSet movies = db.retrieve("SELECT * FROM movie");

        while (movies.next()) {
            //Movie Poster
            URL url = new URL(movies.getString(5));
            Image image = ImageIO.read(url);
            JLabel lbl = new JLabel();
            JLabel title = new JLabel(movies.getString(2));
            lbl.setPreferredSize(new Dimension(300, 300));
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
            lbl.setIcon(imageIcon);

            //Inner Panel
            var panel = new JPanel();
            panel.setLayout(new GridLayout(0, 2, 10, 10));
            panel.setBackground(Color.GREEN);
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            var innerPanel1 = new JPanel();
            var innerPanel2 = new JPanel();

            innerPanel1.setLayout(new GridLayout(0, 2, 10, 10));
            innerPanel2.setLayout(new GridLayout(0, 5, 10, 10));
            innerPanel1.add(lbl);
            innerPanel1.add(title);
            addButton(innerPanel2, movies.getInt(1));
            panel.add(innerPanel1);
            panel.add(innerPanel2);
            mainPanel.add(panel);
        }

        var scroll = new JScrollPane(mainPanel);
        f.getContentPane().add(scroll, BorderLayout.CENTER);

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void addButton(JPanel panel, int _id) throws SQLException {
        ResultSet showtimes = db.retrieve("SELECT * FROM showtime WHERE movie_id=" + _id);

        while (showtimes.next()) {
            ShowtimeButton button = new ShowtimeButton(showtimes.getInt(1), showtimes.getInt(2), showtimes.getString(3), showtimes.getInt(4));
            buttons.add(button);
            panel.add(button);
        }
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    new GUI();
//                    buttons.get(4).setDisabled();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    // End of variables declaration                   
}
