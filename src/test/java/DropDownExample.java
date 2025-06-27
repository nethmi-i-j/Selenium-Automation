import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod

    public void dropDown() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test

    public void dropDownTest() {


        //1.1) ways of select values in basic dropdown
        driver.get("https://www.leafground.com/select.xhtml;jsessionid=node017pg80ozhgl3lk00o61thbn4l2431056.node0");
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        //1.2) get the number of dropdown options
        List<WebElement> listOfoptions = select.getOptions();
        System.out.println("No of elements in dropdown: " + listOfoptions.size());

        for (WebElement element : listOfoptions) {
            System.out.println(element.getText());
        }

        //1.3) using sendkeys select dropdown value
        dropdown.sendKeys("Puppeteer");

        //1.4) selecting value in a bootstrap drop down
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listOfdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listOfdropdown2values) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")) {
                element.click();
                break;
            }
        }
    }

    //2) google search - pick a value from suggestions
    //@Test

    //public void googleSearchDropDown() throws InterruptedException {
       // driver.get("google link");
        //driver.findElement(By.name("q")).sendKeys("palitha");
        //Thread.sleep(2000);
        //List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@classs='wM6W7d']"));
        //System.out.println(googleSearchList.size());
        //for (WebElement elements : googleSearchList) {
          //  System.out.println(elements.getText());
            //String googleSearch = elements.getText();
            //if (googleSearch.equals("Palitha Thewarapperuma")) {
              //  elements.click();
                //break;
            //}
        //}
        // 3) handle hidden auto suggestions drop down and search using DOM Debugger trick

    //}
}