package test.sauceLabs;

import PageObject.AddToCartPage;
import PageObject.Login;
import Util.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class addToCartTestCase extends Browser {
   // WebDriver driver=null;
   @BeforeClass()
   public void startup(){
       setUp("chrome");
    }
    @Test(priority = 1)
    public void valiadteSauceLabsLoaginPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Login login = new Login(driver);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login.loginPge("standard_user", "secret_sauce");
        AddToCartPage addToCartPage=new AddToCartPage(driver);
        addToCartPage.addToCartIcon();
    }
    @Test(priority = 2)
    public void ValidateNameOfProduct() {
        AddToCartPage addToCartPage=new AddToCartPage(driver);
        addToCartPage.nameOfProduct();
    }
    @Test(priority = 3)
    public void ValidateDetailsOfProduct() {
        AddToCartPage addToCartPage=new AddToCartPage(driver);
        addToCartPage.detailsOfProduct();
    }
    @Test(priority = 4)
    public void ValidatePriceOfProduct() {
        AddToCartPage addToCartPage=new AddToCartPage(driver);
        addToCartPage.priceOfProduct("$29.99");
    }
    @Test(priority = 5)
    public void ValidateContinueShopping() {
        AddToCartPage addToCartPage=new AddToCartPage(driver);
        addToCartPage.setContinueShopping();
    }
    @Test(priority = 6)
    public void ValidateCheckout() {
        AddToCartPage addToCartPage=new AddToCartPage(driver);
        addToCartPage.setCheckout();
    }


    @AfterClass()
    public void endclass()
    {
        driver.quit();
    }
}
