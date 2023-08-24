package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FindResult_page {

    public static SelenideElement searchResultMessage = $x("//h1[@class=\"bloko-header-section-3\"]");

    public String checkMSG(){
        searchResultMessage.isDisplayed();
        String result = searchResultMessage.getText();
        return result;
    }

}
