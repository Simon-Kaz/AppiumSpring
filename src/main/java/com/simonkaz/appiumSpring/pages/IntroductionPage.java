package com.simonkaz.appiumSpring.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class IntroductionPage extends BasePage {

    @AndroidFindBy(id = "org.mozilla.firefox:id/welcome_browse")
    @iOSFindBy(accessibility = "Start Browsing")
    private WebElement startBrowsingButton;

    @Autowired
    public IntroductionPage(AppiumDriver driver) {
        super(driver);
    }

    public void tapStartBrowsingButton(){
        wait.until(ExpectedConditions.visibilityOf(startBrowsingButton))
            .click();
    }
}
