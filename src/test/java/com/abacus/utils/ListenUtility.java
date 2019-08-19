package com.abacus.utils;


import com.abacus.test.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenUtility extends ExtentITestListenerClassAdapter {

    private static final Logger logger = LogManager.getLogger(ListenUtility.class);

    @Override
    public void onStart(ITestContext context) {
        super.onStart(context);
        logger.info(context.getSuite().getName() + " is being initiated.");
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        logger.info(result.getName() + " is being initiated.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        logger.info(result.getName() + " has been passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
      System.out.println("\n***** FAILED : "+result.getName()+" test has failed *****");
      String timestamp = new SimpleDateFormat("dd_MMM_yyyy_hh_mm").format(new Date());
      String methodName = result.getMethod().getMethodName();
        try {
            File scrFile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./screenshots/"+timestamp + "_" + methodName+".jpg"));
            System.out.println("***Placed screen shot in "+"/Users/arc/git/skysite_fna_ios_suite/screenshots/"+methodName+".jpg"+" ***\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest(result).skip(result.getThrowable());
        logger.fatal(result.getName() + " has been skipped!", result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        super.onFinish(context);
        logger.info(context.getSuite().getName() + " is being terminated.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        super.onTestFailedButWithinSuccessPercentage(result);
    }

}
