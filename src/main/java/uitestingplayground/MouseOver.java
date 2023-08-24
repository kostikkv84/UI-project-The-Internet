package uitestingplayground;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MouseOver {

    public SelenideElement clickMe = $x("//a[@title='Click me']");
    public SelenideElement clickMeActive = $x("//a[@title='Active Link']");
    public SelenideElement clickCount = $x("//span[@id='clickCount']");

    public int count (){
        int x = Integer.parseInt(clickCount.shouldBe(Condition.visible).getText());
        System.out.println(x);
        return x;
    }

}
