import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class SendWhats {
    private final String bodyMessage;
    private static final Logger LOGGER = LoggerFactory.getLogger(SendWhats.class);

    public SendWhats(double mxnCurrency) {
        Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
        this.bodyMessage = "\nNexpay:\n1 EUR  = " + mxnCurrency + " MXN";
    }

    private void sendWhatsToStep() {
        final Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:" + Constants.STEPH_NUMBER),
                        new com.twilio.type.PhoneNumber("whatsapp:" + Constants.WHATS_NUMBER),
                        "Hola Stephanie, bonito dia." + bodyMessage)
//                .setMediaUrl(
//                        List.of(URI.create(Constants.IMAGE_BULL)))
                .create();
        LOGGER.info("STEPH message:\n" + message.getBody());
    }

    private void sendWhatsToMe() {
        final Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:" + Constants.ME_NUMBER),
                        new com.twilio.type.PhoneNumber("whatsapp:" + Constants.WHATS_NUMBER),
                        " Hey Dyno." + bodyMessage)
//                .setMediaUrl(
//                        List.of(URI.create(Constants.IMAGE_BULL)))
                .create();
        LOGGER.info("DYNO message:\n" + message.getBody());
    }

    public void sentAllWhats() {
        LOGGER.info(Main.DATE_FORMAT.format(new Date()));
        sendWhatsToMe();
        sendWhatsToStep();
    }
}