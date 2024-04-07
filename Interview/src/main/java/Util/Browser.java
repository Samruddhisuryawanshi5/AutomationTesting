package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public WebDriver driver= null;
    public void setUp(String browsername){
        WebDriver driver =null;
        if ("chrome".equalsIgnoreCase(browsername)){
            driver=new ChromeDriver();
        }

    }

}
