package tests;

import org.testng.annotations.Test;
import pages.ElementPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

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
