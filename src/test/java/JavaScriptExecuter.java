import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuter {

    WebDriver driver;

    @BeforeMethod

    public void OpenJSExecutorPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }
    @Test

    public void JsExecutorTests() throws InterruptedException {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;


        // 1) get a alert box in to web page using javaScript
        jsExecutor.executeScript("alert('hello');");

        // 2) set a input value in a text box using javaScript Executor

            // 2.1) way 1 - set the value using the value property (common approach)
        WebElement textBox = driver.findElement(By.xpath("//input[@id='name']"));
        jsExecutor.executeScript("arguments[0].value='Hansi';",textBox);

           // 2.2) way 2 - set the value using setAttribute (alternative way)
        jsExecutor.executeScript("arguments[0].setAttribute('value','Hansi');",textBox);

        Thread.sleep(4000);

        // 3) highlight element
        jsExecutor.executeScript("arguments[0].style.border='3px solid red';",textBox);
        jsExecutor.executeScript("arguments[0].style.background='yellow';",textBox);

        Thread.sleep(4000);

        // 4) click element using js Executor
        WebElement clickCheckBox = driver.findElement(By.xpath("//input[@id='male']"));
        jsExecutor.executeScript("arguments[0].click();",clickCheckBox);

        Thread.sleep(4000);

        // 5) scrolling the page


        // 6) set all attributes from a wanted element
    }


}
