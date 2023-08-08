import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.executeJavaScript;


public class BaseTest {
    public BaseTest() {
    }

    /**
     * Пример фабрики для запуска тестов с нужным Webdriver - android, ios или windows.
     * @param platform
     * @return
     * @throws MalformedURLException
     */
    public static WebDriver setUpMobile(String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platform.equalsIgnoreCase("android")) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
            AndroidDriver driver = new AndroidDriver(new URL("https://ya.ru"), capabilities);
            WebDriverRunner.setWebDriver(driver);
            return driver;
        } else if (platform.equalsIgnoreCase("ios")) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
            IOSDriver driver = new IOSDriver(new URL("https://ya.ru"), capabilities);
            WebDriverRunner.setWebDriver(driver);
            return driver;
        } else if (platform.equalsIgnoreCase("windows")) {
            Configuration.browserSize = "1920x1080";
            Configuration.screenshots = true;
            return WebDriverRunner.getWebDriver();
        }
        throw new IllegalArgumentException("Unknown mobile platform - " + platform);
    }

    /**
     * Установка нужного браузера для запуска тестов
     * @param PLATFORM_AND_BROWSER
     */
    public void setUp(String PLATFORM_AND_BROWSER) {
        switch (PLATFORM_AND_BROWSER) {
            case "win_firefox":
                // Настройка WebDriverManager для автоматической загрузки и установки GeckoDriver
                WebDriverManager.firefoxdriver().setup();
                // Настройка Selenide для использования GeckoDriver
                Configuration.browser = "firefox";
                System.setProperty("firefoxprofile.dom.webnotifications.serviceworker.enabled", "false");
                System.setProperty("firefoxprofile.dom.webnotifications.enabled", "false");
                System.setProperty("firefoxprofile.geo.enabled", "true");
                break;
            case "win_chrome":
                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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
       // Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.screenshots = true;
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

    public void delay(Integer timeToDelay) {
        try {
            Thread.sleep((long) timeToDelay);
        } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
        }
    }
}
