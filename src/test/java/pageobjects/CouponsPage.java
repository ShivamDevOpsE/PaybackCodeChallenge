package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CouponsPage extends BasePage {
    public CouponsPage(WebDriver driver) {
        super(driver);
    }

    //*** 'Filter' button at the top of the page
    @FindBy(xpath = "//*[@text='Filter']")
    public WebElement filterBtn;

    public WebElement getFilterBtn() {
        return filterBtn;
    }

    //*** 'Rewe' coupons after filter selection
    @FindBy(xpath = "(//*[@id='de.payback.client.android:id/constraint_container'])")
    public List<WebElement> reweCoupons;

    //public WebElement getReweCoupons() { return reweCoupons; }

    //*** 'Jetzt aktivieren' button for the first Rewe coupon
    @FindBy(xpath = "//*[@text='Jetzt aktivieren']")
    public WebElement couponActBtn;

    public WebElement getCouponActBtn() { return couponActBtn; }

    //*** 'Aktiviert' coupons section
    @FindBy(xpath = "//*[@text='Aktiviert (1)']")
    public WebElement aktiviertSect;

    public WebElement getAktiviertSect() { return aktiviertSect; }

    //***

}
