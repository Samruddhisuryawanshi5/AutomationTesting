package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCartPage {
    WebDriver driver = null;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCart;
    @FindBy(xpath = "//div[@id='shopping_cart_container']//child::a")
    public WebElement addToCartIcon;
    @FindBy(id = "continue-shopping")
    public WebElement continueShopping;
    @FindBy(id = "checkout")
    public WebElement checkout;

    public void addToCartIcon(){
        addToCart.click();
        addToCartIcon.click();
    }
    public void nameOfProduct(){
        String name=driver.findElement(By.id("item_4_title_link")).getText();
        Assert.assertEquals(name,"Sauce Labs Backpack");
    }
    public void detailsOfProduct(){
        String deatil=driver.findElement(By.xpath("//a[@id='item_4_title_link']//following-sibling::div[@class='inventory_item_desc']")).getText();
        Assert.assertEquals(deatil,"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
    }
    public void priceOfProduct(String price){
        String productPrice=driver.findElement(By.xpath("//a[@id='item_4_title_link']//following-sibling::div[@class='item_pricebar']//div")).getText();
        Assert.assertEquals(productPrice,price);
    }
    public void setContinueShopping(){
        Assert.assertEquals(continueShopping.isDisplayed(),Boolean.TRUE);
    }
    public void setCheckout(){
        Assert.assertEquals(checkout.isDisplayed(),true);
    }


}
