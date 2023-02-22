/*import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class diceCom {
    public static void main(String[] args) {

    }

    @Test
    public void navigateToDice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.dice.com/");
        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        Thread.sleep(2000);
        driver.findElement(By.id("submitSearch-button")).click();
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='card-title-link bold']"));
        if (elements.size()==0){

        }
    }
} */