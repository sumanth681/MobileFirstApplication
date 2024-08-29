import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadTestReport {
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\admin\\\\Downloads\\\\chromedriver-win32\\\\chromedriver.exe");
        int numberOfUsers = 5;
        for (int i = 0; i < numberOfUsers; i++) {
            Thread thread = new Thread(new FlipkartUsers());
            thread.start();
        }
    }
}
class FlipkartUsers implements Runnable {

    @Override
    public void run() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.flipkart.com");
            try {
                WebElement closeLoginPopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
                closeLoginPopup.click();
            } catch (Exception e) {
                System.out.println("Login popup did not appear.");
            }
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("laptop");
            searchBox.submit();
            System.out.println("Title: " + driver.getTitle());

        } finally {
            // Quit the driver
            driver.quit();
        }
    }
}
