package com.example.demo_blog_automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class config {
        RemoteWebDriver driver;
    // private AndroidDriver driver1; // Unused, remove if not needed
    private FlutterFinder find;
    public FlutterFinder config() throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "R58R74LDNZV");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("app", "/home/robi/AndroidStudioProjects/demo_blog/build/app/outputs/flutter-apk/app-debug.apk");
        capabilities.setCapability("automationName", "Flutter");
        driver = new AppiumDriver(new URL("http://0.0.0.0:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        find = new FlutterFinder(driver);
        return find;



    }
    
}
