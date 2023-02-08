package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicContentPage {

    public SelenideElement changeContent(){
        return $x("//a[text()=\"click here\"]");
    }

    public SelenideElement divImage (){
        return $x("(//div[@class=\"large-2 columns\"]//img)[last()]");
    }

    public SelenideElement divText (){
        return $x("(//div[@class=\"large-10 columns\"])[last()]");
    }


}
