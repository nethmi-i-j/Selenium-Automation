import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
}
