package com.abacus.utils;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DrivingUtility {

  private static ResourceUtility resourceUtility;
  final static Logger logger = LoggerFactory.getLogger(DrivingUtility.class);

  public static AppiumDriver<MobileElement> getDriver()
      throws MalformedURLException {
    resourceUtility = new ResourceUtility("config");
    String platformName = resourceUtility.getResource("platformName");
    String platformVersion = resourceUtility.getResource("platformVersion");
    String deviceName = resourceUtility.getResource("deviceName");
    String deviceUDID = resourceUtility.getResource("deviceUDID");
    String appLocation = resourceUtility.getResource("appLocation");
    appLocation = System.getProperty("user.dir") + appLocation;
    String hostName = resourceUtility.getResource("hostName");
    String portNumber = resourceUtility.getResource("portNumber");

    logger.info("Following are the device parameters set : \n\nplatformName : "
        + platformName + "\nplatformVersion : " + platformVersion
        + "\ndeviceName : " + deviceName + "\ndeviceUDID : " + deviceUDID
        + "\napp : " + appLocation + "\nuseNewWDA : " + true + "\nnoReset : "
        + true + "\nfullReset : " + false + "\n");

    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", platformName);
    desiredCapabilities.setCapability("platformVersion", platformVersion);
    desiredCapabilities.setCapability("deviceName", deviceName);
    desiredCapabilities.setCapability("udid", deviceUDID);
    desiredCapabilities.setCapability("app", appLocation);
    desiredCapabilities.setCapability("useNewWDA", true);
    desiredCapabilities.setCapability("noReset", true);
    desiredCapabilities.setCapability("fullReset", false);
    // desiredCapabilities.setCapability("autoAcceptAlerts", true);
    desiredCapabilities.setCapability("newCommandTimeout", "0");



    String appiumURL = "http://" + hostName + ":" + portNumber + "/wd/hub";
    return new AppiumDriver<MobileElement>(new URL(appiumURL),
        desiredCapabilities);
  }
}
