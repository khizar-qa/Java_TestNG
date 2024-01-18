package java_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigUtils;

import java.util.Properties;

public class Login {
    WebDriver driver;
    Locators loc = new Locators();

    public Login(WebDriver driver){
        this.driver = driver;
    }
    public void login() {
        Properties prop = ConfigUtils.getProps("data");
        driver.findElement(loc.username).sendKeys(prop.getProperty("Username"));
        driver.findElement(loc.password).sendKeys(prop.getProperty("Password"));
        driver.findElement(loc.submit).click();
    }
    public void logout() throws InterruptedException {
        driver.findElement(loc.dropdown).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc.logout));
        driver.findElement(loc.logout).click();
    }
}
