package moviereservationsystem;

import GUI.ShowtimeButton;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Runnable {

    private static Action action;
    private static List<Movie> movieList;
    private static Blackboard bb;
    private Timer timer;
    private List<ShowtimeButton> buttons;

    public Controller() {
        this.buttons = new ArrayList<>();
        movieList = new ArrayList<>();
        action = new Action(movieList);

        timer = new Timer();
    }

    public void startBlackboard() throws SQLException, IOException {
        bb = new Blackboard(action, movieList);
        bb.update(movieList, buttons);
    }

    @Override
    public void run() {
        try {
            startBlackboard();
            // use thread monitoring blackboard state
            // check the closing time
            while (timer.getTime() < 22.00) {
                double time = timer.getTime();
                bb.setTime(time);
                // sleep for 1 seconds and wake up to check loop
                try {
                    for (int i = 0; i < buttons.size(); i++) {
                        if (Double.parseDouble(buttons.get(i).getShowtime()) - time <= 1.0) {
                            action.closeReserve(buttons.get(i));
                            buttons.remove(buttons.get(i));
                        }
                    }
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                //compare button with time

            }
            action.closeMovie();

        } catch (IOException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
