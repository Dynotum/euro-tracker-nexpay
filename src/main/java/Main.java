import java.util.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Welcome!");

        final Timer t = new Timer();
        // This task is scheduled to run every 3 mins
        // Task in charge of replies messages from whatsapp.
        // Bounces spark server and updates getting mxn currency
        t.scheduleAtFixedRate(new ReplyWhats(), 0, 180000);

        // This task is scheduled to run every 2 hours
        t.scheduleAtFixedRate(new FrequentTask(), 0, 7200000);
        // Test This task is scheduled to run every 2 mins
        // t.scheduleAtFixedRate(new FrequentTask(), 0, 120000);
    }
}
