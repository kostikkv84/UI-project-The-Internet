package The_Internet_Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckboxesPage {
    public CheckboxesPage() {
        $x("//h3[contains(text(),\"Checkboxes\")]").shouldBe(visible);
    }

    public SelenideElement header () {
        return $x("//h3[contains(text(),\"Checkboxes\")]");
    }
    public SelenideElement checkbox1 = $x("//form[@id=\"checkboxes\"]//input[1]");

    public SelenideElement checkbox2 = $x("//form[@id=\"checkboxes\"]//input[2]");

    public void checkboxesClick(){
        for(SelenideElement element: $$("#checkboxes input")){
            element.shouldBe(visible).click();
        }
    }

}
