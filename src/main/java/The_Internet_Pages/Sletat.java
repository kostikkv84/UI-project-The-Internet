package The_Internet_Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Sletat {
    public Sletat() {
        open("https://debug.sletat.ru/");
        sleep(3000);
    }

    SelenideElement logo = $x("//a[@class=\"site-logo header__site-logo\"]");

    public Boolean logoIsVisible(){

        logo.shouldBe(Condition.visible);
        return true;
    }

}

