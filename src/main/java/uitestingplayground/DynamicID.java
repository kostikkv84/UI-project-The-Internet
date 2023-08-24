package uitestingplayground;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicID {
    SelenideElement button = $x("//h4[contains(text(),'Playground')]/following-sibling::button");
    

}
