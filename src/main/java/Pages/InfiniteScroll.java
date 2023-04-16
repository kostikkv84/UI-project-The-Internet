package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class InfiniteScroll {
    public InfiniteScroll() {
        open("https://the-internet.herokuapp.com/infinite_scroll");
    }

    public SelenideElement h3 = $("h3");
    private SelenideElement infiniteDiv = $x("//div[contains(text(),'Id labore aut autem iure ab ')]");
    private SelenideElement div5 = $x("//div[@class=\"jscroll-inner\"]/div[5]");
    public void scrollDown () {
        //actions().scrollToElement(infiniteDiv);
      //  actions().scrollToElement(div5);
        actions().scrollByAmount(100,3000).perform();
       // actions().scrollToElement(div5).perform();
    }

}
