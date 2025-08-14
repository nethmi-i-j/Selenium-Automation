package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshots {

    WebDriver driver;

    @BeforeMethod

    public void OpenWebPage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://leafground.com/alert.xhtml");
    }

    @Test

    public void takeScreenShots() throws IOException, AWTException {

        // 1) capture screenshot of full web page (using FileHandler)

       // C:\\Users\\user\\IdeaProjects\\SeleniumPractice\\Screenshot\\alert_full_web_page.png
        //C:\\Users\\user\\IdeaProjects\\SeleniumPractice = user.dir

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_full_web_page.png");
        FileHandler.copy(sourceFile,destinationFile);

        //File destinationFile = new File("C:\\Users\\user\\IdeaProjects\\SeleniumPractice\\Screenshot" + "\\alert_full_web_page.png");

        // 2) capture screenshot of section of a web page (using FileUtils)

        WebElement sectionOfPage = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
        File source = sectionOfPage.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_section_of_the_web_page.png");
        FileUtils.copyFile(source,target);

        // 3) capture screenshot of an element on a web page

        WebElement elementOfThePage = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]/div[1]"));
        File source1 = elementOfThePage.getScreenshotAs(OutputType.FILE);
        File target1 = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_element_of_the_web_page.png");
        FileUtils.copyFile(source1,target1);

        // 4)capture screenshot of full entire screen

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  //first get the screen size
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source2 = robot.createScreenCapture(rectangle);  //get the screenshot as entire screen
        File destination2 = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_page_entireScreen.png");
        ImageIO.write(source2,"png",destination2);















    }
}
