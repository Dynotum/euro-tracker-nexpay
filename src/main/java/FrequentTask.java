import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.TimerTask;

public class FrequentTask extends TimerTask {

    private String textFromWeb;

    public String getTextFromWeb() {
        return textFromWeb;
    }

    public void setTextFromWeb(String textFromWeb) {
        this.textFromWeb = textFromWeb;
    }

    @Override
    public void run() {
        try {
            final SeleniumTask seleniumTask = new SeleniumTask();
            setTextFromWeb(seleniumTask.getText());
            Thread.sleep(5000);

            final MexicanCurrency mexicanCurrency = new MexicanCurrency(getTextFromWeb());

            double mxnCurrencyValue = mexicanCurrency.getCurrencyMXN();

            if (mxnCurrencyValue < 24.0) {
                final SendWhats sendWhats = new SendWhats(mxnCurrencyValue);
                sendWhats.sentAllWhats();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
