package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementPage extends BasePage {
    public ElementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTableSubMenu;



    public void clickWebTable(){
        elementMethods.clickJSElement(webTableSubMenu);
    }
}
