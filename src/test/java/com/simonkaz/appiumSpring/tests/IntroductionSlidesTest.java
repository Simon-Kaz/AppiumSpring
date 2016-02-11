package com.simonkaz.appiumSpring.tests;

import com.simonkaz.appiumSpring.config.DriverConfig;
import com.simonkaz.appiumSpring.pages.IntroductionPage;
import com.simonkaz.appiumSpring.pages.MainPage;
import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DriverConfig.class})
public class IntroductionSlidesTest extends BaseTest {

    @Autowired
    AppiumDriver driver;

    @Autowired
    private IntroductionPage introductionPage;

    @Autowired
    private MainPage mainPage;

    @Test
    public void introductionSlidesVerification() {
        introductionPage.tapStartBrowsingButton();
        mainPage.verifyShowTabsButtonIsDisplayed();
    }
}
