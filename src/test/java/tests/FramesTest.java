package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FramesTest {
    public WebDriver driver;

    @Test
    public void metodaTest () {

        driver = new EdgeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();


        WebElement alertframewindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertframewindowMenu);

        WebElement framesSubMenu= driver.findElement(By.xpath("//span[text()='Frames']"));
        js.executeScript("arguments[0].click();", framesSubMenu);

        //ne mutam pe un Iframe
        driver.switchTo().frame("frame1");

        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");


        WebElement secondsampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondsampleTextElement.getText());

        //tema - nested frames


    }
}