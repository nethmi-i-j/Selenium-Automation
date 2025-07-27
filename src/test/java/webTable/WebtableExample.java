package webTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebtableExample {

    WebDriver driver;

    @BeforeMethod

    public void OpenTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");

    }
    @Test

    public void WebTableTest(){

        // 1) how many rows in the table
        int rawCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("raw count of the table: "+ rawCount);

        // 2)how many columns in the table
        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("raw count of the table: "+ columnCount);


    }
}
