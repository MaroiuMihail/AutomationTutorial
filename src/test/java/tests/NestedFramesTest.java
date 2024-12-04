package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import sharedData.SharedData;

import java.time.Duration;

public class NestedFramesTest extends SharedData {


    @Test
    public void metodaTest(){


        ElementMethods elementMethods = new ElementMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        WebElement nestedFramesSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJSElement(nestedFramesSubMenu);

        frameMethods.switchToSpecificIframe("frame1");

        WebElement childFrameElement = driver.findElement(By.tagName("iframe"));
        frameMethods.switchToSpecificIframeByElement(childFrameElement);

        WebElement childSampleTextElement = driver.findElement(By.tagName("p"));
        System.out.println(childSampleTextElement.getText());

    }
}
