package moviereservationsystem;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Timer implements Runnable {

    DecimalFormat df = new DecimalFormat("#.##");

    private static double time;
    public static boolean updated;
    public Timer() {
        time = 7.00;

        updated = true;
    }

    public void increment() {
        time = Double.parseDouble(df.format(time));
        if (df.format(time % 1.0).equals("0.5")) {
            time = time - 0.50 + 1.0;
        } else {
            time += 0.10;
        }
        updated = true;
    }

    public double getTime() {
        return time;
    }

    public void run() {
        while (time != 23.00) {
            try {
                updated = false;
                // sleep for around 10s then wake up update time
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
            increment();
        }
    }

}
