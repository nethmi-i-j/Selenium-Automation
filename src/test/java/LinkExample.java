
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml;jsessionid=node0rjvdyb96e6k320lxdnfnzmw2337469.node0");

    }

    @Test
    public void LinkTests(){

        //1) take me to dashboard

        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //2)find my destination

        WebElement wheretoGo =  driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to : "+path);

        //3) am i broken link

        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title = driver.getTitle();
        if (title.contains("404")) {
            System.out.println("The link is broken");
        } else{
            System.out.println("Not Broken");
        }
        driver.navigate().back();

        //4)duplicate link

        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();


        //5)count page links

        List<WebElement> countfullpageLinks =  driver.findElements(By.tagName("a"));
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("count of full page links: "+ pageLinkCount);

        //6) count layout links

        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countofLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("count of layout links: "+ countofLayoutLinks.size());

















    }
}
