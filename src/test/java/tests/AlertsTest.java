package tests;

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

        WebElement alertframewindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertframewindowMenu);

        WebElement alertswindowMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        js.executeScript("arguments[0].click();", alertswindowMenu);

        WebElement okAlert = driver.findElement(By.id("alertButton"));
        okAlert.click();

        Alert firstAlert = driver.switchTo().alert();
        System.out.println(firstAlert.getText());
        firstAlert.accept();

        WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
        js.executeScript("arguments[0].click();", timerAlertButtonElement);

        //wait explicit
        WebDriverWait waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());

        Alert secondAlert = driver.switchTo().alert();
        System.out.println(secondAlert.getText());
        secondAlert.accept();

        WebElement alertConfirm = driver.findElement(By.id("confirmButton"));
        alertConfirm.click();

        Alert thirdalert = driver.switchTo().alert();
        System.out.println(thirdalert.getText());
        thirdalert.dismiss();

        WebElement alertPrompt = driver.findElement(By.id("promtButton"));
        alertPrompt.click();

        Alert fourthalert = driver.switchTo().alert();
        System.out.println(fourthalert.getText());
        fourthalert.sendKeys("This is a test");
        fourthalert.accept();




    }
    }
