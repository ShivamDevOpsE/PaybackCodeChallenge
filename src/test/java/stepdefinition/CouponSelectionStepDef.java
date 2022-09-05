package stepdefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.CouponsPage;
import pageobjects.LoginPage;
import pageobjects.PaybackHome;
import utilities.BrowserManager;
import utilities.Hook;

public class CouponSelectionStepDef extends ExtentReport {
    public WebDriver driver;

    public CouponSelectionStepDef() {
        this.driver = Hook.getDriver();
    }

    LoginPage login = new LoginPage(driver);
    PaybackHome paybackHome = new PaybackHome(driver);

    @When("Click on Coupons")
    public void click_on_coupons(){
        //Initiate ExtentReport
        extentTest = extent.createTest("Validate 'Coupon' section by clicking on it.");

        //Click on 'Coupons' option on Home Screen
        paybackHome.getCouponsOpt().click();
        BrowserManager.waitFor(2);

        //Validate 'Filter' button on Coupon page
        //create object for 'CouponsPage'
        CouponsPage coupons = new CouponsPage(driver);

        if (coupons.getFilterBtn().isDisplayed()){
            extentTest.log(Status.PASS, "Coupons page displayed with 'Filter' button.");
        }else {
            extentTest.log(Status.FAIL, "Clicking on 'Coupons' option on Home Screen failed.");
            String screen = BrowserManager.getScreenshot(driver, "CouponsSectFailed");
            extentTest.log(Status.INFO, String.valueOf(extentTest.addScreenCaptureFromPath(screen)));
        }
    }
}
