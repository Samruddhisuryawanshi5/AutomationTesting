package test.orangeHRM;

import PageObject.HRMAdminPage;
import PageObject.HRMHomePage;
import Util.ReadingExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class adminTestCase {
    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    public void Admin() throws IOException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.login();
        HRMAdminPage hrmAdminPage=new HRMAdminPage(driver);
        hrmAdminPage.AdminMenu();

        String Username;

    }
}
