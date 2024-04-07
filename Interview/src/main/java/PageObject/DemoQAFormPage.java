package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DemoQAFormPage {
    WebDriver driver = null;

    public DemoQAFormPage(WebDriver driver) {
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


    }



