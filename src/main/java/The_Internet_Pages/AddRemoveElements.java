package The_Internet_Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AddRemoveElements {

    public AddRemoveElements() { // при загрузке страницы проверим наличие тега h3 (страница загрузилась)
        $x("//h3[text()=\"Add/Remove Elements\"]").shouldBe(exist);
    }

    public SelenideElement addButton = $x("//div[@class=\"example\"]//button");

    public SelenideElement deleteButton = $x("//button[@class=\"added-manually\"]");

    public ElementsCollection deleteButtons = $$x("//div[@id=\"elements\"]//button");

}
