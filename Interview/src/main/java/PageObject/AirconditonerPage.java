package PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class AirconditonerPage {
    WebDriver driver=null;
    public AirconditonerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[text()='MarQ by Flipkart 2024 Range 1 Ton 3 Star Split Inverter 4-in-1 Convertible with Turbo Cool Technology']")
    WebElement mrqConditioner;

    @FindBy(id = "pincodeInputId")
    public WebElement pincode;
    @FindBy(xpath = "//span[text()='Check']")
    public WebElement checkbutton;
    @FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
    public WebElement buyNowButton;
    @FindBy(xpath = "//span[text()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//button[@class=\"_1MM7ZD\"]")
    public WebElement editButton;

    @FindBy(xpath = "//button[@class=\"_2KpZ6l _3JSQZW _3dESVI\"]")
    public WebElement location;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "phone")
    public WebElement phoneNo;

    @FindBy(name = "pincode")
    public WebElement pincodeno;

    @FindBy(name = "addressLine2")
    public WebElement addressLines2;

    @FindBy(name = "addressLine1")
    public WebElement addressLines1;

    @FindBy(name = "city")
    public WebElement cityName;

    @FindBy(name = "state")
    public WebElement state;

    @FindBy(xpath = "//span[text()='Home (All day delivery)']")
    public WebElement radioButton;

    @FindBy(xpath = "//button[text()='Save and Deliver Here']")
    public WebElement saveAndDeliverHere;

    @FindBy(id = "to-payment")
    public WebElement continueButton;


    public void validateSamungFrige() {

        Assert.assertEquals(mrqConditioner, "SAMSUNG 189 L Direct Cool Single Door 5 Star Refrigerator");
        mrqConditioner.click();

        Assert.assertEquals(pincode, "Enter Delivery Pincode");
        pincode.sendKeys("560064");

        checkbutton.click();

        Set<String> handle = driver.getWindowHandles();
        for (String handles : handle) {
            driver.switchTo().window(handles);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
        }
    }

    public void setAddToCartButton() {
        Assert.assertEquals(addToCartButton, "Add to cart");
        addToCartButton.click();

    }

    public void setBuyNowButton() {
        Assert.assertEquals(buyNowButton, "Buy Now");
        buyNowButton.click();

        Set<String> handle = driver.getWindowHandles();
        for (String handles : handle) {
            driver.switchTo().window(handles);
        }
    }


    public void setPlaceOrderButton() {
        Assert.assertEquals(placeOrderButton, "Place Order");
        placeOrderButton.click();
    }

    public void Setaddress() {

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        editButton.click();
        location.click();
        name.sendKeys("samruddhi suryawanshi");
        phoneNo.sendKeys("7522968281");
        pincode.sendKeys("416404");
        addressLines2.sendKeys("amika nagar jath");
        addressLines1.sendKeys("hanuman niwas athani road jath");
        cityName.sendKeys("jath");

        Select stateName = new Select(state);
        stateName.selectByVisibleText("Maharashtra");
        radioButton.click();
        saveAndDeliverHere.click();
        continueButton.click();
        alert.getText();
        alert.accept();

    }


}
