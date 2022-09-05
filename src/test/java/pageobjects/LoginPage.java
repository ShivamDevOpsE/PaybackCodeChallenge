package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "")
    public WebElement kundennummerField;

    public WebElement getKundennummerField() { return kundennummerField; }





}
