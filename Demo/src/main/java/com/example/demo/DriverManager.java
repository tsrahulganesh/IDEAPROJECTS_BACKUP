package com.example.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class DriverManager {
    
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static boolean performLogin(WebDriver driver, String username, String password) {
        try {
            driver.get("https://bankubt.onlinebank.com/Service/UserManager.aspx");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='txtLoginName']")));
            WebElement passwordField = driver.findElement(By.cssSelector("input[id*='txtPassword']"));
            
            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            
            try {
                driver.findElement(By.cssSelector("input[type='submit']")).click();
            } catch (Exception e) {
                passwordField.sendKeys(Keys.ENTER);
            }
            
            Thread.sleep(3000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}