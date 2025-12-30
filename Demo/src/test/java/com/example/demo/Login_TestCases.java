package com.example.demo;

import org.openqa.selenium.WebDriver;

public class Login_TestCases {

    public void testCase1_ValidLogin() {
        WebDriver driver = DriverManager.getDriver();
        try {
            boolean success = DriverManager.performLogin(driver, "Pawaradmin01", "Test@2025");
            String url = driver.getCurrentUrl();
            String status = success && !url.contains("UserManager.aspx") ? "PASS" : "FAIL";
            ReportGenerator.addToReport("Valid Login", "Pawaradmin01", "Test@2025", status);
        } catch (Exception e) {
            ReportGenerator.addToReport("Valid Login", "Pawaradmin01", "Test@2025", "FAIL");
        } finally {
            driver.quit();
        }
    }

    public void testCase2_WrongUsername() {
        WebDriver driver = DriverManager.getDriver();
        try {
            boolean success = DriverManager.performLogin(driver, "wronguser", "Test@2025");
            String url = driver.getCurrentUrl();
            String status = success && url.contains("UserManager.aspx") ? "PASS" : "FAIL";
            ReportGenerator.addToReport("Wrong Username", "wronguser", "Test@2025", status);
        } catch (Exception e) {
            ReportGenerator.addToReport("Wrong Username", "wronguser", "Test@2025", "FAIL");
        } finally {
            driver.quit();
        }
    }

    public void testCase3_WrongPassword() {
        WebDriver driver = DriverManager.getDriver();
        try {
            boolean success = DriverManager.performLogin(driver, "Pawaradmin01", "wrongpass");
            String url = driver.getCurrentUrl();
            String status = success && url.contains("UserManager.aspx") ? "PASS" : "FAIL";
            ReportGenerator.addToReport("Wrong Password", "Pawaradmin01", "wrongpass", status);
        } catch (Exception e) {
            ReportGenerator.addToReport("Wrong Password", "Pawaradmin01", "wrongpass", "FAIL");
        } finally {
            driver.quit();
        }
    }
}