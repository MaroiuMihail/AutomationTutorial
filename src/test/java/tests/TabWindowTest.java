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
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.TabWindowPage;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;


public class TabWindowTest extends SharedData {

    @Test
    public void metodaTest () {


        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.clickBrowserwindowMenu();

        TabWindowPage tabWindowPage = new TabWindowPage(driver);
        tabWindowPage.dealTabProcess();
        tabWindowPage.dealWindowProcess();















    }
    }
