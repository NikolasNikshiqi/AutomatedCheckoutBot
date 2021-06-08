import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class Scalping {
    public static WebDriver driver;
    public static WebDriverWait t;
    public static JavascriptExecutor Js1;
    public static ChromeOptions options;
    public static final String URL = "https://www.nike.com/ca";

    public static void clickPop() {
        t.until(ExpectedConditions.presenceOfElementLocated(By.className("hf-modal-btn-close")));
        driver.findElement(By.xpath("//*[@id=\"gen-nav-footer\"]/nav/div/div/div[2]/div/a[3]")).click();
    }

    public static void main(String[] args) throws MalformedURLException {
        boolean buttonFound = false;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zbook 15\\Downloads\\chromedriver.exe");

        options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("window-size=1280,800");
        driver = new ChromeDriver(options);


        t = new WebDriverWait(driver, 6);
        Js1 = (JavascriptExecutor) driver;

        driver.get(URL);
        Js1.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        clickPop();

        driver.navigate().to("https://www.nike.com/ca/t/jordan-ma2-greatest-gift-shoe-dmkgC9/CV8122-006");
        while (!buttonFound) {
            if (driver.findElement(By.className("add-to-cart-btn")).isEnabled()) {


                var shoeSize9 = driver.findElement(By.xpath("//*[@id=\"buyTools\"]/div[1]/fieldset/div/div[11]/label"));

                Js1.executeScript("window.scrollBy(0,400)");

                shoeSize9.click();
                var buyButton = driver.findElement(By.className("add-to-cart-btn"));
                t.until(ExpectedConditions.visibilityOf(buyButton));
                buyButton.click();
                buttonFound = true;

            } else {
                driver.navigate().refresh();
            }

        }
        // View bag
        t.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"PDP\"]/div/div[4]/div/div/div/div/div/div/div/div/div/div[3]/div/button[1]")));
        driver.findElement(By.xpath("//*[@id=\"PDP\"]/div/div[4]/div/div/div/div/div/div/div/div/div/div[3]/div/button[1]")).click();
        //clickPop();
        t.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div[3]/div/div/button[1]")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div[3]/div/div/button[1]")).click();
    }
}
