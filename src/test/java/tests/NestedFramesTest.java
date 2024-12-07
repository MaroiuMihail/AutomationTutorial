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


        ElementMethods elementMethods = new ElementMethods(getDriver());
        FrameMethods frameMethods = new FrameMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        WebElement nestedFramesSubMenu = getDriver().findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJSElement(nestedFramesSubMenu);

        frameMethods.switchToSpecificIframe("frame1");

        WebElement childFrameElement = getDriver().findElement(By.tagName("iframe"));
        frameMethods.switchToSpecificIframeByElement(childFrameElement);

        WebElement childSampleTextElement = getDriver().findElement(By.tagName("p"));
        System.out.println(childSampleTextElement.getText());

    }
}
