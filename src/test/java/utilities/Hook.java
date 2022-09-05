package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hook {

    //private static WebDriver driver;

    public static AppiumDriver driver;
    FileInputStream fis;
    Properties property;

    public void setup() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Redmi Note 11 Pro+ 5G");
        capabilities.setCapability("udid", "5hgueezx8xss8t75");  //Change this according to adb devices
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("noSign", "true");
        capabilities.setCapability("appPackage", "de.payback.client.android");
        capabilities.setCapability("appActivity", "de.payback.app.deeplinks.StarterActivity");
        //driver = new AndroidDriver<WebElement>(new URL("http://" + IP + ":" + port + "/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //** I tried to start the appium server automatically, but it was showing some
        //** permission error due to my phone so we just need to start the appium server
        //** manually on IP: 127.0.0.1 and port 4723(default).


        // Using page object method to save Id's for webelements in separate property file
        // 'config.properties' under 'resources' folder
        fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\config.properties");
        property = new Properties();
        property.load(fis);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public void tearDown() {
        driver.quit();
        //extent.flush();
    }

}
