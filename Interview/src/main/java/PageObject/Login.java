package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Login {
    WebDriver driver = null;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement loginId;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCart;



    public void loginPge(String username, String Password) {
        try {
            loginId.sendKeys(username);
        } catch (Exception e) {
            loginId.sendKeys("problem_user");
        }

        password.sendKeys(Password);
        loginButton.click();
    }

    public void setAddToCart() {
        addToCart.click();
    }

    public void valiadteLoginPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        String title = driver.findElement(By.xpath("//div[text()=\"Swag Labs\"]")).getText();
        Assert.assertEquals(title, "Swag Labs");

    }

    public void wrongErrorMessgae() {
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");

    }

    public void valiadteHomePageUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        String title = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(title, "Swag Labs");

    }

    public void valiadteProduct(){
       String productName= driver.findElement(By.id("item_4_title_link")).getText();
       Assert.assertEquals(productName,"Sauce Labs Backpack");
        List<WebElement> list= driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Assert.assertEquals(list.size(),6,"product Size assertion is passed");


    }



    }



