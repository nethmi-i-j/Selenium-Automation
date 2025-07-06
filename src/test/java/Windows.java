import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Windows {

    WebDriver driver;
    @BeforeMethod

    public void windowsTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }
    @Test

    public void windowTest(){
        //1) click and confirm new window opens

        String parentWindow = driver.getWindowHandle();
        System.out.println("parent window is: "+parentWindow);

        WebElement openButton = driver.findElement(By.id("j_idt88:new"));
        openButton.click();

        Set<String> handles = driver.getWindowHandles();
        System.out.println("no.of windows opened: "+ handles.size());  //since only parent and one window

        // First method - using forEach loop
        for(String newWindow : handles){
            System.out.println(newWindow);   //for loop ends on the child window
            driver.switchTo().window(newWindow);
            System.out.println("page title is: "+driver.getTitle());  //title of child window
        }
        driver.close();  //redirect to parent window

        driver.switchTo().window(parentWindow);

        String redirectWindow = driver.getTitle();
        System.out.println(redirectWindow);

        WebElement openButton2 = driver.findElement(By.xpath("//*['j_idt88:new']/span"));
        boolean OpenButtonVisibility = openButton2.isDisplayed();
        System.out.println("Open button visibility: "+OpenButtonVisibility);


    }
}
