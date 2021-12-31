import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SendWhats {
    private final String bodyMessage;

    public SendWhats(double mxnCurrency) {
        Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
        this.bodyMessage = "\nNexpay:\n1 EUR  = " + mxnCurrency + " MXN";
    }

    private void sendWhatsToStep() {
        final Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:" + Constants.STEPH_NUMBER),
                        new com.twilio.type.PhoneNumber("whatsapp:" + Constants.WHATS_NUMBER),
                        "Hola Stephanie, bonito dia." + bodyMessage
                )
                .create();
        System.out.println(message.getBody());
    }

    private void sendWhatsToMe() {
        final Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:" + Constants.ME_NUMBER),
                        new com.twilio.type.PhoneNumber("whatsapp:" + Constants.WHATS_NUMBER),
                        "Hey Dyno." + bodyMessage)
                .create();
        System.out.println(message.getBody());
    }

    public void sentAllWhats() {
        sendWhatsToMe();
        sendWhatsToStep();
    }
}