package java_TestNG;

import org.openqa.selenium.By;

public class Locators {
    public By username = new By.ByXPath("//input[@name='username']");
   public By password = new By.ByXPath("//input[@name='password']");
   public By submit = new By.ByXPath("//button[@type='submit']");
   public By dropdown = new By.ByCssSelector(".oxd-userdropdown-tab");
    public By logout = new By.ByXPath("//a[text()='Logout']");
  public   By dashboard = new By.ByXPath("//h6[text()='Dashboard']");
}
