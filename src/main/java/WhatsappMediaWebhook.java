

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Media;
import com.twilio.twiml.messaging.Message;

@WebServlet(urlPatterns = { "/" })
public class WhatsappMediaWebhook extends HttpServlet {
    private static final String GOOD_BOY_URL = "https://images.unsplash.com/photo-1518717758536-85ae29035b6d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        var numMedia = Integer.parseInt(request.getParameter("NumMedia"));
        var twimlResponse = new MessagingResponse.Builder();
        if (numMedia > 0) {
            twimlResponse.message(
                    new Message.Builder().body(new Body.Builder("Thanks for the image! Here's one for you!").build())
                            .media(new Media.Builder(GOOD_BOY_URL).build()).build());
        } else {
            twimlResponse.message(new Message.Builder().body(new Body.Builder("Send us an image!").build()).build());
        }

        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(twimlResponse.build().toXml());

        out.flush();
        out.close();
    }

}
