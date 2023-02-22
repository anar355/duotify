import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Duotify {
    public static void main(String[] args) {

    }
    @Test
    public void navigateToDuotify() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        Assert.assertEquals(driver.getTitle(), "Welcome to Duotify!");
        driver.findElement(By.id("hideLogin")).click();

        Faker faker = new Faker ();
        String usrn =  faker.name().username();
        driver.findElement(By.id("username")).sendKeys(usrn);

        //Thread.sleep(500);
        String fName = faker.address().firstName();
        driver.findElement(By.id("firstName")).sendKeys(fName);

        //Thread.sleep(500);
        String lName = faker.address().lastName();
        driver.findElement(By.id("lastName")).sendKeys(lName);

        //Thread.sleep(500);
        String email = faker.internet().emailAddress();
        driver.findElement(By.id("email")).sendKeys(email);

        //Thread.sleep(500);
        driver.findElement(By.id("email2")).sendKeys(email);
        //Thread.sleep(500);
        String pswd = faker.internet().password();
        driver.findElement(By.id("password")).sendKeys(pswd);

        //Thread.sleep(500);
        driver.findElement(By.id("password2")).sendKeys(pswd);
        //Thread.sleep(500);
        driver.findElement(By.name("registerButton")).click();
        //Thread.sleep(500);

        String currentUrl = driver.getCurrentUrl();

       // Thread.sleep(2000);
        Assert.assertEquals(currentUrl, "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?");

        driver.findElement(By.id("nameFirstAndLast")).getText().equals(fName + " " + lName);
        Thread.sleep(2000);
        driver.findElement(By.tagName("h1")).getText().equals(fName + " " + lName);
        Thread.sleep(10000);
        driver.findElement(By.id("rafael")).click();

        String currentUrl2 = driver.getCurrentUrl();
        Thread.sleep(5000);
        Assert.assertEquals(currentUrl2, "http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        driver.findElement(By.id("loginUsername")).sendKeys(usrn);
        driver.findElement(By.id("loginPassword")).sendKeys(pswd);
        driver.findElement(By.name("loginButton")).click();

        driver.findElement(By.id("mainContent")).getText().contains("You Might Also Like");

        driver.findElement(By.id("rafael")).click();
        driver.quit();


        }
        


    }


