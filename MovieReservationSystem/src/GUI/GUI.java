package GUI;

import javax.swing.JFrame;
import moviereservationsystem.Controller;


public class GUI extends JFrame {

    public static void main(String args[]) {
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
