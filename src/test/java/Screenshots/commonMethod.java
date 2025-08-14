package Screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class commonMethod {

    public static void takeWebPageScreenshot(WebDriver driver, String filename) throws IOException {

        //create a date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");

        //get the current date and time
        Date date = new Date();

        //format the date and time
        String timeStamp = formatter.format(date);

        // take full web page screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + filename + "_" + timeStamp + ".png");
        FileHandler.copy(sourceFile,destinationFile);
    }

    public static void takeEntireScreenScreenshot(String filename) throws AWTException, IOException {

        String timestamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  //first get the screen size
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source2 = robot.createScreenCapture(rectangle);  //get the screenshot as entire screen

        File destinationFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + filename + "_" + timestamp + ".png" );
        ImageIO.write(source2,"png",destinationFile);
    }


}
