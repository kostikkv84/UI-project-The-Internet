package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class KeysPressedPage {

    public final SelenideElement inputField = $("#target");
    public final SelenideElement resultField = $("#result");


    public void inputsLettersKeys() {
        String[] myStringArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u"
                , "v", "w", "q", "x", "y", "z"};
        for (String keys : myStringArray) {
            inputField.sendKeys(keys);
            resultField.shouldHave(Condition.text("You entered: " + keys));
            System.out.println("You entered: " + keys);
        }
    }

    public void altPressed() {
            inputField.shouldBe(Condition.visible).click();
            inputField.sendKeys(Keys.ALT);
            resultField.shouldHave(Condition.text("You entered: ALT"));
            System.out.println(resultField.getText());

    }
}
