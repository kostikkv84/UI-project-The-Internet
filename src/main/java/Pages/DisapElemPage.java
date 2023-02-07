package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DisapElemPage {

    public SelenideElement homeBtn(){
        return $x("//a[text()=\"Home\"]");
    }
}
