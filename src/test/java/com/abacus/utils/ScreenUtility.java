package com.abacus.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;

public class ScreenUtility {

    public static String getScreenshot(AppiumDriver<MobileElement> appiumDriver) throws IOException {
        appiumDriver.hideKeyboard();
        File sourceFile = appiumDriver.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + System.getProperty("file.separator")
                + "snaps" + System.getProperty("file.separator")
                + RandomUtility.getRandomString("Aa0", 16) + ".png";
        File destinationFile = new File(destinationPath);
        FileUtils.copyFile(sourceFile, destinationFile);
        return destinationPath;
    }

}
