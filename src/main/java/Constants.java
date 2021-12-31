public final class Constants {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID"); //"AC8778744a9e5c10a01e6df7e9a83ef58f";
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN"); // "d07429ebc7d03aa2d7745b5b0f0d17b0";

    public static final String STEPH_NUMBER = System.getenv("STEPH_NUMBER");
    public static final String ME_NUMBER = System.getenv("ME_NUMBER");


    public static final String WHATS_NUMBER = System.getenv("WHATS_NUMBER");
    public static final String SMS_NUMBER = System.getenv("SMS_NUMBER");

}
