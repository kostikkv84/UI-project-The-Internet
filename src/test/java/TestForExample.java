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



}
