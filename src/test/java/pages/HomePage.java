package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{



    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertFrameWindowMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertFrameWindow(){
        elementMethods.clickJSElement(alertFrameWindowMenu);
    }
    public void clickElementsMenu(){
        elementMethods.clickJSElement(elementsMenu);
    }

}
