public final class Constants {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID"); 
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static final String STEPH_NUMBER = System.getenv("STEPH_NUMBER");
    public static final String ME_NUMBER = System.getenv("ME_NUMBER");


    public static final String WHATS_NUMBER = System.getenv("WHATS_NUMBER");
    public static final String SMS_NUMBER = System.getenv("SMS_NUMBER");

    public static final String IMAGE_BULL="https://images.unsplash.com/photo-1550482172-e2f17c6fc13b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1354&q=80";
}
