package The_Internet_Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EntryADPage {

    public SelenideElement modalWindow = $x("//div[@class=\"modal\"]");

    public void modalClose(){
        $x("//div[@class=\"modal-footer\"]/p").shouldBe(Condition.visible).click();
    }
}
