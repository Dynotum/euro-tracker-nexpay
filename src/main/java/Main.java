import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        LOGGER.info("Welcome!");

        final ScheduledExecutorService ser = Executors.newScheduledThreadPool(2);

        // This task is scheduled to run every 3 mins
        // Task in charge of replies messages from whatsapp.
        // Bounces spark server and updates getting mxn currency
        ser.scheduleAtFixedRate(new ReplyWhats(), 0, 180000, TimeUnit.MILLISECONDS);

        // This task is scheduled to run every 2 hours
        // It will send a whatsapp notify message if 1 euro currency is less than $24.0 mxn currency
        ser.scheduleAtFixedRate(new FrequentTask(), 0, 7200000, TimeUnit.MILLISECONDS);
        // Test This task is scheduled to run every 2 mins
        // ser.scheduleAtFixedRate(new FrequentTask(), 3000, 180000, TimeUnit.MILLISECONDS);;
    }
}
