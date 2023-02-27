package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SliderPage {
    public static SelenideElement slider = $(".sliderContainer");

    public static void slideRight(){
        actions().clickAndHold(slider).moveByOffset(1000, 0).perform();
      //  actions().dragAndDropBy(slider, 100, 0).perform();

    }
}
