import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class UIConsistencyTest extends AppTest {

    @Test
    public void testUIElementsPresent() {
        // Create an explicit wait instance.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // --- Verify Bottom Navigation Tabs ---
        By homeButton = By.xpath("//android.widget.Button[@content-desc=' Home ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeButton));
        Assert.assertTrue(driver.findElement(homeButton).isDisplayed(), "Home button is not displayed");
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));

        By compatibilityButton = By.xpath("//android.widget.Button[@content-desc=' Compatibility ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(compatibilityButton));
        Assert.assertTrue(driver.findElement(compatibilityButton).isDisplayed(), "Compatibility button is not displayed");
        wait.until(ExpectedConditions.elementToBeClickable(compatibilityButton));

        By videosButton = By.xpath("//android.widget.Button[@content-desc=' Videos ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(videosButton));
        Assert.assertTrue(driver.findElement(videosButton).isDisplayed(), "Videos button is not displayed");
        wait.until(ExpectedConditions.elementToBeClickable(videosButton));

        By dreamButton = By.xpath("//android.widget.Button[@content-desc=' Dream ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dreamButton));
        Assert.assertTrue(driver.findElement(dreamButton).isDisplayed(), "Dream button is not displayed");
        wait.until(ExpectedConditions.elementToBeClickable(dreamButton));

        // Optionally, you might click these buttons and verify that the subsequent screen loads properly.
        System.out.println("All bottom navigation tabs are visible and clickable.");
    }

    @Test
    public void testElementResponsiveness() {
        // Create an explicit wait instance.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By homeButton = By.xpath("//android.widget.Button[@content-desc=' Home ']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeButton));

        // Retrieve the dimensions of the Home button.
        Dimension homeButtonSize = driver.findElement(homeButton).getSize();
        int width = homeButtonSize.getWidth();
        int height = homeButtonSize.getHeight();

        System.out.println("Home button dimensions: " + width + "x" + height);

        // Assert that the dimensions are greater than zero.
        Assert.assertTrue(width > 0, "The Home button width should be greater than zero.");
        Assert.assertTrue(height > 0, "The Home button height should be greater than zero.");


    }
}
