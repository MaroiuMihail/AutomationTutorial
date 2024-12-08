package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void metodaTest () {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeFormSubMenu();

        String firstNameValue = "Maroiu";
        String lastNameValue = "Mihai";
        String userEmailValue = "mihai.maroiu88@gmail.com";
        String genderValue = "Male";
        String mobilenumberValue = "0749234804";
        String monthValue = "January";
        String yearValue = "2030";
        String dayValue = "15";
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "English");
        List<String> hobbiesValue = Arrays.asList("Sports", "Music");
        String pathFile = "src/test/resources/New Text Document.txt";
        String currentAddressValue = "Str.Dada";
        String stateInputValue = "NCR";
        String cityInputValue = "Delhi";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, userEmailValue,genderValue, mobilenumberValue,
                monthValue, yearValue, dayValue, subjectValues, hobbiesValue, pathFile, currentAddressValue,
                stateInputValue, cityInputValue);

        practiceFormPage.validateFormValues(firstNameValue, lastNameValue, userEmailValue, genderValue, mobilenumberValue,
                subjectValues, hobbiesValue, pathFile, currentAddressValue, stateInputValue, cityInputValue);
    }
}
