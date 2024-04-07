package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMAdminPage {
    WebDriver driver = null;

    public HRMAdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement adminMenu;


    public void AdminMenu(){
        adminMenu.click();
    }
}
