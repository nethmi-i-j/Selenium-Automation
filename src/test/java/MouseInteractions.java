import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        // 2) Drag and drop operation

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //actions.clickAndHold(from).moveToElement(to).release(to).perform(); // ist way
        actions.dragAndDrop(from,to).perform(); //second way

        // 3) Slider operation

        WebElement sliderPoint1 = driver.findElement(By.xpath("//*[@id='form:j_idt125']/span[1]"));
        System.out.println("location of slider point before moving: "+ sliderPoint1.getLocation());

        actions.dragAndDropBy(sliderPoint1,50,0).perform();
        System.out.println("location of slider point after moving: "+ sliderPoint1.getLocation());

        WebElement slider = driver.findElement(By.xpath("//*[@id='j_idt45']"));
        System.out.println("location of slider before moving: "+ slider.getLocation());

        actions.dragAndDropBy(slider,0,-20).perform();
        System.out.println("location of slider before moving: "+ slider.getLocation());

    }

    @Test

    public void MouseOperationsTest2(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        // 4) Right click

        WebElement rightClickButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));

        Actions actions1 = new Actions(driver);

        actions1.contextClick(rightClickButton).perform();   //actions1.doubleClik().perform();

        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertPop = driver.switchTo().alert();
        System.out.println("Alert text is: " + alertPop.getText());
        alertPop.accept();





    }
}
