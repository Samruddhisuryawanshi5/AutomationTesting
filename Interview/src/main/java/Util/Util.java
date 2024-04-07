package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Util {

    WebDriver driver=null;

    public Util(WebDriver driver) {this.driver=driver;}

    public void launchUrl(){
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void navigatetoLogout(){
        WebElement Account= driver.findElement(By.xpath("//span[text()='Login']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Account).click().build().perform();
    }
    public void clickOnbottomNavigation(String name){
        driver.findElement(By.xpath("//div[@class='_1ZMrY_']//a[text()='"+name+"']")).click();
    }
    public void clickOnbottomNavigation(String name,String index){
        driver.findElement(By.xpath("//div[@class='_1ZMrY_']//a[text()='"+name+"']")).click();
    }

    }


