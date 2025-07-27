import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Calender {

    WebDriver driver;

    @BeforeMethod

    public void CalenderPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");

    }
    @Test
    public void calenderTest() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        // method 1 (when input type="text")

//        WebElement datePicker = driver.findElement(By.id("datepicker"));
//        datePicker.sendKeys("07/26/2025");

        // method 2

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        selectFutureDate("2025","December","5");
        //selectPastDate("2025", "May", "30");

    }


    public void selectFutureDate(String year, String month, String day) {
        while (true) {
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)) {
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }
        List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement dateElement : allDays) {
            if (dateElement.getText().equals(day)) {
                dateElement.click();
                break;
            }
        }
    }


    public void selectPastDate(String year, String month, String day) {
        while (true) {
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)) {
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }
        List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement dateElement : allDays) {
            if (dateElement.getText().equals(day)) {
                dateElement.click();
                break;
            }
        }
    }









}
