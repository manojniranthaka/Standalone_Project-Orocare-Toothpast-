package digitalClock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;


public class dateThread extends Thread {

    JLabel clockLabel;

    public dateThread(JLabel clockLabel) {
        this.clockLabel = clockLabel;
    }

    public void run() {
        DateFormat dateandtime = new SimpleDateFormat("MMMM dd yyyy");
        Timer t = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                clockLabel.setText(dateandtime.format(date));
                clockLabel.repaint();
            }
        });
        t.start();
    }
}
