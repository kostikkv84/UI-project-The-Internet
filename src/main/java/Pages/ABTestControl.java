package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ABTestControl {


    public SelenideElement text () {
       return  $x("//div[@class=\"example\"]//p");
    }
}
