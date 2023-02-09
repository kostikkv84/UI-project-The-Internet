package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ChallengingDOMPage {
    public static SelenideElement baz = $x("//a[@class=\"button\"]");

    public static ElementsCollection buttons = $$x("//div[@class=\"large-2 columns\"]/a");
    public static SelenideElement bazClick = $x("//a[@class=\"button\"]");

    public static SelenideElement quxClick = $x("//a[@class=\"button alert\"]");

    public static SelenideElement fooClick = $x("//a[@class=\"button success\"]");

}
