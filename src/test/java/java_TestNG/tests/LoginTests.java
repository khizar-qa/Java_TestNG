package java_TestNG.tests;

import java_TestNG.Locators;
import java_TestNG.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigUtils;

import java.util.Properties;

public class LoginTests {
    Login lgn;
    WebDriver driver;
    Locators loc;

    @BeforeClass
    public void openPage(){
        System.setProperty("webdriver.chrome.driver", "/Users/kanees/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        Properties prop = ConfigUtils.getProps("data");
        driver.get(prop.getProperty("URL"));
    }

    @Test(description = "Login Scenario", priority = 1)
    public void login(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        loc = new Locators();
        lgn = new Login(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loc.username));
        lgn.login();

        //verification
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc.dashboard));
        String text = driver.findElement(loc.dashboard).getText();
        Assert.assertEquals(text, "Dashboard");
    }

    @Test(description = "Logout Scenario", priority = 2)
    public void logout() throws InterruptedException {
        lgn.logout();
        //verification
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/login"));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
