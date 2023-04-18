import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeOptions;
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
            case "win_firefox":
                WebDriverManager.firefoxdriver().driverVersion("0.32.1").setup();
                Configuration.browser = "firefox";
                System.setProperty("firefoxprofile.dom.webnotifications.serviceworker.enabled", "false");
                System.setProperty("firefoxprofile.dom.webnotifications.enabled", "false");
                System.setProperty("firefoxprofile.geo.enabled", "true");
                break;
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
              //  WebDriverManager.chromedriver().setup();
                Configuration.browser = "chrome";
                Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito");
                Configuration.browserCapabilities = new ChromeOptions().addArguments("--disable-notifications");
                break;
            default:
                Assert.isTrue(false, "Incorrect platform");
        }
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.fileDownload = FileDownloadMode.FOLDER; // настройка для загрузки файлов - download()
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
