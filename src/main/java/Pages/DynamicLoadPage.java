package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicLoadPage {

    public SelenideElement startButton(){
        return $x("//button[text()=\"Start\"]");
    }
    public SelenideElement loading(){
        return $x("//div[@id=\"loading\"]");
    }
    public SelenideElement finish(){
        return $x("//div[@id=\"finish\"]");
    }



}
