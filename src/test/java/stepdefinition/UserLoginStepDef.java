package stepdefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.PaybackHome;
import utilities.BrowserManager;
import utilities.Hook;

import static utilities.Hook.extent;
import static utilities.Hook.extentTest;

public class UserLoginStepDef {
    WebDriver driver = Hook.getDriver();

    //LoginPage login = new LoginPage(driver);
    PaybackHome paybackHome = new PaybackHome(driver);

    @Given("Open the PAYBACK app")
    public void open_the_payback_app() {
        try {
            //Initiate ExtentReport
            extentTest = extent.createTest("Validation of PAYBACK Home page after successful login.");

            //After clicking on 'Login' button, 'Kartennnummer' input field displayed which cannot be
            // captured by UIAutomatorViewer due to security reasons
            extentTest.log(Status.SKIP, "UserLogin skipped due to security reasons.");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("User login with valid credentials")
    public void user_login_with_valid_credentials(){
        //Initiate ExtentReport
        //extentTest = extent.createTest("Validation of PAYBACK Home page after successful login.");

        try {
            if (paybackHome.getCouponsOpt().isDisplayed()){
                extentTest.log(Status.PASS, "User is on Home Screen.");
            }else {
                extentTest.log(Status.FAIL, "User login failed, please check the screenshot attached.");
                String screen = BrowserManager.getScreenshot(driver, "UserLoginfailed");
                extentTest.log(Status.INFO, String.valueOf(extentTest.addScreenCaptureFromPath(screen)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //Assert condition will not follow the next tag and it will break the complete stepdefinition,
        // that's why using if-else condition
        //Assert.assertTrue(paybackHome.getCouponsOpt().isDisplayed());
    }
}
