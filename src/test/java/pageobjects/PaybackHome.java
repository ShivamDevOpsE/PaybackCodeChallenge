package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaybackHome extends BasePage {
    public PaybackHome(WebDriver driver) { super(driver); }

    //*** Scan bubble at the bottom of Home Screen
    @FindBy(xpath = "//*[@id='de.payback.client.android:id/fab_action_card_selection']")
    public WebElement scanCard;

    public WebElement getScanCard() { return scanCard; }

    //*** 'Coupons' section at the Home screen
    @FindBy(xpath = "//*[@id='de.payback.client.android:id/coupon_center_dest']")
    public WebElement couponsOpt;

    public WebElement getCouponsOpt() { return couponsOpt; }

    //***

}
