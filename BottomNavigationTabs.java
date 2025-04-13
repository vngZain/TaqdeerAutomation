import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BottomNavigationTabs extends AppTest {

    @Test
    public void testBottomNavigationTabs() throws InterruptedException {
        // Create an explicit wait instance.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Locators for the bottom navigation buttons.
        By homeButton = By.xpath("//android.widget.Button[@content-desc=' Home ']");
        By horoscopeButton = By.xpath("//android.widget.Button[@content-desc=' Horoscope ']");
        By profileButton = By.xpath("//android.widget.Button[@content-desc=' Profile ']");
        // Add additional locators for other tabs as needed.

        // Locators for elements that should be visible on each screen.
        By homeScreenUniqueElement = By.id("com.jazz.sitaronkahaal:id/home_unique"); // Update with your unique locator.
        By horoscopeScreenUniqueElement = By.id("com.jazz.sitaronkahaal:id/horoscope_unique"); // Update with your unique locator.
        By profileScreenUniqueElement = By.id("com.jazz.sitaronkahaal:id/profile_unique"); // Update with your unique locator.

        // --- Test Home Tab ---
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        driver.findElement(homeButton).click();
        // Optionally, wait for a brief time to allow screen transition.
        Thread.sleep(2000);
        // Verify that an element unique to the Home screen is present.
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeScreenUniqueElement));
        Assert.assertTrue(driver.findElements(homeScreenUniqueElement).size() > 0, "Home screen not loaded correctly.");

        // --- Test Horoscope Tab ---
        wait.until(ExpectedConditions.elementToBeClickable(horoscopeButton));
        driver.findElement(horoscopeButton).click();
        Thread.sleep(2000);
        // Verify the Horoscope screen; adjust the locator appropriately.
        wait.until(ExpectedConditions.visibilityOfElementLocated(horoscopeScreenUniqueElement));
        Assert.assertTrue(driver.findElements(horoscopeScreenUniqueElement).size() > 0, "Horoscope screen not loaded correctly.");

        // --- Test Profile Tab ---
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        driver.findElement(profileButton).click();
        Thread.sleep(2000);
        // Verify the Profile screen.
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileScreenUniqueElement));
        Assert.assertTrue(driver.findElements(profileScreenUniqueElement).size() > 0, "Profile screen not loaded correctly.");

        // You can add similar blocks for any additional tabs.
    }
}
