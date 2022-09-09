package stepdefinition;

import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pageobjects.CouponsPage;
import pageobjects.FilterPage;
import pageobjects.LoginPage;
import pageobjects.PaybackHome;
import utilities.BrowserManager;
import utilities.Hook;

import static utilities.Hook.extent;
import static utilities.Hook.extentTest;

public class FilterSelectionStepDef {
    WebDriver driver = Hook.getDriver();

    //LoginPage login = new LoginPage(driver);
    CouponsPage coupons = new CouponsPage(driver);

    @And("click on filter icon")
    public void click_on_filter_icon() {
        try {
            //Initiate ExtentReport
            extentTest = extent.createTest("Verify 'Filter' button by clicking on it.");

            //Click on 'Filter' button on Coupons page
            coupons.getFilterBtn().click();
            BrowserManager.waitFor(2);

            //Validate Filter page content
            //Create object for 'FilterPage'
            FilterPage filter = new FilterPage(driver);

            if (filter.getRewePartner().isDisplayed()) {
                extentTest.log(Status.PASS, "'Filter' page opened with the option to select different Coupons.");
            } else {
                extentTest.log(Status.FAIL, "'Filter' page failed to open.");
                String screen = BrowserManager.getScreenshot(driver, "FilterPageFailed");
                extentTest.log(Status.INFO, String.valueOf(extentTest.addScreenCaptureFromPath(screen)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("Select Rewe from the filter")
    public void select_rewe_from_the_filter(){
        try {
            //Create object for 'FilterPage'
            FilterPage filter = new FilterPage(driver);
            filter.getRewePartner().click();

            //Validate all the rewe coupons available
            if (!coupons.reweCoupons.isEmpty()) {
                extentTest.log(Status.PASS, "List of all the available REWE coupons displayed on the 'Coupons' page.");
            }
            else {
                extentTest.log(Status.FAIL, "REWE coupons list is empty or selection of filter REWE is failed");
                String screen = BrowserManager.getScreenshot(driver, "FilterPageFailed");
                extentTest.log(Status.INFO, String.valueOf(extentTest.addScreenCaptureFromPath(screen)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
