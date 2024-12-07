package tests;

import helpMethods.AlertMethods;
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
import pages.ElementPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

import java.sql.BatchUpdateException;
import java.util.List;
import java.util.TreeSet;

public class WebTabelTest extends SharedData {

    @Test
    public void metodaTest () {


        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsMenu();

        ElementPage elementPage = new ElementPage(getDriver());
        elementPage.clickWebTable();

        String firstNameValue = "Maroiu";
        String lastNameValue = "Mihail";
        String userEmailValue = "mihai.maroiu88@gmail.com";
        String ageValue = "23";
        String salaryLabelValue = "3000";
        String departmentValue = "Test";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.createProcess(firstNameValue, lastNameValue, userEmailValue, ageValue,
                salaryLabelValue, departmentValue,3);


        String editfirstNameValue = "Costin";
        String editlastNameValue = "Stefan";
        String edituserEmailValue = "costin.stefan@gmail.com";
        String editageValue = "28";
        String editsalaryLabelValue = "4000";
        String editdepartmentValue = "IT";

        webTablePage.editProcess(editfirstNameValue, editlastNameValue, edituserEmailValue, editageValue,
                editsalaryLabelValue, editdepartmentValue, 3);

        webTablePage.deleteProcess(3);

        getDriver().quit();
    }
}
