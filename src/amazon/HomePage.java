package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage {

    public static void main(String[] args) throws InterruptedException {


        String amazonurl = "https://www.amazon.com/";
        String productName = "iPhone";
        String searchBox = "twotabsearchtextbox";
        String clickSearch = "nav-search-submit-button";
        String filterBox = "//*[@id=\"p_89/Apple\"]/span/a/div/label/i";
//        // FireFoxBrowser
//        String fireFoxDriverPath = "BrowserDriver/windows/geckodriver.exe";
//        System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
//        WebDriver driver1 = new FirefoxDriver();
//        driver1.get("https://www.amazon.com/");
//        // Edge
//        String edgeDriverPath = "BrowserDriver/windows/msedgedriver.exe";
//        System.setProperty("webdriver.edge.driver", edgeDriverPath);
//        WebDriver driver2 = new EdgeDriver();
//        driver2.get("https://www.amazon.com/");
        // ChromeBrowser
        String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.com/");
        driver.get(amazonurl);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.id(searchBox)).sendKeys(productName);
        driver.findElement(By.id(clickSearch)).click();
        driver.findElement(By.xpath(filterBox)).click();
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone"); //must search for unique values/keys. sendKeys=text input
//        driver.findElement(By.id("nav-search-submit-button")).click(); //must search for unique values/keys. click = click the button
        Thread.sleep(5000);
        driver.close();

    }

}
