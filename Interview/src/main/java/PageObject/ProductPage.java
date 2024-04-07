package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {

    WebDriver driver = null;

    public ProductPage(WebDriver driver) {
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
    @FindBy(xpath = "//div[@id='shopping_cart_container']//child::a//span")
    public WebElement addToCartIcon;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement add2ToCart;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeProduct;



    public void loginPge(String username, String Password) {
        try {
            loginId.sendKeys(username);
        } catch (Exception e) {
            loginId.sendKeys("problem_user");
        }

        password.sendKeys(Password);
        loginButton.click();
    }

    public void ValidateProductDescription(){
        String description=driver.findElement(By.xpath("//a[@id='item_4_title_link']//following-sibling::div")).getText();
        Assert.assertEquals(description,"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
    }

    public void ValidatePrice(){
        String price=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']//preceding-sibling::div")).getText();
        Assert.assertEquals(price,"$29.99");

    }

    public void ValidateAddToCart(){
        Assert.assertEquals(addToCart.getText(),"Add to cart");
        addToCart.click();
    }

    public void addToCartIcon(String number){
        Assert.assertEquals(addToCartIcon.getText(),number);

    }
    public void setRemoveProduct(){
        removeProduct.click();
    }
    public void setAdd2ToCart(){
        add2ToCart.click();
    }

}
