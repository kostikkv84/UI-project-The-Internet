package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasicAuthPage {

    public SelenideElement congratulations = $(".example p");

    public BasicAuthPage() {
        Selenide.open("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

}
