package Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWait {

    WebDriver driver;

    @BeforeMethod

    public void openTablePage(){
        driver = new ChromeDriver();

        /* implicit wait exception ---> valid for all test cases under the method. it holds time duration errors
        (synchronized errors, time out errors) check only element present on the DOM,
        not checking its visibility or interactability */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        //pageLoadTimeout() exception --> for driver.get & driver.navigateTo

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));  /*industry standard time duration is 10 seconds.
        if this exceeds then there is a performance issue */

        driver.get("https://leafground.com/waits.xhtml;jsessionid=node01x0mme0rwupdjow2pdg4tr2l83745924.node0");
    }
    @Test

    public void implicitWaitTest(){

        WebElement buttonForVisibility = driver.findElement(By.id("j_idt87:j_idt89"));
        buttonForVisibility.click();

        String popUpButton = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("pop up button text is: " + popUpButton);


    }
}
