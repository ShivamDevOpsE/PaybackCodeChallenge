package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrowserManager {
    //Hard sleep to wait for element to be visible completely
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Take screenshots of failure cases
    /*public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String returnPath = "./FailedTestsScreenshots/"+ screenshotName + dateName + ".png";
        String path = System.getProperty("user.dir")+ "/test-output/FailedTestsScreenshots/"+ screenshotName + dateName + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(src, destination);
        }
        catch(IOException e){
            System.out.println("Capture Failed" +e.getMessage());
        }
        return returnPath;
    }*/
}
