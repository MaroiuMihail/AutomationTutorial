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

import java.sql.BatchUpdateException;
import java.util.List;
import java.util.TreeSet;

public class WebTabelTest {
    public WebDriver driver;

    @Test
    public void metodaTest () {

        //deschidem un browser
        driver=new EdgeDriver();
        //accesam un URL
        driver.get("https://demoqa.com/");
        //facem browserul maximize
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsMenu();

        ElementPage elementPage = new ElementPage(driver);
        elementPage.clickWebTable();

        String firstNameValue = "Maroiu";
        String lastNameValue = "Mihail";
        String userEmailValue = "mihai.maroiu88@gmail.com";
        String ageValue = "23";
        String salaryLabelValue = "3000";
        String departmentValue = "Test";

        WebTablePage webTablePage = new WebTablePage(driver);
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

        driver.quit();
    }
}
