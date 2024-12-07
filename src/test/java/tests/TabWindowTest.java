package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.TabWindowPage;
import sharedData.SharedData;


public class TabWindowTest extends SharedData {

    @Test
    public void metodaTest () {


        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickBrowserwindowMenu();

        TabWindowPage tabWindowPage = new TabWindowPage(getDriver());
        tabWindowPage.dealTabProcess();
        tabWindowPage.dealWindowProcess();















    }
    }
