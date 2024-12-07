package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.HomePage;
import sharedData.SharedData;

public class AlertsTest extends SharedData {

    @Test
    public void metodaTest () {


        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickAlert();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertProcess("This is a test");
    }
}
