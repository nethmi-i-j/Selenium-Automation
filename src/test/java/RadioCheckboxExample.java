import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckboxExample {

    WebDriver driver;
    @BeforeMethod
    public void RadioCheckbox(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void radioTest(){
         //<<<<<Radio>>>>>
        //1) find the default selectmradio button

        driver.get("https://www.leafground.com/radio.xhtml");
        //boolean ChromradioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        //boolean firefoxradioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        //boolean safariradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        //boolean edgeradioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        //if (ChromradioOption){
            //String chromText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            //System.out.println("default select radio button is : "+chromText);
        //} else if (firefoxradioOption) {
            //String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            //System.out.println("default select radio button is : "+firefoxText);
        //} else if (safariradioOption){
            //String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            //System.out.println("default select radio button is : "+safariText);
        //} else if (edgeradioOption){
            //String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            //System.out.println("default select radio button is : "+edgeText);
        //}

        // another method

        List<WebElement> radioelements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
        int radiocount = radioelements.size();
        System.out.println("radio count is : "+radiocount);

        int index = -1;

        for (WebElement radios:radioelements) {
            index++;
            if (radios.isSelected()){
                WebElement defaulSelectedRadioButton = driver.findElement(By.xpath("//label[@for='j_idt87:console2:" + index + "']"));
                String SelectedradioText = defaulSelectedRadioButton.getText();
                System.out.println("default selected radio button is : "+SelectedradioText);
                break;
            }
        }


        //2) select the age group (only if not selected)

        WebElement myageGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean ischecked = myageGroup.isSelected();
        if (!ischecked) {
            //myageGroup.click();

            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }
    }
    @Test

    public void CheckBoxTest(){

        //1) select wanted checkboxes and verifying those checkboxes status

        driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01xpn2aktug1g7jiheij6i82ga2742578.node0");

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element:checkBoxes){
            if (!(element.getText().equals("Others")))
                element.click();
        }

        for (int i=1; i<=checkBoxes.size(); i++){
            boolean CheckBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i+ "]")).isSelected();
            System.out.println("CheckBox " +i + " selected status is : " + CheckBoxStatus);
        }


    }







}
