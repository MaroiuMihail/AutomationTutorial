package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceFormSubMenu;
    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement userEmailElement;
    @FindBy(xpath = "//input[@name='gender']/../label")
    public List<WebElement> genderOptionsList;
    @FindBy(id = "userNumber")
    public WebElement mobileNumberElement;
    @FindBy(id = "dateOfBirthInput")
    public WebElement dateofBirthElement;
    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthElement;
    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearElement;
    @FindBy(xpath = "//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]")
    public List<WebElement> dayslist;
    @FindBy(id = "subjectsInput")
    public WebElement subjectElement;
    @FindBy(className = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    public List<WebElement> hobbiesOptionsList;
    @FindBy(id = "uploadPicture")
    public WebElement pictureElement;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressElement;
    @FindBy(xpath = "//div[text()='Select State']")
    public WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    public WebElement stateInputElement;
    @FindBy(xpath = "//div[text()='Select City']")
    public WebElement cityElement;
    @FindBy(id = "react-select-4-input")
    public WebElement cityInputElement;
    @FindBy(id = "submit")
    public WebElement submitElement;
    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement thankYouElement;
    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]")
    public List<WebElement> lableList;
    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]")
    public List<WebElement> valueList;


    public void fillEntireForm(String firstNameValue, String lastNameValue, String userEmailValue,String genderValue,
                               String mobilenumberValue, String monthValue, String yearValue, String dayValue,
                               List<String> subjectValues, List<String> hobbiesValue, String pathFile,
                               String currentAddressValue, String stateInputValue,String cityInputValue){

        elementMethods.fillElement(firstNameElement, firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(userEmailElement, userEmailValue);
        switch (genderValue){
            case "Male":
                elementMethods.clickJSElement(genderOptionsList.get(0));
                break;
            case "Female":
                elementMethods.clickJSElement(genderOptionsList.get(1));
                break;
            case "Other":
                elementMethods.clickJSElement(genderOptionsList.get(2));
                break;
        }
        elementMethods.fillElement(mobileNumberElement, mobilenumberValue);
        elementMethods.clickJSElement(dateofBirthElement);
        elementMethods.selectDropdownElement(monthElement, monthValue);
        elementMethods.selectDropdownElement(yearElement, yearValue);

        for (int index = 0; index < dayslist.size();index++){
            if (dayslist.get(index).getText().equals(dayValue)){
                elementMethods.clickJSElement(dayslist.get(index));
                break;
            }
        }

        for (int index = 0; index < subjectValues.size();index++) {
            elementMethods.fillPressElement(subjectElement, subjectValues.get(index), Keys.ENTER);
        }

        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValue.contains(currentText)) {
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));
            }
        }

        File file = new File(pathFile);
        elementMethods.fillElement(pictureElement, file.getAbsolutePath());

        elementMethods.fillElement(currentAddressElement, currentAddressValue);
        elementMethods.clickJSElement(stateElement);

        elementMethods.fillPressElement(stateInputElement, stateInputValue, Keys.ENTER);
        elementMethods.clickJSElement(cityElement);

        elementMethods.fillPressElement(cityInputElement, cityInputValue, Keys.ENTER);

        elementMethods.clickJSElement(submitElement);
    }

    public void validateFormValues(String firstNameValue, String lastNameValue,String userEmailValue, String genderValue,
                                   String mobilenumberValue,List<String> subjectValues, List<String> hobbiesValue,
                                   String pathFile, String currentAddressValue, String stateInputElement, String cityInputValue){

        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");

        Assert.assertEquals(lableList.get(0).getText(), "Student Name");
        Assert.assertEquals(lableList.get(1).getText(), "Student Email");
        Assert.assertEquals(lableList.get(2).getText(), "Gender");
        Assert.assertEquals(lableList.get(3).getText(), "Mobile");
        Assert.assertEquals(lableList.get(4).getText(), "Date of Birth");
        Assert.assertEquals(lableList.get(5).getText(), "Subjects");
        Assert.assertEquals(lableList.get(6).getText(), "Hobbies");
        Assert.assertEquals(lableList.get(7).getText(), "Picture");
        Assert.assertEquals(lableList.get(8).getText(), "Address");
        Assert.assertEquals(lableList.get(9).getText(), "State and City");

        Assert.assertEquals(valueList.get(0).getText(), firstNameValue+" "+lastNameValue);
        Assert.assertEquals(valueList.get(1).getText(),userEmailValue);
        Assert.assertEquals(valueList.get(2).getText(),genderValue);
        Assert.assertEquals(valueList.get(3).getText(),mobilenumberValue);
        Assert.assertEquals(valueList.get(5).getText(),subjectValues);
        Assert.assertEquals(valueList.get(6).getText(),hobbiesValue);

        File file = new File(pathFile);
        Assert.assertEquals(valueList.get(7).getText(),pictureElement);
        Assert.assertEquals(valueList.get(8).getText(),currentAddressValue);
        Assert.assertEquals(valueList.get(9).getText(),stateInputElement+" "+cityInputValue);
    }

}
