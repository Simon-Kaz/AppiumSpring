package com.simonkaz.appiumSpring.tests;

import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.support.AbstractTestExecutionListener;

@Component
public class BaseTest extends AbstractTestExecutionListener {

    @Autowired
    AppiumDriver driver;

//    @Override
//    public void afterTestMethod(TestContext testContext) throws Exception {
//        System.out.println("After test method");
//        if (testContext.getTestException() == null) {
//            return;
//        }
//
//        File screenshot = driver.getScreenshotAs(OutputType.FILE);
//        String testName = toLowerUnderscore(testContext.getTestClass().getSimpleName());
//        String methodName = toLowerUnderscore(testContext.getTestMethod().getName());
//
//        Files.copy(screenshot.toPath(),
//                Paths.get("screenshots", testName + "_" + methodName + "_" + screenshot.getName()));
//    }
//
//    @Override
//    public void afterTestClass(TestContext testContext) throws Exception {
//        System.out.println("After test class");
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
