package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class HH {

    static SelenideElement search = $x("//input[@id=\"a11y-search-input\"]");
    static SelenideElement findBTN = $x("//div[@class=\"supernova-search-group\"]//button");

    public HH(String url) {
        Selenide.open(url);
        search.isDisplayed();
    }

    public FindResult_page checkFind (String findText){
        search.shouldBe(Condition.visible).setValue(findText);
        findBTN.shouldBe(Condition.visible).click();
      //  Assert.assertEquals(findText);
        return new FindResult_page();
    }


}
