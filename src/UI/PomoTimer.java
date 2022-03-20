package UI;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DecimalFormat;

public class PomoTimer {

    private Timer timer;
    private int minutes = 25;
    private int seconds = 0;
    private String doubleMinutes;
    private String doubleSeconds;
    private boolean on;

    public JLabel label;
    private TimerTask task;
    private DecimalFormat decimalFormat;

    public PomoTimer() {
        initLabel();
        initTimer();
    }

    public void initLabel() {
        label = new JLabel("25:00");
    }

    public void initTimer() {
       // on = false;
        decimalFormat = new DecimalFormat("00");
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                if(on){
                    seconds--;
                    doubleSeconds = decimalFormat.format(seconds);
                    doubleMinutes = decimalFormat.format(minutes);

                    label.setText(doubleMinutes + ":" + doubleSeconds);

                    if (seconds == -1) {
                        seconds = 59;
                        minutes--;
                        doubleSeconds = decimalFormat.format(seconds);
                        doubleMinutes = decimalFormat.format(minutes);
                        label.setText(doubleMinutes + ":" + doubleSeconds);
                    }

                    if (minutes == 0 && seconds == 0) {
                        timer.cancel();
                    }
                }
            }
        };

        timer.schedule(task, 2000,2000);
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void startTimer() {
        on = true;
        initTimer();
    }

    public boolean doneTimer() {
        return minutes == 0 && seconds == 0;
    }
}
