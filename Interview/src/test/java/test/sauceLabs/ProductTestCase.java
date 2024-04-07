package test.sauceLabs;

import PageObject.Login;
import PageObject.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTestCase {
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
        login.loginPge("standard_user","secret_sauce");

    }
    @Test(priority = 2)
    public void ValidateProductDescription(){
        ProductPage productPage=new ProductPage(driver);
        productPage.ValidateProductDescription();
    }
    @Test(priority = 3)
    public void ValidatePrice(){
        ProductPage productPage=new ProductPage(driver);
        productPage.ValidatePrice();
    }
    @Test(priority = 4)
    public void ValidateAddToCart(){
        ProductPage productPage=new ProductPage(driver);
        productPage.ValidateAddToCart();

    }
    @Test(priority = 5)
    public void addToCartIcon() {
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCartIcon("1");
    }
    @Test(priority = 6)
    public void addToCart2Product() {
        ProductPage productPage = new ProductPage(driver);
        productPage.setAdd2ToCart();
        productPage.addToCartIcon("2");
    }
    @Test(priority = 7)
    public void ValidateremoveProduct() {
        ProductPage productPage = new ProductPage(driver);
        productPage.setRemoveProduct();
        productPage.addToCartIcon("1");
    }






    @AfterClass
    public void closeBroweser(){
        driver.quit();
    }
}
