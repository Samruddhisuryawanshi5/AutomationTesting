package test.orangeHRM;

import PageObject.HRMAdminPage;
import PageObject.HRMHomePage;
import PageObject.Login;
import Util.ReadingExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TestDataDriven {
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
    public void Admin(HashMap<String,String> map) throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Login login=new Login(driver);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login.loginPge(map.get("Username"),map.get("Password"));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
