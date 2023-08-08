import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.remote.MobileBrowserType;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.net.MalformedURLException;

public class TestsMobile extends BaseTest{


    /**
     * Пример теста запускаемого на android с использованием файбричного метода.
     */
    @Test
    @Ignore
    public void testAndroid() throws MalformedURLException {
        WebDriver driver = BaseTest.setUpMobile("android");
        WebElement signButton = driver.findElement(new AppiumBy.ByAndroidUIAutomator("signIn"));
        Assert.assertTrue(signButton.isDisplayed());
    }

    /**
     * Пример теста запускаемого на ios с использованием файбричного метода.
     */
    @Test
    @Ignore
    public void testIOS() throws MalformedURLException {
        WebDriver driver = BaseTest.setUpMobile("ios");
  //      WebElement signButton = driver.findElement(MobileBy.IosUIAutomations("signIn"));
   //     Assert.assertTrue(signButton.isDisplayed());
    }
}
