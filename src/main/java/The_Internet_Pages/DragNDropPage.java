package The_Internet_Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DragNDropPage {

    public SelenideElement elemA () {
        return $("#column-a");
    }
    public SelenideElement elemB () {
        return $("#column-b");
    }
    public SelenideElement elemHeader= $x("//div[@id=\"column-a\"]//header");


    public DragNDropPage dragNDropActions(){
        elemA().shouldBe(Condition.visible).dragAndDropTo(elemB());
        return this;
    }

}
