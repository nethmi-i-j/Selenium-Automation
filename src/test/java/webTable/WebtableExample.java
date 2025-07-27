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
        driver.get("https://testautomationpractice.blogspot.com/");

    }
    @Test

    public void WebTableTest(){

        // 1) how many rows in the table
        int rawCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("raw count of the table: "+ rawCount);

        // 2)how many columns in the table
        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("raw count of the table: "+ columnCount);

        // 3) retrieve the specific raw/column data
        String dataValue = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("specified raw/column data: "+dataValue);

        // 4) retrieve all the data from the table

        for (int i=1; i<=rawCount; i++) {  //outer loop (raw) - (variable defined; until which condition; how to increment)
            for (int j=1; j<columnCount; j++ ) {  // inner loop (column) - (variable defined; until which condition; how to increment)
                String tableData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.println(tableData + " ");
            }
                System.out.println(); //line break to get as a table
        }

        // 5) print ID and Name only
//        for (int i=1; i<=rawCount; i++) {
//            String tableID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
//            String productName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
//            System.out.println("table ID: " + tableID + "\t" + "product name is: " + productName);
//
//        }

        // 5.1) find the product price, which  name related to Tablet
        for (int i=1; i<=rawCount; i++) {
            String tableID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String productName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("table ID: " + tableID + "\t" + "product name is: " + productName);

            if (productName.equals("Tablet")) {
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(productName + "relevent product price is: " + productPrice);
                break;

            }
        }


    }
}
