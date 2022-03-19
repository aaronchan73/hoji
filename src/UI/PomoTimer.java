package UI;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DecimalFormat;

public class PomoTimer {

    private Timer timer;
    private int delay;
    private int period;
    private int minutes;
    private int seconds;
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
        on = false;
        decimalFormat = new DecimalFormat("00");
        delay = 1000;
        period = 1500000;
        minutes = 25;
        seconds = 0;
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                if (on) {
                    seconds--;
                    doubleSeconds = decimalFormat.format(seconds);
                    doubleMinutes = decimalFormat.format(minutes);

                    label.setText(doubleMinutes + ":" + doubleSeconds);

                    if (seconds == -1) {
                        seconds = 59;
                        minutes--;
                        label.setText(doubleMinutes + ":" + doubleSeconds);
                    }

                    if (minutes == 0 && seconds == 0) {
                        timer.cancel();
                    }
                }
            }
        };

        timer.schedule(task, delay, period);
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void stopTimer() {
        timer.cancel();
    }

    public void startTimer() {
        on = true;
    }

    public boolean doneTimer() {
        return minutes == 0 && seconds == 0;
    }
}
