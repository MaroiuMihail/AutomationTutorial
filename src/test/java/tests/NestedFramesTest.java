package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFramesTest {

    public WebDriver driver;

    @Test
    public void metodaTest(){

        //deschidem un browser
        driver = new EdgeDriver();
        //accesam un URL
        driver.get("https://demoqa.com/");
        //facem browserul maximize
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        WebElement alertFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertFrameWindowsMenu);

        WebElement nestedFramesSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        elementMethods.clickJSElement(nestedFramesSubMenu);

        frameMethods.switchToSpecificIframe("frame1");

        WebElement childFrameElement = driver.findElement(By.tagName("iframe"));
        frameMethods.switchToSpecificIframeByElement(childFrameElement);

        WebElement childSampleTextElement = driver.findElement(By.tagName("p"));
        System.out.println(childSampleTextElement.getText());

    }
}
