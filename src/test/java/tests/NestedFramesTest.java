package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.NestedFramesPage;
import sharedData.SharedData;

public class NestedFramesTest extends SharedData {


    @Test
    public void metodaTest(){


        ElementMethods elementMethods = new ElementMethods(getDriver());
        FrameMethods frameMethods = new FrameMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickNestedFramesSubMenu();

        NestedFramesPage nestedFramesPage = new NestedFramesPage(getDriver());
        nestedFramesPage.dealNestedFrames();
    }
}
