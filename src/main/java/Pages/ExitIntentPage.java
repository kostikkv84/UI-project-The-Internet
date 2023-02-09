package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ExitIntentPage {
        public static SelenideElement bodyPage = $x ("//body");

        public static SelenideElement modalWindow = $x("//div[@class=\"modal\"]");

        public static SelenideElement modalCloseBtn = $x("//div[@class=\"modal-footer\"]/p");

}
