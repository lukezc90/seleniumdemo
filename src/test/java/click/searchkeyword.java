package click;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class searchkeyword {

    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.setHeadless(true);

        driver = new ChromeDriver(options);
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application");

    }

    @Test
    private void test() throws Exception{
        driver.get("https://testerhome.com/");
        //search 框定位 - css
        By searchBy = By.tagName("input");

        WebElement searchWebElement = driver.findElement(searchBy);
        searchWebElement.sendKeys("selenium");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }
}
