package tests;

import com.beust.ah.A;
import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {
    public WebDriver driver;

    @Test
    public void metodaTest () {

        driver = new EdgeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        AlertMethods alertMethods = new AlertMethods(driver);

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertFrameWindowMenu);

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementMethods.clickElement(alertsElement);

        WebElement okAlert = driver.findElement(By.id("alertButton"));
        elementMethods.clickElement(okAlert);
        alertMethods.acceptAlert();

        WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickJSElement(timerAlertButtonElement);
        alertMethods.acceptAlert();

        WebElement alertConfirm = driver.findElement(By.id("confirmButton"));
        elementMethods.clickElement(alertConfirm);
        alertMethods.dismissAlert();

        WebElement promptButtonAlert = driver.findElement(By.id("promtButton"));
        elementMethods.clickElement(promptButtonAlert);
        alertMethods.fillAlert("This is a test");

    }
    }
