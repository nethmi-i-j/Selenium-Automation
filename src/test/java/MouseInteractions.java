import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseInteractions {

    WebDriver driver;

    @BeforeMethod

    public void MouseOperationsPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test

    public void MouseOperationsTest1(){
        driver.get("https://leafground.com/drag.xhtml");
        // 1) Move to element operation

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

    }
    @Test

    public void MouseOperationsTest2(){
        driver.get("https://leafground.com/drag.xhtml");
    }
}
