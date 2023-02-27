package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GeolocationPage {

    public SelenideElement geoButton = $x("//button");
    public SelenideElement latValue = $x("//div[@id=\"lat-value\"]");
    public SelenideElement longValue = $x("//div[@id=\"long-value\"]");


}
