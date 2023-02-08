import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


import static com.codeborne.selenide.Selenide.executeJavaScript;


public class BaseTest {
    public BaseTest() {
    }

    public void setUp(String PLATFORM_AND_BROWSER) {
        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();
                Configuration.browser = "chrome";
                break;
            case "win_firefox":
                WebDriverManager.firefoxdriver().setup();
                Configuration.browser = "firefox";
                break;
            default:
                Assert.isTrue(false, "Incorrect platform");
        }
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.fastSetValue=true;
    }


    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterMethod
    public void timeTestResult(ITestResult result){
        long a = result.getEndMillis()-result.getStartMillis();
        System.out.println("Время, затраченное на выполнение теста:"+a+" миллисекунды");
    }

    @AfterTest
    public void teardown(){
        Selenide.closeWebDriver();
    }

    public void delay(Integer timeToDelay) {
        try {
            Thread.sleep((long) timeToDelay);
        } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
        }
    }
}
