package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class SliderPage {
    public static SelenideElement slider = $x("//input[@type=\"range\"]");
    public static SelenideElement count = $("#range");

    public static void slideRight(){
        slider.click();
        slider.sendKeys(Keys.ARROW_RIGHT);
    }
    public static void slideLeft(){
        slider.click();
        for(int i = 0; i<=3; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
    }
}
