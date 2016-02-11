package com.simonkaz.appiumSpring.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected AppiumDriver driver;
    public WebDriverWait wait;
    static final long DEFAULT_EXPLICIT_WAIT = 30;
    static final long DEFAULT_IMPLICIT_WAIT = 10;
    public static TimeOutDuration duration = new TimeOutDuration(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS);


    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, duration), this);
        wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT);
    }

}
