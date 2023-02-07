package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class DropDownPage {


    public DropDownPage(String url) {
        Selenide.open(url);
    }

    public SelenideElement dropDownHeader() {
        return $x("//h3[text()=\"Dropdown List\"]");
    }
    public SelenideElement select(){
        return $x("//select[@id=\"dropdown\"]");
    }
    public SelenideElement option1() {
        return $x("//option[@value=\"1\"]");
    }
    public SelenideElement option2() {
        return $x("//option[@value=\"2\"]");
    }

    public void selectOption(SelenideElement element){
        element.click();
    }

}
