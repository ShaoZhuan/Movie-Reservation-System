/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import javax.swing.JFrame;
import moviereservationsystem.Controller;


public class GUI extends JFrame {

    public static void main(String args[]) {
//        System.out.println(0.59-0.59+1%1.0);
        javax.swing.SwingUtilities.invokeLater(() -> {
            Controller controller = new Controller();
            moviereservationsystem.Timer timer = new moviereservationsystem.Timer();
            Thread t1 = new Thread(controller);
            t1.start();
            Thread t2 = new Thread(timer);
            t2.start();
        });
    }
                 
}
