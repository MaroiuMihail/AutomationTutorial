package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        ElementMethods elementMethods = new ElementMethods(driver);

        WebElement elementsMenu= driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementMethods.clickJSElement(elementsMenu);

        WebElement webTableSubMenu= driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethods.clickJSElement(webTableSubMenu);

        //validam dimensiunea initiala a tabelului

        List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3, "Default size for table is not 3");

        //definim un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Maroiu";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Mihail";
        lastNameElement.sendKeys((lastNameValue));

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "mihai.maroiu88@gmail.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "23";
        ageElement.sendKeys(ageValue);

        WebElement salaryLabelElement = driver.findElement(By.id("salary"));
        String salaryLabelValue = "3000";
        salaryLabelElement.sendKeys(salaryLabelValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "Test";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

        //validam noua dimeniune a tabelului
        List<WebElement> newtableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(newtableContentList.size(), 4, "Default size for table is not 4");

        //validam valorile pe care le-am introdus
        String rowContent= newtableContentList.get(3).getText();
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row does not contain first name value ");
        Assert.assertTrue(rowContent.contains(lastNameValue), "The last row does not contain last name value ");
        Assert.assertTrue(rowContent.contains(userEmailValue), "The last row does not contain email value ");
        Assert.assertTrue(rowContent.contains(ageValue), "The last row does not contain age value ");
        Assert.assertTrue(rowContent.contains(salaryLabelValue), "The last row does not contain salary value ");
        Assert.assertTrue(rowContent.contains(departmentValue), "The last row does not contain department value ");


        //edit functionality

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementMethods.clickJSElement(editElement);

        WebElement editfirstNameElement = driver.findElement(By.id("firstName"));
        String editfirstNameValue = "Costin";
        editfirstNameElement.clear();
        editfirstNameElement.sendKeys(editfirstNameValue);

        WebElement editlastNameElement = driver.findElement(By.id("lastName"));
        String editlastNameValue = "Stefan";
        editlastNameElement.clear();
        editlastNameElement.sendKeys((editlastNameValue));

        WebElement edituserEmailElement = driver.findElement(By.id("userEmail"));
        String edituserEmailValue = "costin.stefan@gmail.com";
        edituserEmailElement.clear();
        edituserEmailElement.sendKeys(edituserEmailValue);

        WebElement editageElement = driver.findElement(By.id("age"));
        String editageValue = "28";
        editageElement.clear();
        editageElement.sendKeys(editageValue);

        WebElement editsalaryLabelElement = driver.findElement(By.id("salary"));
        String editsalaryLabelValue = "4000";
        editsalaryLabelElement.clear();
        editsalaryLabelElement.sendKeys(editsalaryLabelValue);

        WebElement editdepartmentElement = driver.findElement(By.id("department"));
        String editdepartmentValue = "IT";
        editdepartmentElement.clear();
        editdepartmentElement.sendKeys(editdepartmentValue);

        WebElement editsubmitElement = driver.findElement(By.id("submit"));
        editsubmitElement.click();

        //validam valorile modificate din tabel
        rowContent= newtableContentList.get(3).getText();
        Assert.assertTrue(rowContent.contains(editfirstNameValue), "The last row does not contain first name value ");
        Assert.assertTrue(rowContent.contains(editlastNameValue), "The last row does not contain last name value ");
        Assert.assertTrue(rowContent.contains(edituserEmailValue), "The last row does not contain email value ");
        Assert.assertTrue(rowContent.contains(editageValue), "The last row does not contain age value ");
        Assert.assertTrue(rowContent.contains(editsalaryLabelValue), "The last row does not contain salary value ");
        Assert.assertTrue(rowContent.contains(editdepartmentValue), "The last row does not contain department value ");


        //Xpath se foloseste doar pentru text
        //Xpath absolut niciodata - daca incepe cu slash
        //Xpath relativ mereu - cu 2 slash-uri

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementMethods.clickJSElement(deleteElement);

        newtableContentList= driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3, "Default size for table is not 3");














    }
}
