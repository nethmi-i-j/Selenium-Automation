import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod

    public void button() {
        driver = new ChromeDriver();
        Dimension newsize = new Dimension(800,600);
        driver.manage().window().setSize(newsize);
        //driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml;jsessionid=node02h33npretclv1n9wq302xg3ex2375379.node0");

    }

    @Test

    public void buttonTests(){

        //01)click and confirm title
        WebElement findButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        findButton.click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        //if (expectedTitle.equals(actualTitle)){
            //System.out.println("actual title is same as expected");
        //} else {
            //System.out.println("title is not matching");
        //}
        Assert.assertEquals(actualTitle,expectedTitle,"title miss matching");
        driver.navigate().back();


        //02)find the position of the submitted button
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt90"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("x position is: " + x + "y position is: " + y);


        //03)find the save button colour
        WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
        String colour = buttonColour.getCssValue("background-color");
        System.out.println("button colour is: " +colour);


        //04)find the height and width of this button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt96"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("height is: "+ height + "width is: "+ width);








    }
}
