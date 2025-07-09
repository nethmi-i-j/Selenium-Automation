import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class FrameExample {

    WebDriver driver;

    @BeforeMethod

    public void Frames(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/frame.xhtml;jsessionid=node01guaes9pcofbl1dx112enktg6s2859151.node0");
    }

    public void FramesTest(){

        // 1) click (inside frame)

        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String clickButton1 = button1.getText();
        System.out.println("after click inside frame button text: "+clickButton1);






        

    }
}
