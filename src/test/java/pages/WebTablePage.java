package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablePage extends BasePage{
    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    private List<WebElement> tableContentList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement userEmailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryLabelElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    private List<WebElement> newtableContentList;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editfirstNameElement;
    @FindBy(id = "lastName")
    private WebElement editlastNameElement;
    @FindBy(id = "userEmail")
    private WebElement edituserEmailElement;
    @FindBy(id = "age")
    private WebElement editageElement;
    @FindBy(id = "salary")
    private WebElement editsalaryLabelElement;
    @FindBy(id = "department")
    private WebElement editdepartmentElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;



    public void createProcess(String firstNameValue, String lastNameValue, String userEmailValue,
                              String ageValue, String salaryLabelValue, String departmentValue,
                              int tableSize){

        Assert.assertEquals(tableContentList.size(), tableSize, "Default size for table is not "+ tableSize);
        elementMethods.clickElement(addElement);
        elementMethods.fillElement(firstNameElement, firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(userEmailElement, userEmailValue);
        elementMethods.fillElement(ageElement, ageValue);
        elementMethods.fillElement(salaryLabelElement, salaryLabelValue);
        elementMethods.fillElement(departmentElement, departmentValue);
        elementMethods.clickElement(submitElement);
        Assert.assertEquals(newtableContentList.size(), tableSize+1, "Default size for table is not "+tableSize);

       String rowContent= newtableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row does not contain first name value ");
        Assert.assertTrue(rowContent.contains(lastNameValue), "The last row does not contain last name value ");
        Assert.assertTrue(rowContent.contains(userEmailValue), "The last row does not contain email value ");
        Assert.assertTrue(rowContent.contains(ageValue), "The last row does not contain age value ");
        Assert.assertTrue(rowContent.contains(salaryLabelValue), "The last row does not contain salary value ");
        Assert.assertTrue(rowContent.contains(departmentValue), "The last row does not contain department value ");
    }
    public void editProcess(String editfirstNameValue, String editlastNameValue, String edituserEmailValue,
                            String editageValue, String editsalaryLabelValue, String editdepartmentValue,
                            int tableSize){
        elementMethods.clickJSElement(editElement);
        elementMethods.clearEditElement(editfirstNameElement, editfirstNameValue);
        elementMethods.clearEditElement(editlastNameElement, editlastNameValue);
        elementMethods.clearEditElement(edituserEmailElement, edituserEmailValue);
        elementMethods.clearEditElement(editageElement, editageValue);
        elementMethods.clearEditElement(editsalaryLabelElement, editsalaryLabelValue);
        elementMethods.clearEditElement(editdepartmentElement, editdepartmentValue);
        elementMethods.clickElement(submitElement);

        elementMethods.waitVisibleList(newtableContentList);
        String rowContent= newtableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(editfirstNameValue), "The last row does not contain first name value ");
        Assert.assertTrue(rowContent.contains(editlastNameValue), "The last row does not contain last name value ");
        Assert.assertTrue(rowContent.contains(edituserEmailValue), "The last row does not contain email value ");
        Assert.assertTrue(rowContent.contains(editageValue), "The last row does not contain age value ");
        Assert.assertTrue(rowContent.contains(editsalaryLabelValue), "The last row does not contain salary value ");
        Assert.assertTrue(rowContent.contains(editdepartmentValue), "The last row does not contain department value ");
    }

    public void deleteProcess(int tableSize){
        elementMethods.clickJSElement(deleteElement);
        Assert.assertEquals(tableContentList.size(),tableSize , "Default size for table is not"+tableSize);
    }

}
