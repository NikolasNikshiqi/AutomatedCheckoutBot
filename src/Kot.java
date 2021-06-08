import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Kot {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zbook 15\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.nike.com/ca/t/jordan-ma2-greatest-gift-shoe-dmkgC9/CV8122-006");
        Thread.sleep(500);
        Js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("//*[@id=\"gen-nav-footer\"]/nav/div/div/div[2]/div/a[3]")).click();
        driver.navigate().to("https://www.nike.com/ca/t/jordan-ma2-greatest-gift-shoe-dmkgC9/CV8122-006");
        driver.findElement(By.xpath("//*[@id=\"floating-atc-wrapper\"]/div/button[1]"));
    }
}
