package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void metodaTest () {

        //deschidem un browser
        driver =new EdgeDriver();
        //accesam un URL
        driver.get("https://demoqa.com/");
        //facem browserul maximize
        driver.manage().window().maximize();


        WebElement formsMenu= driver.findElement(By.xpath("//h5[text()='Forms']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", formsMenu);

        WebElement practiceFormSubMenu= driver.findElement(By.xpath("//span[text()='Practice Form']"));
        js.executeScript("arguments[0].click();", practiceFormSubMenu);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Maroiu";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Mihai";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "mihai.maroiu88@gmail.com";
        userEmailElement.sendKeys(userEmailValue);

        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']"));
        String genderValue = "Male";
        switch (genderValue){
            case "Male":
                js.executeScript("arguments[0].click();", genderOptionsList.get(0));
                break;
            case "Femmale":
                js.executeScript("arguments[0].click();", genderOptionsList.get(1));
                break;
            case "Other":
                js.executeScript("arguments[0].click();", genderOptionsList.get(2));
                break;
        }

        WebElement mobileNumberElement = driver.findElement(By.id("userNumber"));
        String mobilenumberValue = "0749234804";
        mobileNumberElement.sendKeys(mobilenumberValue);

        //date of birth interaction
        WebElement dateofBirthElement = driver.findElement(By.id("dateOfBirthInput"));
        dateofBirthElement.click();

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect = new Select(monthElement);
        String monthValue = "January";
        monthSelect.selectByVisibleText(monthValue);

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearElement);
        String yearValue = "2030";
        yearSelect.selectByVisibleText(yearValue);

        String dayValue = "15";
        List<WebElement> dayslist = driver.findElements(By.xpath("//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]"));
        for (int index = 0; index < dayslist.size();index++){
            if (dayslist.get(index).getText().equals(dayValue)){
                dayslist.get(index).click();
                break;
            }
        }




//        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
//        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "English");
//        for (int index = 0; index < subjectValues.size();index++) {
//            subjectElement.sendKeys(subjectValues.get(index));
//            subjectElement.sendKeys(Keys.ENTER);
//        }
//
//        List<String> hobbiesValue = Arrays.asList("Sports", "Music");
//        List<WebElement> hobbiesOptionsList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']"));
//        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
//            String currentText = hobbiesOptionsList.get(index).getText();
//            if (hobbiesValue.contains(currentText)) {
//                js.executeScript("arguments[0].click()", hobbiesOptionsList.get(index));
//            }
//        }
//
//        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
//        File file = new File("src/test/resources/New Text Document.txt");
//        pictureElement.sendKeys(file.getAbsolutePath());
//
//        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
//        String currentAddressValue = "Str.Dada";
//        currentAddressElement.sendKeys(currentAddressValue);
//
//        WebElement stateElement = driver.findElement(By.xpath("//div[text()= 'Select State']"));
//        js.executeScript("arguments[0].click();", stateElement);
//
//        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
//        String stateValue = "NCR";
//        stateInputElement.sendKeys(stateValue);
//        stateInputElement.sendKeys(Keys.ENTER);
//
//        WebElement cityElement = driver.findElement(By.xpath("//div[text()= 'Select City']"));
//        js.executeScript("arguments[0].click();", cityElement);
//
//        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
//        String cityValue = "Delhi";
//        cityInputElement.sendKeys(cityValue);
//        cityInputElement.sendKeys(Keys.ENTER);
//
//        WebElement submitElement = driver.findElement(By.id("submit"));
//        js.executeScript("arguments[0].click();", submitElement);
//
//        //Validam datele introduse
//
//        WebElement thankYouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
//        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");
//
//        List<WebElement> lableList = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]"));
//        List<WebElement> valueList = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]"));
//
//        Assert.assertEquals(lableList.get(0).getText(), "Student Name");
//        Assert.assertEquals(lableList.get(1).getText(), "Student Email");
//        Assert.assertEquals(lableList.get(2).getText(), "Gender");
//        Assert.assertEquals(lableList.get(3).getText(), "Mobile");
//        Assert.assertEquals(lableList.get(4).getText(), "Date of Birth");
//        Assert.assertEquals(lableList.get(5).getText(), "Subjects");
//        Assert.assertEquals(lableList.get(6).getText(), "Hobbies");
//        Assert.assertEquals(lableList.get(7).getText(), "Picture");
//        Assert.assertEquals(lableList.get(8).getText(), "Address");
//        Assert.assertEquals(lableList.get(9).getText(), "State and City");
//
//        Assert.assertEquals(valueList.get(0).getText(), firstNameValue+" "+lastNameValue);
//        Assert.assertEquals(valueList.get(1).getText(),userEmailValue);
//        Assert.assertEquals(valueList.get(2).getText(),genderValue);
//        Assert.assertEquals(valueList.get(3).getText(),mobilenumberValue);
//        Assert.assertEquals(valueList.get(5).getText(),subjectValues);
//        Assert.assertEquals(valueList.get(6).getText(),hobbiesValue);
//        Assert.assertEquals(valueList.get(7).getText(),pictureElement);
//        Assert.assertEquals(valueList.get(8).getText(),currentAddressValue);
//        Assert.assertEquals(valueList.get(9).getText(),stateValue+" "+cityValue);

    }
}
