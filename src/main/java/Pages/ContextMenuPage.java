package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ContextMenuPage {
    public ContextMenuPage() {
//        $x("//a[text()=\"Context Menu\"]").shouldBe(visible);
    }

    public SelenideElement contextElem(){
        return $("#hot-spot");

    }
}
