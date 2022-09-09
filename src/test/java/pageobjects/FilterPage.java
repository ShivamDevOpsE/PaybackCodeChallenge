package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends BasePage {
    public FilterPage(WebDriver driver) {
        super(driver);
    }

    //*** 'Rewe' Partner in the list
    @FindBy(xpath = "(//*[@id='de.payback.client.android:id/image'])[3]")
    public WebElement rewePartner;

    public WebElement getRewePartner() { return rewePartner; }
}
