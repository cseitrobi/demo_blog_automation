package com.example.demo_blog_automation;

import java.io.IOException;

public class AppiumUtils {
    public static void uninstallApp(String packageName) {
        String command = String.format("adb uninstall %s", packageName);
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearAppCache(String packageName) {
        String command = String.format("adb shell pm clear %s", packageName);
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
