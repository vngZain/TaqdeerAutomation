import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HoroscopeTest extends AppTest {

    // This test depends on a successful login.
    @Test(dependsOnMethods = {"LoginTest.testLoginFlow"})
    public void testHoroscopeFlow() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Allow time for the horoscope screen to load.
        Thread.sleep(20000);

        // -----------------------------
        // 1. Click the "View more" button.
        // -----------------------------
        By viewMoreButton = By.xpath("//android.view.ViewGroup[@content-desc='View more']");
        if (!driver.findElements(viewMoreButton).isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(viewMoreButton));
            driver.findElement(viewMoreButton).click();
        }

        // -----------------------------
        // 2. Process the Zodiac horizontal list.
        // -----------------------------
        String[] zodiacElements = {
                "//android.view.ViewGroup[@content-desc='Aries']",
                "//android.view.ViewGroup[@content-desc='Taurus']",
                "//android.view.ViewGroup[@content-desc='Gemini']",
                "//android.view.ViewGroup[@content-desc='Cancer']",
                "//android.widget.TextView[@text='Leo']",
                "//android.view.ViewGroup[@content-desc='Virgo']",
                "//android.view.ViewGroup[@content-desc='Libra']",
                "//android.widget.TextView[@text='Scorpio']",
                "//android.view.ViewGroup[@content-desc='Sagittarius']",
                "//android.view.ViewGroup[@content-desc='Capricorn']",
                "//android.view.ViewGroup[@content-desc='Pisces']"
        };

        for (String xpath : zodiacElements) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                driver.findElement(By.xpath(xpath)).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Zodiac element not found or not clickable: " + xpath);
            }
        }

        // -----------------------------
        // 3. Process Time Sorting Options.
        // -----------------------------
        String[] timeSortingOptions = {
                "//android.widget.TextView[@text='Yesterday']",
                "//android.widget.TextView[@text='Today']",
                "//android.widget.TextView[@text='Tomorrow']",
                "//android.widget.TextView[@text='Weekly']",
                "//android.widget.TextView[@text='Monthly']",
                "//android.widget.TextView[@text='Yearly']"
        };

        for (String xpath : timeSortingOptions) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                driver.findElement(By.xpath(xpath)).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Time sorting option not found: " + xpath);
            }
        }

        // -----------------------------
        // 4. Click the "Share with Friend" Button.
        // -----------------------------
        By shareButton = By.xpath("//android.view.ViewGroup[@content-desc='Share with Friend']");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(shareButton));
            driver.findElement(shareButton).click();
        } catch (Exception e) {
            System.out.println("Share button not clickable: " + e.getMessage());
        }
    }
}
