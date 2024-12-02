package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class TabWindowTest {
    public WebDriver driver;

    @Test
    public void metodaTest () {

        driver = new EdgeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        TabMethods tabMethods = new TabMethods(driver);


        WebElement alertframewindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertframewindowMenu);

        WebElement browserwindowMenu= driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickJSElement(browserwindowMenu);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementMethods.clickJSElement(newTabElement);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementMethods.clickJSElement(newWindowElement);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        driver.quit();















    }
    }
