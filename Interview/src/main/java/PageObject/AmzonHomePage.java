package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AmzonHomePage {
    WebDriver driver = null;

    public AmzonHomePage(WebDriver driver) {
        this.driver = driver;

    }

    public String[] headers() {
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='nav-a-content']"));
        int number= list.size();
        String[] output=new String[number];
        for (int i = 0; i < number; i++) {
            output[i]=list.get(i).getText();
        }
        return output;
        }



    }

