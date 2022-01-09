import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import java.util.Date;
import java.util.Random;
import java.util.TimerTask;

import static spark.Spark.*;

public class ReplyWhats extends TimerTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReplyWhats.class);

    public synchronized void post() throws InterruptedException {
        final SeleniumTask seleniumTask = new SeleniumTask();
        LOGGER.info("Stopping server...");
        stop();
        awaitStop();
        LOGGER.info("Initiating server...");
        Spark.init();
        awaitInitialization();

        final Random randomIdentifier = new Random();

        final String text = seleniumTask.getText() + "\nID: " + randomIdentifier.nextInt(1000);
        LOGGER.info("Text from web as a replied: " + text);

        Spark.post("/sms", (req, res) -> {
            LOGGER.info(Main.DATE_FORMAT.format(new Date()) + " Post call...");
            res.type("application/xml");
            Body body = new Body
                    .Builder(text)
                    .build();
            Message sms = new Message
                    .Builder()
                    .body(body)
                    .build();
            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
            System.out.println(twiml.toXml());
            return twiml.toXml();
        });
    }

    @Override
    public void run() {
        try {
            post();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
