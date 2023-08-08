import The_Internet_Pages.Sletat;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestForExample extends BaseTest{

    @Test
    @Ignore
    public void testFirefoxSetUp(){
        setUp("win_firefox");
        Selenide.open("https://e.mail.ru");
    }

    @Test
    @Ignore
    public void testChromeSetUp(){
        setUp("win_chrome");
        Selenide.open("https://e.mail.ru");
        Selenide.closeWebDriver();
    }


    @Test (invocationCount=200)
    @Ignore
    public void openDebugSletat (){
        setUp("win_chrome");
        Sletat sletat = new Sletat();
        Assert.assertTrue(sletat.logoIsVisible());
    }

}
