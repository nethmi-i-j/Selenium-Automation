import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.List;

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

        driver.switchTo().frame(0);  // in frame 1
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String clickButton1 = button1.getText();
        System.out.println("after click inside frame button text: "+clickButton1);

        //Click (inside nested frame)

        /* there are 4 frames in this web page. now we are in frame 1. to move in to the frame 4which is inside in the
        frame 3, we should first enter the main html page and then move in to the frame 3 then after head in to
        the frame 4 (Nested frame) */

        driver.switchTo().defaultContent();  // switch to the main html page

        driver.switchTo().frame(2);  // switch to third frame

        driver.switchTo().frame(0);  // since only a one frame inside the fourth frame

        WebElement buttton3 = driver.findElement(By.id("Click"));
        buttton3.click();
        String clickButton3 = buttton3.getText();
        System.out.println("After click inside nested frame button text: "+clickButton3);

        // count of frames in this page

        driver.switchTo().defaultContent();  // switch to main html page from frame 4

        List<WebElement> allframes = driver.findElements(By.tagName("iframe"));
        int countOfFrames = allframes.size();
        System.out.println("No. of frames in this page: "+ countOfFrames);

        for (WebElement framesOnebyOne :allframes){
            String frameSrc = framesOnebyOne.getAttribute("src");
            System.out.println("frame src values: "+frameSrc);

        }




    }
}
