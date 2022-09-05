package stepdefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pageobjects.CouponsPage;
import pageobjects.FilterPage;
import pageobjects.LoginPage;
import pageobjects.PaybackHome;
import utilities.BrowserManager;
import utilities.Hook;

public class FilterSelectionStepDef extends ExtentReport {
    public WebDriver driver;

    public FilterSelectionStepDef() {
        this.driver = Hook.getDriver();
    }

    LoginPage login = new LoginPage(driver);
    CouponsPage coupons = new CouponsPage(driver);

    @And("click on filter icon")
    public void click_on_filter_icon() {
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
}
