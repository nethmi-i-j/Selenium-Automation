import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod

    public void AlertTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/alert.xhtml;jsessionid=node0k5s6trwljabyi7hmv0mnqft72826930.node0");
    }

    @Test

    public void AlertTest(){

        //1) Alert (simple dialog box)

        driver.findElement(By.id("j_idt88:j_idt91")).click();
        driver.switchTo().alert().accept();
        //Alert alert = driver.switchTo().alert().accept();
        // alert.accept();

        //2) Alert confirm dialog box
        WebElement confirmbox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmbox.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        //3) Accept prompt dialog box

        driver.findElement(By.id("j_idt88:j_idt104")).click();
        Alert alert2 = driver.switchTo().alert();
        String text = alert2.getText();
        System.out.println("Alert text is: "+text);
        alert2.sendKeys("My name is blabla");
        alert2.accept();




    }
}
