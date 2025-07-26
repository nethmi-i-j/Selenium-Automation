import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImages {

    WebDriver driver;

    @BeforeMethod
    public void ImagePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test

    public void BrokenImageTest(){

        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        // if "naturalWidth" = 0 (hidden attribute) then image is broken
        int i = 1;
        for (WebElement image : images) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println("image " + i + "is broken");
            } else {
                System.out.println("image" + i + "is not broken");
            }
            i++;
        }

    }
    
}
