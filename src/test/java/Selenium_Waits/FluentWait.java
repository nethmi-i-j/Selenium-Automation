package Selenium_Waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import java.util.function.Function;

public class FluentWait<W extends SearchContext> {

    WebDriver driver;



    @BeforeMethod

    public void OpenPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml;jsessionid=node01x0mme0rwupdjow2pdg4tr2l83745924.node0");

    }
    @Test
    public void fluentWaitTest(){

        // declaration part of fluent wait

        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) //maximum time to wait
                .pollingEvery(Duration.ofSeconds(5)) //frequency to check the condition
                .ignoring(NoSuchElementException.class); /* ignore specific exception (if this is imported from java,
                this gives error as "No Such Element",
                often use which is provided by selenium, it doesn't give errors)*/

        driver.findElement(By.id("j_idt87:j_idt89")).click();

        WebElement fluentWaitElement = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) { //apply can not change
                return driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span"));
            }
        });  //return as webElement

        //2nd way
        //By popUpBtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span"); //locator
        //WebElement fluentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpBtnLocator));

        String popUpButton = fluentWaitElement.getText();
        System.out.println("pop up button text is: " + popUpButton);

    }




}
