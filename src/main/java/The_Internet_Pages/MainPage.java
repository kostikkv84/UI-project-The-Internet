package The_Internet_Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage(String url) {
        Selenide.open(url);
    }

    public ElementsCollection availableExamples() {
        return $$("#content li"); // список элементов меню главной страницы
    }

    /**
     * Переход на страницу A/B Testing
     * @return
     */
    public ABTestControl abTestingLinkOpen() {
        $x("//div[@id=\"content\"]//a[text()=\"A/B Testing\"]").shouldBe(visible).click();
        return new ABTestControl();
    }

    /**
     * Переход на страницу Add/delete element
     * @return
     */
    public AddRemoveElements addRemoveLinkOpen(){
        $x("//div[@id=\"content\"]//a[text()=\"Add/Remove Elements\"]").shouldBe(visible).click();
        return new AddRemoveElements();
    }
    /**
     * Переход на страницу BasicAuthPage
     * @return
     */
    public BasicAuthPage authPageLinkOpen(){
        $x("//div[@id=\"content\"]//a[@href=\"/basic_auth\"]").shouldBe(visible).click();
        return new BasicAuthPage();
    }

    public BrokenImagePage brokenImageLinkOpen() {
        $x("//div[@id=\"content\"]//a[text()=\"Broken Images\"]").shouldBe(visible).click();
        return new BrokenImagePage();
    }

    public ChallengingDOMPage challengingDOMPageLinkOpen() {
        $x("//div[@id=\"content\"]//a[text()=\"Challenging DOM\"]").shouldBe(visible).click();
        return new ChallengingDOMPage();
    }

    public CheckboxesPage checkboxesPageLinkOpen() {
        $x("//div[@id=\"content\"]//a[text()=\"Checkboxes\"]").shouldBe(visible).click();
        return new CheckboxesPage();
    }
    public ContextMenuPage contextPageLinkOpen() {
        $x("//div[@id=\"content\"]//a[text()=\"Context Menu\"]").shouldBe(visible).click();
        return new ContextMenuPage();
    }

    public DisapElemPage disappearingElem() {
        $x("//div[@id=\"content\"]//a[text()=\"Disappearing Elements\"]").shouldBe(visible).click();
        return new DisapElemPage();
    }

    public DragNDropPage dragNDropLinkOpen() {
        $x("//div[@id=\"content\"]//a[text()=\"Drag and Drop\"]").shouldBe(visible).click();
        return new DragNDropPage();
    }
}
