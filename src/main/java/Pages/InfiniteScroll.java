package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.security.Key;

import static com.codeborne.selenide.Selenide.*;

public class InfiniteScroll {
    public InfiniteScroll() {
        open("https://the-internet.herokuapp.com/infinite_scroll");
      //  $("//div[@class=\"jscroll-added\"][3]").shouldNotBe(Condition.visible);
    }

    public SelenideElement h3 = $("h3");
    private SelenideElement elem = $x("//div[@class=\"jscroll-added\"][2]");
    public SelenideElement elem3 = $x("//div[@class=\"jscroll-added\"][3]");
    public void scrollDown () {

        actions().moveToElement(elem).build().perform();
        actions().sendKeys(Keys.PAGE_DOWN).build().perform();
       // actions().scrollToElement(div5).perform();
    }



}
