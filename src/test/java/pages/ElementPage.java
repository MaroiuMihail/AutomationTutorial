package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementPage extends BasePage {
    public ElementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTableSubMenu;



    public void clickWebTable(){
        elementMethods.clickJSElement(webTableSubMenu);
    }
}
