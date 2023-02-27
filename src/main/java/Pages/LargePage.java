package Pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class LargePage {

    public static ElementsCollection listSibling = $$x("//div[contains(@id,\"sibling-\")]");


}
