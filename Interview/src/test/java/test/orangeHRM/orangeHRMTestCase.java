package test.orangeHRM;

import PageObject.HRMHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class orangeHRMTestCase {
   WebDriver driver=new ChromeDriver();
   @Test(priority = 1)
   public void HRMHomepage(){
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.manage().window().maximize();
       Assert.assertEquals(driver.getTitle(),"OrangeHRM");
   }
   @Test(priority = 2)
    public void InvalidCrditentialLogin(){
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.InvalidLogin("xyz","sass");
   }
   @Test(priority = 3)
  public void ValidateloginPage(){
       HRMHomePage hrmHomePage=new HRMHomePage(driver);
       hrmHomePage.validateLoginName();
       hrmHomePage.login();
   }

@AfterClass
public void endProgram(){
    driver.quit();

}
}
