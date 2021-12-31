import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class SendSMS {
    private final String bodyMessage;

    public SendSMS(double mxnCurrency) {
        Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
        this.bodyMessage = "\nNexpay:\n1 EUR  = " + mxnCurrency + " MXN";
    }

    private void sendSMSToStep() {
        final Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(Constants.STEPH_NUMBER),
                        new com.twilio.type.PhoneNumber(Constants.SMS_NUMBER),
                        "Hola Stephanie, gonito dia." + bodyMessage)
                .create();
        System.out.println(message.getBody());
    }

    private void sendSMSToMe() {
        final Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(Constants.ME_NUMBER),
                        new com.twilio.type.PhoneNumber(Constants.SMS_NUMBER),
                        "Hey Dyno." + bodyMessage)
                .create();
        System.out.println(message.getBody());
    }

    public void sentAllSMS() {
        sendSMSToMe();
        sendSMSToStep();
    }
}