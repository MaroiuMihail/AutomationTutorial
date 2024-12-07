package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage {


    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsElement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserwindowMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesSubMenu;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFramesSubMenu;

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlert() {
        elementMethods.clickElement(alertsElement);
    }

    public void clickBrowserwindowMenu() {
        elementMethods.clickJSElement(browserwindowMenu);
    }

    public void clickFramesSubMenu() {
        elementMethods.clickJSElement(framesSubMenu);
    }

    public void clickNestedFramesSubMenu() {
        elementMethods.clickJSElement(nestedFramesSubMenu);
    }


}
