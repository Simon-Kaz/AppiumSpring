package com.simonkaz.appiumSpring.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertFalse;

@Component
public class MainPage extends BasePage {

    @AndroidFindBy(id = "org.mozilla.firefox:id/tabs")
    @iOSFindBy(accessibility = "Show Tabs")
    private WebElement showTabsButton;

    @Autowired
    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public void switchToActivity(String activity){
        //switch to required activity
        ((AndroidDriver<WebElement>)driver).startActivity("io.appium.android.apis", activity);
    }

    public void verifyShowTabsButtonIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(showTabsButton));
        assertFalse(showTabsButton.isDisplayed());
    }
}
