package test;

import PageObject.AmzonHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class amazon {
    WebDriver driver=null;
    @BeforeClass
    public void browser(){
        driver=new ChromeDriver();
    }
    @Test()
    public void test(){
        driver.get("https://www.amazon.in/Redmi-12-5G-Moonstone-Silver/dp/B0C9J97Z2D/ref=sr_1_1_sspa?crid=24PSQ3N805OMB&dib=eyJ2IjoiMSJ9.B8bejg4OzHsCPwHFtcUW03-6if2sk9CpQgpKqnTdQCJFz5AtscBjUYgMtA0nyN5HNKM0fCisMN402Kkcau3Z6fqlklgrvuwTE5i1N5pRmJLQQxRCofBaJEcLuekW2GOLD0Dsn-_rCSvyCF3OIIEzvAYRFWT46q7aFKZIpAGzPNVVfh9FxDQvRq9ILxw7zSOhwhhjUyA1QyNSbTdymDoVAzZdKRYEhPyVU8KCraprnsU.XFiPXp4iXIoirFGak7AqPmGzECHsQc8wDGX9JAsliRY&dib_tag=se&keywords=mobile&qid=1712423976&sprefix=%2Caps%2C221&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
        driver.manage().window().maximize();
        AmzonHomePage amzonHomePage = new AmzonHomePage(driver);
        String[] store=amzonHomePage.headers();
        Assert.assertEquals(store[0],"Electronics");
        Assert.assertEquals(store[1],"Mobile");

        //save in something =amzonHomePage.headers();
        //something[0]=Electronics
        //something[1]=Mobiles
    }
}
