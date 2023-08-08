package The_Internet_Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ContextMenuPage {
    public ContextMenuPage() {
//        $x("//a[text()=\"Context Menu\"]").shouldBe(visible);
    }

    public SelenideElement contextElem(){
        return $("#hot-spot");

    }
}
