package tests;

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

        WebElement alertframewindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertframewindowMenu);

        WebElement browserwindowMenu= driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        js.executeScript("arguments[0].click();", browserwindowMenu);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        js.executeScript("arguments[0].click();",newTabElement);

        System.out.println("URL-ul paginii curente este"+ driver.getCurrentUrl());

        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));

        System.out.println("URL-ul paginii curente este"+ driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(tabsList.get(0));

        System.out.println("URL-ul paginii curente este"+ driver.getCurrentUrl());

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        js.executeScript("arguments[0].click()",newWindowElement);

        System.out.println("URL-ul paginii curente este "+ driver.getCurrentUrl());

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        System.out.println("URL-ul paginii curente este "+ driver.getCurrentUrl());

        driver.close();

        driver.quit();















    }
    }
