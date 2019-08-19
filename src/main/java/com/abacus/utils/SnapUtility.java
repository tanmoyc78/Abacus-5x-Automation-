package com.abacus.utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import io.appium.java_client.AppiumDriver;

public class SnapUtility {

  public static File takeScreenShot(AppiumDriver appiumDriver)
      throws IOException {
    File screenShot = appiumDriver.getScreenshotAs(OutputType.FILE);
    File screenShotFile = new File(System.getProperty("user.dir")
        + System.getProperty("file.separator") + "snaps"
        + System.getProperty("file.separator") + getRandomString(8) + ".png");
    while (screenShotFile.exists()) {
      screenShotFile = new File(System.getProperty("user.dir")
          + System.getProperty("file.separator") + "snaps"
          + System.getProperty("file.separator") + getRandomString(8) + ".png");
    }
    FileUtils.copyFile(screenShot, screenShotFile);
    return screenShotFile;
  }

  private static String getRandomString(int nameLength) {
    String allCharacters =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    StringBuilder stringBuilder = new StringBuilder();
    Random random = new Random();
    while (stringBuilder.length() < nameLength) {
      stringBuilder.append(allCharacters.charAt(random.nextInt(62)));
    }
    return stringBuilder.toString();
  }

}
