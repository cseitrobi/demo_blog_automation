package com.example.demo_blog_automation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Reporter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.github.ashwith.flutter.FlutterFinder;

public class DemoRunTest extends config {
    RemoteWebDriver driver;
    // private AndroidDriver driver1; // Unused, remove if not needed
    private FlutterFinder find;
    config con=new config();

    @BeforeMethod
    public void apprunconfig() throws MalformedURLException {
        find = con.config();
    }

    @Test
    public void login() throws InterruptedException {
        WebElement emailField=find.byValueKey("emailField");
        emailField.sendKeys("xyz@gmail.com");
        WebElement passwordField=find.byValueKey("passwordField");
        passwordField.sendKeys("12345678");
        Thread.sleep(1000);
        WebElement loginButton=find.byValueKey("loginButton");
        Thread.sleep(1000);
        loginButton.click();        
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    // Update @AfterTest to include uninstall and clear cache
    @AfterTest
    public void postTestCleanup() {
        // Uninstall Appium settings app
        AppiumUtils.uninstallApp("io.appium.settings");
        // Clear Appium settings app cache
        AppiumUtils.clearAppCache("io.appium.settings");

        // Uninstall Shell BD app
        AppiumUtils.uninstallApp("com.example.demo_blog");
        // Clear Shell BD app cache
        AppiumUtils.clearAppCache("com.example.demo_blog");
}
}




