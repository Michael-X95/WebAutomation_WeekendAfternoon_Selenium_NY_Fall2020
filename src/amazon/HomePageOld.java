package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageOld {

    WebDriver driver;
    String amazonurl = "https://www.amazon.com/";
    String productName = "iPhone";
    String searchBox = "twotabsearchtextbox";
    String clickSearch = "nav-search-submit-button";
    String filterBox = "//*[@id=\"p_89/Apple\"]/span/a/div/label/i";

    @BeforeMethod
    public void setUp() {
        String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get(amazonurl);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Test
    public void testCheckSearchBox(){
        checkSearchBox();
        String expectedText = "\"iPhone\"";
        String actualText = driver.findElement(By.className("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText,expectedText,"Product does not match");


    }

    public void checkSearchBox() {
        driver.findElement(By.id(searchBox)).sendKeys(productName);
        driver.findElement(By.id(clickSearch)).click();
        driver.findElement(By.xpath(filterBox)).click();

    }

    @AfterMethod
    public void tearDown() {
        //  driver.close(); // close 1
          driver.quit(); // close all
    }

}

