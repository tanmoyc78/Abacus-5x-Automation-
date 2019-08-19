package com.abacus.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenshotUtility {

    public static File getScreenshot(AppiumDriver<MobileElement> appiumDriver) {
        try {
            File sourceFile = appiumDriver.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(System.getProperty("user.dir")
                    + System.getProperty("file.separator") + "snaps"
                    + System.getProperty("file.separator")
                    + RandomUtility.getRandomString("Aa0", 16) + ".png");
            FileUtils.copyFile(sourceFile, destinationFile);
            return destinationFile;
        }
        catch (IOException e) {
            return null;
        }
    }

}
