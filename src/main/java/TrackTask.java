import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.TimerTask;

public class TrackTask extends TimerTask {

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
            executeTask();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final MexicanCurrency mexicanCurrency = new MexicanCurrency(getTextFromWeb());

        double mxnCurrencyValue = mexicanCurrency.getCurrencyMXN();

        if (mxnCurrencyValue < 24.0) {
            final SendWhats sendWhats = new SendWhats(mxnCurrencyValue);
            sendWhats.sentAllWhats();
        }
    }

    private String executeTask() {
        String value = "";
        WebDriver driver = new FirefoxDriver();
        try {
            // Step # | name | target | value
            // 1 | open | / |
            driver.get("https://www.nexpay.com.au/");
            // 2 | setWindowSize | 1080x1920 |
            driver.manage().window().setSize(new Dimension(1920, 1080));
            // 3 | click | linkText=Our Rates |
            driver.findElement(By.linkText("Our Rates")).click();
            // 4 | selectFrame | index=0 |
            driver.switchTo().frame(0);
            Thread.sleep(5000);
            // 5 | click | id=currency-selector-to |
            driver.findElement(By.id("currency-selector-to")).click();
            // 6 | type | name=searchCurrency | eur
            driver.findElement(By.name("searchCurrency")).sendKeys("eur");
            // 7 | click | linkText=EUR - Euro |
            driver.findElement(By.linkText("EUR - Euro")).click();
            // 8 | click | id=currency-selector |
            Thread.sleep(2000);
            driver.findElement(By.id("currency-selector")).click();
            // 9 | type | css=.ng-untouched > .form-control | mxn
            driver.findElement(By.cssSelector(".ng-untouched > .form-control")).sendKeys("mxn");
            // 10 | click | linkText=MXN - Mexican Peso |
            driver.findElement(By.linkText("MXN - Mexican Peso")).click();
            Thread.sleep(2000);
            // 11 | click | css=.from-currency > p:nth-child(4) |
            value = driver.findElement(By.cssSelector(".from-currency > p:nth-child(4)")).getText();
            // 12 | click | css=.from-currency > p:nth-child(4) |
            System.out.println("value = " + value);
            setTextFromWeb(value);
            Thread.sleep(1000);
        } catch (Exception w) {
            System.out.println(w.getMessage());
        } finally {
            driver.close();
        }
        return value;
    }
}
