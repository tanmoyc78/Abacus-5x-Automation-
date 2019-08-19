package com.abacus.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class GenericUtility {

  public static AppiumDriver<MobileElement> driver;
  final static Logger logger = LoggerFactory.getLogger(GenericUtility.class);


  public static void verifyScreenTitle(String screenTitle) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    try {
      wait.until(ExpectedConditions.visibilityOf(
          driver.findElement(By.xpath("//*[@value='" + screenTitle + "']"))));
      Assert.assertEquals(driver
          .findElement(By.xpath("//*[@value='" + screenTitle + "']")).getText(),
          screenTitle);
      Reporter.log("Verified screen title as " + screenTitle);
    } catch (Exception e) {
      Reporter.log("Screen title is not matching");
    }
  }

  public static boolean doesElementPresent(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    try {
      WebElement waitElement =
          wait.until(ExpectedConditions.visibilityOf(element));
      if (waitElement.isDisplayed())
        Reporter.log(element.getText() + " : element is present");
      return true;
    } catch (Exception e) {
      Reporter.log(element.getText() + " : element not found");
      return false;
    }

  }

  public static void waitTill(int value) {
    try {
      Thread.sleep(value);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static String randomIdentifier() {
    final String lexicon = "abcdefghijklmnopqrstuvwxyz";;
    final java.util.Random rand = new java.util.Random();
    // consider using a Map<String,Boolean> to say whether the identifier is being
    // used or not
    final Set<String> identifiers = new HashSet<String>();
    StringBuilder builder = new StringBuilder();
    while (builder.toString().length() == 0) {
      int length = rand.nextInt(5) + 5;
      for (int i = 0; i < length; i++) {
        builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
      }
      if (identifiers.contains(builder.toString())) {
        builder = new StringBuilder();
      }
    }
    return builder.toString();
  }

  /**
   * method verify whether element is present on screen
   *
   * @param targetElement element to be present
   * @return true if element is present else throws exception
   * @throws InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,
   *         and the thread is interrupted, either before or during the activity.
   */
  public Boolean isElementPresent(By targetElement)
      throws InterruptedException {
    Boolean isPresent = driver.findElements(targetElement).size() > 0;
    return isPresent;
  }

  /**
   * method to hide keyboard
   */
  public void hideKeyboard() {
    driver.hideKeyboard();
  }

  /**
   * method to wait for an element to be visible
   *
   * @param targetElement element to be visible
   * @return true if element is visible else throws TimeoutException
   */
  public boolean waitForVisibility(By targetElement) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
      return true;
    } catch (TimeoutException e) {
      System.out.println("Element is not visible: " + targetElement);
      throw new TimeoutException(e.getMessage());

    }
  }

  /**
   * method to wait for an element until it is invisible
   *
   * @param targetElement element to be invisible
   * @return true if element gets invisible else throws TimeoutException
   */
  public boolean waitForInvisibility(By targetElement) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(
          ExpectedConditions.invisibilityOfElementLocated(targetElement));
      return true;
    } catch (TimeoutException e) {
      System.out.println("Element is still visible: " + targetElement);
      System.out.println();
      System.out.println(e.getMessage());
      throw new TimeoutException();

    }
  }

  /**
   * method to tap on the screen on provided coordinates
   *
   * @param xPosition x coordinate to be tapped
   * @param yPosition y coordinate to be tapped
   */
  public void tap(double xPosition, double yPosition) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HashMap<String, Double> tapObject = new HashMap<String, Double>();
    tapObject.put("startX", xPosition);
    tapObject.put("startY", yPosition);
    js.executeScript("mobile: tap", tapObject);
  }

  /**
   * method to find an element
   *
   * @param locator element to be found
   * @return WebElement if found else throws NoSuchElementException
   */
  public WebElement findElement(By locator) {
    try {
      WebElement element = driver.findElement(locator);
      return element;
    } catch (NoSuchElementException e) {
      logger.error("Element not found" + locator);
      throw new NoSuchElementException(e.getMessage());
    }
  }

  /**
   * method to find all the elements of specific locator
   *
   * @param locator element to be found
   * @return return the list of elements if found else throws NoSuchElementException
   */
  public List<MobileElement> findElements(By locator) {
    try {
      List<MobileElement> element = driver.findElements(locator);
      return element;
    } catch (NoSuchElementException e) {
      logger.error("element not found" + locator);
      throw new NoSuchElementException(e.getMessage());
    }
  }

  /**
   * method to get message test of alert
   *
   * @return message text which is displayed
   */
  public String getAlertText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      return alertText;
    } catch (NoAlertPresentException e) {
      throw new NoAlertPresentException();
    }
  }

  /**
   * method to verify if alert is present
   *
   * @return returns true if alert is present else false
   */
  public boolean isAlertPresent() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.alertIsPresent());
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      throw new NoAlertPresentException();
    }
  }

  /**
   * method to Accept Alert if alert is present
   */

  public void acceptAlert() {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();
  }

  /**
   * method to Dismiss Alert if alert is present
   */

  public void dismissAlert() {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().dismiss();
  }


  /**
   * method to set the context to required view.
   *
   * @param context view to be set
   */
  public void setContext(String context) {

    Set<String> contextNames = (driver).getContextHandles();

    if (contextNames.contains(context)) {
      (driver).context(context);
      logger.info("Context changed successfully");
    } else {
      logger.info(context + "not found on this page");
    }

    logger.info("Current context" + (driver).getContext());
  }

  /**
   * method to long press on specific element by passing locator
   *
   * @param locator element to be long pressed
   */
  public void longPress(By locator) {
    try {
      WebElement element = driver.findElement(locator);

      TouchAction touch = new TouchAction((MobileDriver) driver);
      LongPressOptions longPressOptions = new LongPressOptions();
      longPressOptions.withElement(ElementOption.element(element));
      touch.longPress(longPressOptions).release().perform();
      logger.info("Long press successful on element: " + element);
    } catch (NoSuchElementException e) {
      logger.error("Element not found" + locator);
      throw new NoSuchElementException(e.getMessage());
    }

  }

  /**
   * method to long press on specific x,y coordinates
   *
   * @param x x offset
   * @param y y offset
   */
  public void longPress(int x, int y) {
    TouchAction touch = new TouchAction((MobileDriver) driver);
    PointOption pointOption = new PointOption();
    pointOption.withCoordinates(x, y);
    touch.longPress(pointOption).release().perform();
    logger.info(
        "Long press successful on coordinates: " + "( " + x + "," + y + " )");

  }

  /**
   * method to long press on element with absolute coordinates.
   *
   * @param locator element to be long pressed
   * @param x x offset
   * @param y y offset
   */
  public void longPress(By locator, int x, int y) {
    try {
      WebElement element = driver.findElement(locator);
      TouchAction touch = new TouchAction((MobileDriver) driver);
      LongPressOptions longPressOptions = new LongPressOptions();
      longPressOptions.withPosition(new PointOption().withCoordinates(x, y))
          .withElement(ElementOption.element(element));
      touch.longPress(longPressOptions).release().perform();
      logger.info("Long press successful on element: " + element
          + "on coordinates" + "( " + x + "," + y + " )");
    } catch (NoSuchElementException e) {
      logger.error("Element not found" + locator);
      throw new NoSuchElementException(e.getMessage());
    }

  }

  /**
   * method to swipe on the screen on provided coordinates
   *
   * @param startX - start X coordinate to be tapped
   * @param endX - end X coordinate to be tapped
   * @param startY - start y coordinate to be tapped
   * @param endY - end Y coordinate to be tapped
   * @param duration duration to be tapped
   */

  public void swipe(double startX, double startY, double endX, double endY,
      double duration) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HashMap<String, Double> swipeObject = new HashMap<String, Double>();
    // swipeObject.put("touchCount", 1.0);
    swipeObject.put("startX", startX);
    swipeObject.put("startY", startY);
    swipeObject.put("endX", endX);
    swipeObject.put("endY", endY);
    swipeObject.put("duration", duration);
    js.executeScript("mobile: swipe", swipeObject);
  }

  static String UiScrollable(String uiSelector) {
    return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
        + uiSelector + ".instance(0));";
  }


  /**
   * method to launchApp
   */

  public void launchApp() {
    (driver).launchApp();
  }

  /**
   * method to click on Element By Name
   *
   * @param elementByName - String element name to be clicked
   */

  public void click(String elementByName) {
    (driver).findElementByName(elementByName).click();
  }

  /**
   * method to scroll down on screen from java-client 6
   *
   * @param swipeTimes number of times swipe operation should work
   * @param durationForSwipe time duration of a swipe operation
   */
  public void scrollDown(int swipeTimes, int durationForSwipe) {
    Dimension dimension = driver.manage().window().getSize();

    for (int i = 0; i <= swipeTimes; i++) {
      int start = (int) (dimension.getHeight() * 0.5);
      int end = (int) (dimension.getHeight() * 0.3);
      int x = (int) (dimension.getWidth() * .5);

      new TouchAction(driver).press(PointOption.point(x, start))
          .moveTo(PointOption.point(x, end))
          .waitAction(
              WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
          .release().perform();
    }
  }

  /**
   * method to scroll up on screen from java-client 6
   *
   * @param swipeTimes number of times swipe operation should work
   * @param durationForSwipe time duration of a swipe operation
   */
  public void scrollUp(int swipeTimes, int durationForSwipe) {
    Dimension dimension = driver.manage().window().getSize();

    for (int i = 0; i <= swipeTimes; i++) {
      int start = (int) (dimension.getHeight() * 0.3);
      int end = (int) (dimension.getHeight() * 0.5);
      int x = (int) (dimension.getWidth() * .5);

      new TouchAction(driver).press(PointOption.point(x, start))
          .moveTo(PointOption.point(x, end))
          .waitAction(
              WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
          .release().perform();
    }
  }

}
