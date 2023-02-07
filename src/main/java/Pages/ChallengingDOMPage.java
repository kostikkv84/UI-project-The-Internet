package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ChallengingDOMPage {
    public SelenideElement baz(){
        return $x("//a[@class=\"button\"]");
    }
    public ChallengingDOMPage bazClick(){
        $x("//a[@class=\"button\"]").shouldBe(visible).click();
        return this;
    }
    public ChallengingDOMPage quxClick(){
        $x("//a[@class=\"button alert\"]").shouldBe(visible).click();
        return new ChallengingDOMPage();
    }
    public ChallengingDOMPage fooClick(){
        $x("//a[@class=\"button success\"]").shouldBe(visible).click();
        return new ChallengingDOMPage();
    }
}
