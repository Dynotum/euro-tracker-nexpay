import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        Timer t = new Timer();
        TrackTask task = new TrackTask();
        // This task is scheduled to run every 60 seconds = 60000
        t.scheduleAtFixedRate(task, 0, 10800000);
    }
}
