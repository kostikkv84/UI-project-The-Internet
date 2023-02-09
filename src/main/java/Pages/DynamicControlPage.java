package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicControlPage {

    public SelenideElement buttonRemove() {
        return $x("//button[text()=\"Remove\"]");
    }
    public SelenideElement buttonAdd() {
        return $x("//button[text()=\"Add\"]");
    }
    public SelenideElement checkbox() {
        return $x("//div[@id=\"checkbox\"]");
    }
    public SelenideElement inputCheckbox() {
        return $x("//input[@id=\"checkbox\"]");
    }

    public static SelenideElement enabledBtn = $x("//button[text()=\"Enable\"]");

    public static SelenideElement disabledBtn = $x("//button[text()=\"Disable\"]");

    public static SelenideElement input = $x("//form[@id=\"input-example\"]/input");

    public DynamicControlPage addButtonClick(){
        buttonAdd().shouldBe(Condition.visible).click();
        return new DynamicControlPage();
    }
    public DynamicControlPage removeButtonClick(){
        buttonRemove().shouldBe(Condition.visible).click();
        return new DynamicControlPage();
    }


}
