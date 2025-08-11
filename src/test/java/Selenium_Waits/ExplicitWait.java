package Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait {

    WebDriver driver;

    @BeforeMethod

    public void OpenPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml;jsessionid=node01x0mme0rwupdjow2pdg4tr2l83745924.node0");

    }

    @Test

    public void explicitWaitTest(){

        // check for visibility (efficient than implicit wait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Declaration , standard time=10s

        /* WebElement waitElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//button[@id='j_idt87:j_idt90']/span"))); //by method chaining */

        driver.findElement(By.id("j_idt87:j_idt89")).click();

        By popUpBtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span"); //locator


        WebElement newBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpBtnLocator));


        /*by using .visibilityOf() <--- using webElement

        WebElement newButton = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span"));
        WebElement newBtn1 = wait.until(ExpectedConditions.visibilityOf(newButton)); */

        String popUpButton = newBtn.getText();
        System.out.println("pop up button text is: " + popUpButton);

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
