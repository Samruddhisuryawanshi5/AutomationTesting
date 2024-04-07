package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HRMHomePage {
    WebDriver driver = null;

    public HRMHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p[text()='Forgot your password? ']")
    public WebElement forgotPassword;
    @FindBy(xpath = "//button[text()=' Reset Password ']")
    public WebElement restButton;
    @FindBy(xpath = "//h5[text()='Login']")
    public WebElement iconName;
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[text()=' Login ']")
    public WebElement loginButton;

    public void fogotPassword(){
        forgotPassword.click();
        username.sendKeys("Admin");
        restButton.click();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    public void InvalidLogin(String Username,String Password){
        username.sendKeys(Username);
        password.sendKeys(Password);
        loginButton.click();

    }
    public void login(){
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();

    }
    public void login(String Username,String Password){
        username.sendKeys(Username);
        password.sendKeys(Password);
        loginButton.click();

    }
    public void validateLoginName(){
        Assert.assertEquals(iconName.getText(),"Login");
        Assert.assertEquals(loginButton.getText(),"Login");

    }




    }






