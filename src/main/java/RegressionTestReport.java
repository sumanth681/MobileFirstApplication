import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class RegressionTestReport {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\admin\\\\Downloads\\\\chromedriver-win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://qamoviesapp.ccbp.tech/login");

        driver.get("https://qaotploginpage.ccbp.tech");

        WebElement emailOption = driver.findElement(By.id("email"));

        emailOption.sendKeys("example@gmail.com");

        // sending otp

        WebElement sendOtpBtn = driver.findElement(By.className("send-otp-btn"));
        sendOtpBtn .click();


        String currentPageTitle = driver.getTitle();

        String ExpectedPageTitle = "OTP Verification";
        if(currentPageTitle.equals(ExpectedPageTitle)){
            System.out.println("OTP sent successfully");
        }



        WebElement enteringOtp = driver.findElement(By.id("otp"));
        enteringOtp.sendKeys("123456");



        WebElement verifyOtpBtn = driver.findElement(By.id("verifyOtpBtn"));
        verifyOtpBtn.click();



        String expectedUrl = "https://qaotploginpage.ccbp.tech/home";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe (expectedUrl));
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(expectedUrl)){
            System.out.println("Logged in successfully");
        }

        String currentPage = driver.getTitle();
        System.out.println(currentPage);


        driver.close();

    }

}





