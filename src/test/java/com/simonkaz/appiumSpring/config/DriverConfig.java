package com.simonkaz.appiumSpring.config;

import com.simonkaz.appiumSpring.profiles.Android;
import com.simonkaz.appiumSpring.profiles.IOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@ComponentScan(basePackages = {"com.simonkaz.appiumSpring.configuration", "com.simonkaz.appiumSpring.tests", "com.simonkaz.appiumSpring.util", "com.simonkaz.appiumSpring.pages"})
public class DriverConfig {

    private static String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
    private static String SAUCE_KEY = System.getenv("SAUCE_KEY");

    @Bean(destroyMethod = "quit")
    @Android
    public AppiumDriver androidAppiumDriver() throws MalformedURLException {

        AppiumDriver driver = null;

        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability("build","Appium Spring Cucumber JVM Test Suite");
        capabilities.setCapability("name", "Android");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S4 Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.APP, "sauce-storage:ApiDemos-debug.apk");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/szymonk/Desktop/Firefox.apk");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "org.mozilla.firefox");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".App");
        capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, ".App");
        capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT, 40);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.4.16");
        //capabilities.setCapability("fullReset", true);
        capabilities.setCapability("noSign", true);
        capabilities.setCapability("deviceOrientation", "portrait");

//        driver = new AndroidDriver(new URL("http://" + SAUCE_USERNAME + ":" + SAUCE_KEY + "@ondemand.saucelabs.com:80/wd/hub")
//                ,capabilities);
        driver = new AndroidDriver(new URL("http://127.0.0.1:5000/wd/hub"), capabilities);

        return driver;
    }

    @Bean(destroyMethod = "quit")
    @IOS
    public AppiumDriver iosAppiumDriver() throws MalformedURLException {

        AppiumDriver driver = null;

        DesiredCapabilities capabilities = DesiredCapabilities.iphone();
        capabilities.setCapability("build", "Appium Spring Cucumber JVM Test Suite");
        capabilities.setCapability("name", "iOS");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//        capabilities.setCapability(MobileCapabilityType.APP, "sauce-storage:UICatalog.zip");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/szymonk/Desktop/FirefoxClient.app");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
        capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT, 60);
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("appiumVersion", "1.4.16");
        capabilities.setCapability("sendKeyStrategy", "setValue"); //fastest typing method
        //capabilities.setCapability("fullReset", true);
        //capabilities.setCapability("autoLaunch", "false");
        //capabilities.setCapability("noReset", true); //to reuse the simulator/installed app between tests, rather than restart it for each test

//        driver = new IOSDriver(new URL("http://" + SAUCE_USERNAME + ":" + SAUCE_KEY + "@ondemand.saucelabs.com:80/wd/hub")
//                , capabilities);
        driver = new IOSDriver(new URL("http://127.0.0.1:5000/wd/hub"), capabilities);
        return driver;
    }
}