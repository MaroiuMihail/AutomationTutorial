package pages;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabWindowPage extends BasePage {



    @FindBy(id = "tabButton")
    private WebElement tabButtonElement;
    @FindBy(id = "windowButton")
    private WebElement windowButtonElement;

    public TabWindowPage(WebDriver driver) {
        super(driver);
    }

    public void dealTabProcess(){

        elementMethods.clickJSElement(tabButtonElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);
    }
    public void dealWindowProcess(){

        elementMethods.clickJSElement(windowButtonElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        driver.quit();
    }
}
