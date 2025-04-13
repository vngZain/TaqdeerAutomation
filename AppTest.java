import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        // --------------------------------------------------
        // 1. Setup Desired Capabilities & Initialize Driver
        // --------------------------------------------------
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android"); // Standard W3C capability.
        cap.setCapability("appium:deviceName", "Galaxy A50");
        cap.setCapability("appium:udid", "R58M96352WT");
        cap.setCapability("appium:platformVersion", "11");
        cap.setCapability("appium:automationName", "uiautomator2");
        cap.setCapability("appium:appPackage", "com.jazz.sitaronkahaal");
        cap.setCapability("appium:appActivity", "com.jazz.sitaronkahaal.MainActivity");

        URL serverUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(serverUrl, cap);

        // Wait for the app to load.
        Thread.sleep(10000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
