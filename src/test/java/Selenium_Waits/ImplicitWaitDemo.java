package Selenium_Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitDemo {

    WebDriver driver;

    @BeforeMethod

    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //pageLoadTimeout() exception --> for driver.get & driver.navigateTo
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));  //industry standard time duration is 10 seconds. if this exceed then there is a performance issue
        driver.get("https://leafground.com/waits.xhtml;jsessionid=node01x0mme0rwupdjow2pdg4tr2l83745924.node0");
    }
    @Test

    public void implicitWaitTest(){


    }
}
