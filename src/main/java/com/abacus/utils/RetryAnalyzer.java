package com.abacus.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {


  /**
   * Refer : https://confluence.pearson.com/confluence/display/LSSQE/Retry+Failed+tests - for how to
   * steps
   * 
   * Need to set 'MaxRetryCount','IncludeExceptions' and 'ExcludeExceptions' properties in config file
   * for this implementation
   * 
   * Eg: MaxRetryCount =2 IncludeExceptions =TimeoutException ExcludeExceptions =
   * NoSuchWindowException
   */
  private ResourceUtility resourceUtility = new ResourceUtility("config");
  private static Logger logger = LoggerFactory.getLogger(RetryAnalyzer.class);

  private int retriedCount = 0;
  private int maxRetryCount =
      Integer.parseInt(resourceUtility.getResource("MaxRetryCount"));

  // private List<String> includeExceptions = configProperty.hasProperty("IncludeExceptions") ?
  // Arrays.asList(configProperty.getProperty("IncludeExceptions").split("\\|")) : Arrays.asList();
  // private List<String> excludeExceptions = configProperty.hasProperty("ExcludeExceptions") ?
  // Arrays.asList(configProperty.getProperty("ExcludeExceptions").split("\\|")) : Arrays.asList();

  @Override
  public boolean retry(ITestResult result) {
    boolean isRetry = false;
    String exception = result.getThrowable().getClass().getSimpleName();
    if (retriedCount < maxRetryCount) {
      logger.debug(result.getName() + " failed with "
          + result.getThrowable().getClass().getName());
      logger.debug("Retrying " + result.getName() + " for '" + ++retriedCount
          + "' time");
      // ExtentReporter.setTestStatusAsSkip(result);
      isRetry = true;
    }
    return isRetry;
  }

}
