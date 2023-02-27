package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ScriptAlertsPage {
    public SelenideElement alertBtn = $x("//button[@onclick=\"jsAlert()\"]");

    public SelenideElement alertClickedMsg = $("#result");


}
