import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LoginTest extends AppTest {

    @Test
    public void testLoginFlow() throws InterruptedException {
        // Create an explicit wait instance.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Locator for the mobile number field; we assume there's only one EditText on the login screen.
        By mobileNumberField = By.xpath("(//android.widget.EditText)[1]");

        // Send an invalid mobile number.
        driver.findElement(mobileNumberField).sendKeys("0123456789");

        // Click the "Send OTP" button.
        By sendOtpButton = By.xpath("//android.widget.TextView[@text=' Send OTP ']");
        driver.findElement(sendOtpButton).click();

        // Wait for potential error pop-up.
        Thread.sleep(5000);

        // Locator for the error popup "Ok" button.
        By okButton = By.xpath("//android.view.ViewGroup[@content-desc=' Ok ']");
        List<?> okButtons = driver.findElements(okButton);

        if (!okButtons.isEmpty()) {
            // Dismiss the error popup.
            driver.findElement(okButton).click();
            Thread.sleep(5000);

            // Clear the mobile number field by sending DELETE keys until empty.
            String currentText = driver.findElement(mobileNumberField).getText();
            int attempts = 0;
            while (!currentText.isEmpty() && attempts < 20) {
                driver.pressKey(new KeyEvent(AndroidKey.DEL));
                Thread.sleep(200);
                currentText = driver.findElement(mobileNumberField).getText();
                attempts++;
            }

            // Enter the valid mobile number.
            driver.findElement(mobileNumberField).sendKeys("3219169057");
            Thread.sleep(5000);

            // Click "Send OTP" again.
            driver.findElement(sendOtpButton).click();
        } else {
            System.out.println("No error popup detected. Verify the locator or app behavior.");
        }
    }
}
