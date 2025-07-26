import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFiles {

    WebDriver driver;
    @BeforeMethod
    public void FilePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void FileDownloadTest(){

        driver.get("https://leafground.com/file.xhtml");

        // download a file
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();

        //check the file is correctly downloaded (validation)
        File file = new File("C:\\Users\\user\\Downloads");
        File[] allFiles = file.listFiles();

        for (File findFile:allFiles) {
            if (findFile.getName().equals("TestLeaf Logo.png")) {
                System.out.println("file is downloaded");
                break;
            }
        }

    }
    @Test

    public void FileUploadTest() throws AWTException {
        driver.get("https://leafground.com/file.xhtml");

        // 1st way - using Robot class
        WebElement uploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadButton.click();

        // windows control begin here (selenium no more can't use here)

        String data = "C:\\Users\\user\\Downloads\\TestLeaf Logo.png"; //store the file's name which is want to upload, as string variable
        StringSelection selection = new StringSelection(data); //convert string(path of the file) into plain text (transferable content)

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null); //copying the path to clipboard

        Robot robot = new Robot();  //can not use Actions class here because this phase under control of the Java (can not do selenium operations here.) Therefore we use Robot class here
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // second way - using send keys (applicable only element type (input type=File in code) is file)

        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);










    }
}
