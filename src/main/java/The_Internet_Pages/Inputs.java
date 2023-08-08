package The_Internet_Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class Inputs {
    public Inputs() {
        open("https://the-internet.herokuapp.com/inputs");
    }

    public SelenideElement input = $("input");

    public void numberPlus () {
        input.click();
        for (int i = 0; i < 6; i++){
            input.sendKeys(Keys.ARROW_UP);
        }
    }

    public void numberMinus () {
        input.click();
        int a = 0;
        while (a < 8) {
            input.sendKeys(Keys.ARROW_DOWN);
            a++;
        }
    }

}
