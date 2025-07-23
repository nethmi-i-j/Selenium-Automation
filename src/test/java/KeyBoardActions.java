import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class KeyBoardActions {

    WebDriver driver;
    @BeforeMethod

    public void KeyBoardPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void KeyBoardTest1(){

        driver.get("");
        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("welcome");

        Actions actions = new Actions(driver);
        // select the text
        Action storeBuildOperation = actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();  //.build().perform() = .perform()
        storeBuildOperation.perform();

        actions.keyDown(Keys.SHIFT)  //typing capital letters
                .sendKeys("writing capital sentence")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)  // select the sentence
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)  //delete the selected sentence
                .sendKeys("x")
                .perform();

        // to write capital in a textbox
        actions.keyDown(textBox,Keys.SHIFT).sendKeys("hello").perform();
    }
    @Test
    public void keyBoardTest2() throws InterruptedException {
        driver.get("https://leafground.com/list.xhtml");
        Thread.sleep(4000);

        // select a list by using control key
        List<WebElement> list = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = list.size();
        System.out.println("list count is: " + size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(list.get(0))
                .click(list.get(1))
                .click(list.get(2))
                .perform();


    }
}
