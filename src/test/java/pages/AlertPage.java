package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage extends BasePage{

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement okAlertElement;

    @FindBy(id = "timerAlertButton")
    private  WebElement timerAlertButtonElement;

    @FindBy(id = "confirmButton")
    private  WebElement alertConfirmElement;

    @FindBy(id = "promtButton")
    private WebElement promtButtonAlertElement;


    public void dealAlertProcess(String text){
        elementMethods.clickElement(okAlertElement);
        alertMethods.acceptAlert();
        elementMethods.clickJSElement(timerAlertButtonElement);
        alertMethods.acceptAlert();
        elementMethods.clickJSElement(alertConfirmElement);
        alertMethods.dismissAlert();
        elementMethods.clickElement(promtButtonAlertElement);
        alertMethods.fillAlert(text);
    }


}
