package test.form;

import PageObject.Login;
import Util.ReadingExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class FormDemoQA {
    WebDriver driver = new ChromeDriver();

    @DataProvider(name = "dp")
    public Object[][] getData() throws IOException {
        ReadingExcel readingExcel = new ReadingExcel();
        List<HashMap<String, String>> testDataList = readingExcel.readExcel(this.getClass().getSimpleName());

        // Convert the list of HashMaps to a 2D Object array
        Object[][] testDataArray = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            HashMap<String, String> map = testDataList.get(i);
            testDataArray[i][0] = map;
        }
        return testDataArray;
    }

    @Test(priority = 1, dataProvider = "dp")
    public void Admin(HashMap<String,String> excel) throws IOException {
       driver.get("https://demoqa.com/automation-practice-form");
       driver.manage().window().maximize();
        driver.findElement(By.id("firstName")).sendKeys(excel.get("firstname"));
        driver.findElement(By.id("lastName")).sendKeys(excel.get("lastName"));
        driver.findElement(By.id("userEmail")).sendKeys(excel.get("userEmail"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        driver.findElement(By.xpath("//input[@name='gender' and @value='"+excel.get("gender")+"']//following-sibling::label")).click();
        driver.findElement(By.id("userNumber")).sendKeys(excel.get("userNumber"));
         /*driver.findElement(By.id("dateOfBirthInput")).click();
         Select select=new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
        select.selectByVisibleText(excel.get("date"));*/
        driver.findElement(By.id("subjectsInput")).sendKeys(excel.get("Subjects"));


        driver.findElement(By.xpath("//input[@type='checkbox' and @value='"+ excel.get("Hobbies")+"']//following-sibling::label")).click();
        driver.findElement(By.id("uploadPicture")).sendKeys(excel.get("Picture"));

        String name=driver.findElement(By.id("firstName")).getText();
        Assert.assertEquals(name,excel.get("firstName"));
        String subject=driver.findElement(By.id("subjectsInput")).getText();
        Assert.assertEquals(subject,excel.get("subject"));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
