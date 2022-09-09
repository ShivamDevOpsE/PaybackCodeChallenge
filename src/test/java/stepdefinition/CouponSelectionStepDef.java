package stepdefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CouponsPage;
import pageobjects.FilterPage;
import pageobjects.LoginPage;
import pageobjects.PaybackHome;
import utilities.BrowserManager;
import utilities.Hook;

import java.time.Duration;

import static utilities.Hook.extent;
import static utilities.Hook.extentTest;

public class CouponSelectionStepDef {
    //public WebDriver driver;

    /*public CouponSelectionStepDef() {
        this.driver = Hook.getDriver();
    }*/

    WebDriver driver = Hook.getDriver();

    //LoginPage login = new LoginPage(driver);
    PaybackHome paybackHome = new PaybackHome(driver);

    @When("Click on Coupons")
    public void click_on_coupons(){
        try {
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
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Selected Coupon for Rewe should be activated")
    public void selected_coupon_for_rewe_should_be_activated() {
        try {
            //create object for 'CouponsPage'
            CouponsPage coupons = new CouponsPage(driver);
            //Select first REWE coupon available
            coupons.reweCoupons.get(1).click();

            //Validate first 'Jetzt aktivieren' button for the selected coupon using Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(coupons.getCouponActBtn())).click();

            //Validate 'Aktiviert' section contains a coupon
            wait.until(ExpectedConditions.visibilityOf(coupons.aktiviertSect));

            if (coupons.aktiviertSect.isDisplayed()) {
                extentTest.log(Status.PASS, "'Aktiviert' section on the Coupons page got active coupon.");
            } else {
                extentTest.log(Status.FAIL, "Activating a REWE coupon failed.");
                String screen = BrowserManager.getScreenshot(driver, "ReweCouponSelectionFailed");
                extentTest.log(Status.INFO, String.valueOf(extentTest.addScreenCaptureFromPath(screen)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @And("Rewe coupon will be displayed in Active section")
        public void rewe_coupon_will_be_displayed_in_active_section(){
            try {
                //Switch to 'Aktiviert' section
                //create object for 'CouponsPage'
                CouponsPage coupons = new CouponsPage(driver);
                coupons.aktiviertSect.click();

                //Validate activated coupon is 'REWE'
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.visibilityOf(coupons.reweCoupons.get(1)));

                if (coupons.reweCoupons.get(1).isDisplayed()){
                    extentTest.log(Status.PASS, "REWE coupon displayed in the 'Aktiviert' section.");
                }
                else {
                    extentTest.log(Status.FAIL, "Rewe Coupon is still not active and did not display in the 'Aktiviert' section.");
                    String screen = BrowserManager.getScreenshot(driver, "ReweCouponSelectionFailed");
                    extentTest.log(Status.INFO, String.valueOf(extentTest.addScreenCaptureFromPath(screen)));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
}
