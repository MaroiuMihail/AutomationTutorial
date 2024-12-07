package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowPage extends BasePage {


    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsElement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserwindowMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesSubMenu;

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    public void  clickAlert(){
        elementMethods.clickElement(alertsElement);
    }

    public void clickBrowserwindowMenu(){
        elementMethods.clickJSElement(browserwindowMenu);
    }

    public void clickFramesSubMenu(){
        elementMethods.clickJSElement(framesSubMenu);
    }




}
