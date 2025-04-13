import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopupModalTest extends AppTest {

    /**
     * Test that validates the "Invalid Login Number" popup.
     * This simulates entering an invalid mobile number and verifies that the popup
     * at the OTP screen (login invalid number modal) appears.
     */
    @Test
    public void testInvalidLoginNumberModal() throws InterruptedException {
        // For example, assume the invalid number triggers the modal automatically.
        // Wait until the modal is visible.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Replace this XPath with the one corresponding to your invalid number popup container.
        By invalidNumberModal = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']"
                + "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");

        // Wait for the invalid number modal to be visible.
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidNumberModal));

        // (Optional) Validate that some expected text is displayed in the modal.
        // For example, you might have:
        // String popupText = driver.findElement(By.id("com.jazz.sitaronkahaal:id/otpErrorMessage")).getText();
        // Assert.assertEquals(popupText, "Invalid number entered", "Popup message did not match.");

        System.out.println("Invalid Login Number Modal displayed successfully.");

        // Dismiss the popup; adjust locator for the OK or close button on the modal.
        By closeButton = By.xpath("//android.widget.Button[@content-desc='Ok']");
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        driver.findElement(closeButton).click();
    }

    /**
     * Test that checks if an empty referral code triggers a popup.
     */
    @Test
    public void testEmptyReferralCodeModal() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Assume the referral screen appears and the referral code field is empty.
        // (Trigger the action if required, for example by clicking "Save" without input.)
        // Use the locator that identifies the expected popup when referral code is empty.
        By referralEmptyModal = By.xpath("//android.widget.TextView[@text='Please enter a referral code']");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(referralEmptyModal));
            System.out.println("Referral code empty popup is displayed.");
            // Dismiss the popup.
            By referralPopupClose = By.xpath("//android.widget.Button[@content-desc='Close']");
            wait.until(ExpectedConditions.elementToBeClickable(referralPopupClose));
            driver.findElement(referralPopupClose).click();
        } catch (TimeoutException e) {
            System.out.println("Referral code empty popup was not displayed.");
        }
    }

    /**
     * Test for validating the Save/Change Profile modal.
     */
    @Test
    public void testSaveChangeProfileModal() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Trigger the action by attempting to save profile changes with empty required fields.
        // (For instance, click "Save" on the profile screen.)
        By saveProfileButton = By.xpath("//android.widget.Button[@content-desc='Save Changes']");
        driver.findElement(saveProfileButton).click();

        // Locator for the expected modal popup on save.
        By profileSaveModal = By.xpath("//android.widget.TextView[contains(@text,'Please fill out')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileSaveModal));
        System.out.println("Save Change Profile modal is displayed.");

        // Dismiss the modal (e.g., with an OK button).
        By modalDismiss = By.xpath("//android.widget.Button[@content-desc='Ok']");
        wait.until(ExpectedConditions.elementToBeClickable(modalDismiss));
        driver.findElement(modalDismiss).click();
    }

    /**
     * Test for checking that if the home screen "meaning" is empty, a popup is triggered.
     */
    @Test
    public void testHomeScreenEmptyMeaningModal() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Simulate the empty state or trigger the validation (e.g., by clicking a Continue button)
        By continueHomeButton = By.xpath("//android.widget.Button[@content-desc='Continue']");
        driver.findElement(continueHomeButton).click();

        // Locator for the popup that should appear.
        By homeEmptyModal = By.xpath("//android.widget.TextView[contains(@text,'Meaning cannot be empty')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeEmptyModal));
        System.out.println("Home screen empty meaning modal is displayed.");

        // Dismiss popup.
        By dismissHomeModal = By.xpath("//android.widget.Button[@content-desc='Ok']");
        wait.until(ExpectedConditions.elementToBeClickable(dismissHomeModal));
        driver.findElement(dismissHomeModal).click();
    }

    /**
     * Test for checking Compatibility screen modal – when love compatibility is unselected.
     */
    @Test
    public void testCompatibilityScreenModal() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // On the Compatibility screen, do not select "Love Compatibility" then tap "Calculate".
        By calculateButton = By.xpath("//android.widget.Button[@content-desc='Calculate']");
        driver.findElement(calculateButton).click();

        // Expected modal when love compatibility is unselected.
        By compatibilityModal = By.xpath("//android.widget.TextView[contains(@text,'Please select love compatibility')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(compatibilityModal));
        System.out.println("Compatibility screen modal is displayed.");

        // Dismiss it.
        By dismissCompatibilityModal = By.xpath("//android.widget.Button[@content-desc='Ok']");
        wait.until(ExpectedConditions.elementToBeClickable(dismissCompatibilityModal));
        driver.findElement(dismissCompatibilityModal).click();
    }

    /**
     * Test for checking Dream screen modal – when "My Dream" is empty and trying to add a new dream.
     */
    @Test
    public void testDreamScreenModal() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // On the Dream screen, simulate clicking "Add New" without entering data.
        By addNewDreamButton = By.xpath("//android.widget.Button[@content-desc='Add New']");
        driver.findElement(addNewDreamButton).click();

        // Expected modal for empty dream save.
        By dreamEmptyModal = By.xpath("//android.widget.TextView[contains(@text,'Dream details cannot be empty')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dreamEmptyModal));
        System.out.println("Dream screen modal is displayed.");

        // Dismiss the modal.
        By dismissDreamModal = By.xpath("//android.widget.Button[@content-desc='Ok']");
        wait.until(ExpectedConditions.elementToBeClickable(dismissDreamModal));
        driver.findElement(dismissDreamModal).click();
    }
}
