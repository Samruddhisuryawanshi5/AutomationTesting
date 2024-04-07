package test.sauceLabs;

import PageObject.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginTestCase {

    WebDriver driver=null;
    @BeforeClass()
    public void startup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver=new ChromeDriver(options);
    }

    @Test(priority = 1)
    public void valiadteSauceLabsLoaginPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Login login=new Login(driver);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login.valiadteLoginPage();
    }
    @Test(priority = 2)
    public void validateInvalideUser(){
        Login login=new Login(driver);
        login.loginPge("hdhdh","djdj");
        login.wrongErrorMessgae();

    }
    @Test(priority = 3)
    public void ValidateCorrectUserNamePassword(){
        Login login=new Login(driver);
        driver.navigate().refresh();
        login.loginPge("standard_user","secret_sauce");
        login.valiadteHomePageUrl();

    }

    @Test(priority = 4)
    public void ValidateAddToCart(){
        Login login=new Login(driver);
        login.setAddToCart();

    }
    @Test(priority = 5)
    public void ValidateProductPage(){
        Login login=new Login(driver);
        login.valiadteProduct();


    }



    @AfterClass
    public void closeBroweser(){
        driver.quit();
    }
}
