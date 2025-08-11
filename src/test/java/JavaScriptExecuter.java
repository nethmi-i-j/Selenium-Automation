import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuter {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod

    public void OpenJSExecutorPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }
    @Test

    public void JsExecutorTests() throws InterruptedException {

        jsExecutor = (JavascriptExecutor) driver;


        // 1) get a alert box in to web page using javaScript
        //jsExecutor.executeScript("alert('hello');");

        // 2) set a input value in a text box using javaScript Executor

            // 2.1) way 1 - set the value using the value property (common approach)
        WebElement textBox = driver.findElement(By.xpath("//input[@id='name']"));
        jsExecutor.executeScript("arguments[0].value='Hansi';",textBox);

           // 2.2) way 2 - set the value using setAttribute (alternative way)
        //jsExecutor.executeScript("arguments[0].setAttribute('value','Hansi');",textBox);

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
        scrollPage();


        // 6) set all attributes from a wanted element
        getAllAttributes(textBox);

        // 7) reload the page
        jsExecutor.executeScript("location.reload();");

        //jsExecutor.executeScript("history.go(0);");  <--- another method

        // 8) zoom the page
        jsExecutor.executeScript("document.body.style.zoom='150%';");

    }

    public void scrollPage() throws InterruptedException {

        //5.1) scroll to some position
        jsExecutor.executeScript("window.scrollTo(0, 1000);");  //(x,y) in pixel
        System.out.println("current page Y offset value is: " + jsExecutor.executeScript("return window.pageYOffset;"));
        Thread.sleep(5000);

        jsExecutor.executeScript("window.scrollTo(0, -1000);");  //back to initial position

        //5.2) scroll to bottom of the page by pixel number
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(5000);

        //5.3) scroll to the top of the page
        jsExecutor.executeScript("window.scrollTo(0,0);");
        Thread.sleep(5000);

        //5.4) scroll the page till element is visible
        WebElement scrollElement = driver.findElement(By.xpath("//label[text()='Gender:']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", scrollElement);


    }

    public String getAllAttributes(WebElement webElement) {
        Object elementAttributes = jsExecutor.executeScript("var items = {}; for (index = 0; index< arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name]",webElement);
        System.out.println("all attributes values are: " + elementAttributes.toString());
        return elementAttributes.toString();

    }




}



