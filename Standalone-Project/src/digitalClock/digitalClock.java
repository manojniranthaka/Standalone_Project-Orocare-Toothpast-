package digitalClock;
import javax.swing.JLabel;

public class digitalClock {

    JLabel clockLabel;
    String type;

    public digitalClock(JLabel clockLabel, String type) {
        this.clockLabel = clockLabel;
        this.type = type;
        this.show();
    }

    private void show() {
        try {
            if (type.equals("DATE")) {
                this.setDate();
            } else if (type.equals("TIME")) {
                this.setTime();
            } else if (type.equals("DAY")) {
                this.setDay();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDate() {
        dateThread thread = new dateThread(clockLabel);
        thread.run();
    }

    private void setTime() {
        timeThread thread = new timeThread(clockLabel);
        thread.start();
    }

    private void setDay() {
        dayThread thread = new dayThread(clockLabel);
        thread.run();
    }
}
