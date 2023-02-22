package SmartBear_Order;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class SmartBear {
    public static void main(String[] args) {
    }
    @Test
    public void navigateToSmartBear() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();


            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
            driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
            driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
            driver.findElement(By.id("ctl00_MainContent_login_button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/ul/li[3]/a")).click();
            Faker faker = new Faker ();
            Integer num =  faker.number().numberBetween(1,100);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE, num.toString());

            driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[5]/input[2]")).click();

            if (num>10){
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys(Keys.BACK_SPACE, "8");

                driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetAddress());
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());
                String zipCode= (faker.address().zipCode()).substring(0,5);
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipCode);


               Integer selection = faker.number().numberBetween(1, 3);
                String cardNum =  faker.number().digits(14);

               if(selection==1){
                  driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
                  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4"+cardNum);
               }else if(selection==2){
                   driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
                   driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5"+cardNum);
               }else if(selection==3){
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
                   driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("3"+cardNum);
            }
               Integer expMonth =  faker.number().numberBetween(1, 12);
               Integer expYear = faker.number().numberBetween(23, 35);
               String expDate = ""+ expMonth + "/" + expYear;

               if (expDate.length() <5){
                    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("0" + expDate);
               }else{
                   driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expDate);
               }
                driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
            //driver.quit();
                String actualText = driver.getTitle();
                Thread.sleep(2000);
                //Assert.assertEquals(actualText, "New order has been successfully added.");

                driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/ul/li[1]/a"));

                driver.findElement(By.id("ctl00_logout")).click();
                driver.quit();
        }
    }
}



