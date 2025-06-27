import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestboxExample {

    WebDriver driver;

    @BeforeMethod

    public void OpenTextbox() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node01duv0oeyv9i3jo2rcv35xzkay2340182.node0");
        Thread.sleep(3000);
    }

    @Test

    public void textboxTests(){

        //01)type your name
        driver.findElement(By.id("j_idt88:name")).sendKeys("John Perera");


        //02)append country to this city
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");


        //03)verify if text box is enabled
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("is textbox enabled? " + enabled);


        //04)clear the typed text
        //xpath = (//*[@id="j_idt88:j_idt95"])
        WebElement clearText = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']"));
        clearText.clear();


        //05)retrieve the typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);


        //06)type email and tab confirm control moved to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("abc@gmail.com" + Keys.TAB + "confirmed control moved to next element");

    }

}
