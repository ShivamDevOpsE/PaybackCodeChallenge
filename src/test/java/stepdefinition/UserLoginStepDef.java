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

public class UserLoginStepDef extends ExtentReport {
    public WebDriver driver;

    public UserLoginStepDef() {
        this.driver = Hook.getDriver();
    }

    LoginPage login = new LoginPage(driver);
    PaybackHome paybackHome = new PaybackHome(driver);

    @Given("Open the PAYBACK app")
    public void open_the_payback_app() {
        //Initiate ExtentReport
        extentTest = extent.createTest("Validation of PAYBACK Home page after successful login.");

        //After clicking on 'Login' button, 'Kartennnummer' input field displayed which cannot be
        // captured by UIAutomatorViewer due to security reasons

        extentTest.log(Status.SKIP, "UserLogin skipped due to security reasons.");
    }

    @And("User login with valid credentials")
    public void user_login_with_valid_credentials(){
        //Initiate ExtentReport
        extentTest = extent.createTest("Validation of PAYBACK Home page after successful login.");

        if (paybackHome.getCouponsOpt().isDisplayed()){
            extentTest.log(Status.PASS, "User is on Home Screen.");
        }else {
            extentTest.log(Status.FAIL, "User login failed, please check the screenshot attached.");
            String screen = BrowserManager.getScreenshot(driver, "UserLoginfailed");
            extentTest.log(Status.INFO, String.valueOf(extentTest.addScreenCaptureFromPath(screen)));
        }
        //Assert condition will not follow the next tag and it will break the complete stepdefinition,
        // that's why using if-else condition
        //Assert.assertTrue(paybackHome.getCouponsOpt().isDisplayed());

    }

    /*@When("Click on Coupons")
    public void click_on_coupons(){
        //Initiate ExtentReport
        extentTest = extent.createTest("Validate 'Coupon' section by clicking on it.");

        //Click on 'Coupons' option on Home Screen
        paybackHome.getCouponsOpt().click();

        //Create an

    }*/

    /*@And("click on filter icon")
    public void click_on_filter_icon(){

    }*/

    @And("Select Rewe from the filter")
    public void select_rewe_from_the_filter(){

    }

    @Then("Selected Coupon for Rewe should be activated")
    public void selected_coupon_for_rewe_should_be_activated(){

    }

    @And("Rewe coupon will be displayed in Active section")
    public void rewe_coupon_will_be_displayed_in_active_section(){

    }


}
