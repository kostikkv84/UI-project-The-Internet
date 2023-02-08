import Pages.*;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Constants.Constant.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseTest{

    /**
     * Проверка количества элементов на странице
     */
    @Test
    public void checkAvailableExamples(){
        setUp("win_chrome");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.availableExamples().shouldHave(CollectionCondition.size(44));
    }



    /**
     * Проверка перехода на страницу по линку
     */
    @Test
    public void checkLinkABTestControl () {
        setUp("win_chrome");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.abTestingLinkOpen().text().shouldHave(Condition.text("Also known as split testing. "));
    }

    /**
     * Проверка создания и удаления элемента
     * Нажимаем создать 4 раза - проверяем, что кнопок 4
     * Нажимаем удалить 1 раз - проверяем, что кнопок 3
     */
    @Test
    public void checkAddDeleteElem() {
        setUp("win_firefox");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.addRemoveLinkOpen();
        AddRemoveElements addRemoveElements = new AddRemoveElements();
        addRemoveElements.deleteButton().shouldNotBe(visible); // кнопки удалить нет
        for(int i=0; i<=3;i++){
            addRemoveElements.addButton().shouldBe(visible).click();        }
        addRemoveElements.deleteButtons().shouldBe(CollectionCondition.size(4));
        addRemoveElements.deleteButton().shouldBe(visible).click();
        addRemoveElements.deleteButtons().shouldBe(CollectionCondition.size(3));
    }

    /**
     * Проверка аутентификации через всплывающее окно
     */
    @Test
    public void baseAuth(){
        setUp("win_firefox");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.authPageLinkOpen().congratulations().shouldHave(Condition.text("Congratulations!"));
    }

    /**
     * Выводим список испорченных изображений.
     * для примера
     */
    @Test
    public void brokenImage(){
        setUp("win_chrome");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.brokenImageLinkOpen();
        BrokenImagePage brokenImages = new BrokenImagePage();
        for (SelenideElement image : brokenImages.images()) {
            brokenImages.isImageBroken(image);
        }
    }

    /**
     * Привязка к селекторам которые не меняются и манипуляции с ними.
     * id кнопок меняются.
     */
    @Test
    public void challengingDom(){
        setUp("win_chrome");
        new MainPage(BASE_URL).challengingDOMPageLinkOpen()
                .bazClick().quxClick().fooClick().baz().shouldBe(visible);
    }

    /**
     * Проверка нажатия на чекбоксы
     *
     */
    @Test
    public void checkboxesTest() {
        setUp("win_chrome");
        new MainPage(BASE_URL).checkboxesPageLinkOpen();
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.checkboxesClick();
        checkboxesPage.checkbox1().shouldBe(checked);
        checkboxesPage.checkbox2().shouldNotBe(checked);
        sleep(5000);


    }

    /**
     * Работа с Алертом по ПКМ (contextClick())
     */
    @Test
    public void context(){
        setUp("win_firefox");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.contextPageLinkOpen();
        ContextMenuPage contextMenuPage = new ContextMenuPage();
        contextMenuPage.contextElem().shouldBe(visible).contextClick();
        switchTo().alert().getText().contains("switchTo().alert().getText()"); // проверка текста алерта
        System.out.println(switchTo().alert().getText());
        switchTo().alert().accept(); // закрываем алерт
        sleep(1000);
    }

    /**
     * Исчезновение кнопки.
     */
    @Test
    public void disapElementTest(){
        setUp("win_chrome");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.disappearingElem();
        DisapElemPage disapElempage = new DisapElemPage();
        disapElempage.homeBtn().shouldBe(visible).click();
        sleep(5000);
        disapElempage.homeBtn().shouldNotBe(visible);


    }

    /**
     * Перетаскиваем элемент, проверяем, что хедер первого элемента изменился.
     */
    @Test
    public void dragNDropTest(){
        setUp("win_chrome");
        new MainPage(BASE_URL).dragNDropLinkOpen()
                .dragNDropActions()
                .elemHeader()
                .getText().equals("B");
    }

    /**
     * Выбор option из select. Проверка аттрибута selected при выборе option
     */
    @Test
    public void dropDownMenuTest(){
        setUp("win_chrome");
        DropDownPage dropDown = new DropDownPage(DROPDOWN_URL);
        dropDown.dropDownHeader().shouldBe(visible);
        dropDown.selectOption(dropDown.option1());
        dropDown.option1().shouldHave(attribute("selected"));
        dropDown.selectOption(dropDown.option2());
        dropDown.option2().shouldHave(attribute("selected"));
        dropDown.option1().shouldNotHave(attribute("selected"));
    }

    @Test
    public void changeContentTest(){
        open("http://the-internet.herokuapp.com/dynamic_content");
        DynamicContentPage dynamicContent = new DynamicContentPage();
        String image = dynamicContent.divImage().getAttribute("src");
        String getText = dynamicContent.divText().getText();
        dynamicContent.changeContent().click(); // нажимаем сменить контент
        Assert.assertNotEquals(dynamicContent.divImage().getAttribute("src"),image);
        Assert.assertNotEquals(dynamicContent.divText().getText(),getText);
        sleep(5000);
    }

    /**
     * Кнопка удаляет чекбокс, проверяет удаление
     * Кнопка меняется и добавляет новый чекбокс
     * Проверяется создание нового чекбокса
     */
    @Test
    public void dynamicControlsDelAddText(){
        open("http://the-internet.herokuapp.com/dynamic_controls");
        DynamicControlPage dynamicPage = new DynamicControlPage();
        dynamicPage.checkbox().shouldBe(visible);
        dynamicPage.removeButtonClick().checkbox().shouldNotBe(visible); // с ожиданием
        dynamicPage.addButtonClick().inputCheckbox().shouldBe(visible);
        dynamicPage.inputCheckbox().shouldBe(visible);
    }

    /**
     * Нажимаем кнопку Enabled, разблокируется Input, вписываем текст
     * Проверяем, что кнопка изменилась Enabled -> Disabled
     * Нажимаем Disabled. кнопка меняется и Input добавляется атрибут "disabled"
     */
    @Test
    public void enabledDisabledTest(){
        open("http://the-internet.herokuapp.com/dynamic_controls");
        DynamicControlPage dynamic = new DynamicControlPage();
        dynamic.input().shouldHave(attribute("disabled"));
        dynamic.enabledBtn().shouldBe(visible).click();
        dynamic.input().shouldNotHave(attribute("disabled")).setValue("text123");
        dynamic.enabledBtn().shouldNotBe(visible);
        dynamic.disabledBtn().shouldBe(visible).click();
        dynamic.input().shouldHave(attribute("disabled"));
        dynamic.disabledBtn().shouldNotBe(visible);
        sleep(5000);
    }

    /**
     * Стартуем по кнопке, кнопка исчезает.
     * Дожидаемся завершения Loadingbar
     * Проверяем появление сообщения об успехе - "Hello World!"
     * @throws InterruptedException
     */
    @Test
    public void dynamicLoadOneTest() throws InterruptedException {
        Configuration.timeout = 10000;
        open("http://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicLoadPage dynamicPage = new DynamicLoadPage();
        dynamicPage.startButton().shouldBe(visible).click();
        dynamicPage.loading().shouldBe(visible);
        dynamicPage.loading().should(disappear);
        dynamicPage.finish().shouldBe(visible);
        dynamicPage.loading().shouldNotBe(visible);
        dynamicPage.startButton().shouldNotBe(visible);
    }

    @Test
    public void closeModalTest(){
        open("http://the-internet.herokuapp.com/entry_ad");
        EntryADPage adPage = new EntryADPage();
        adPage.modalClose();
        adPage.modalWindow().shouldNotBe(visible);

        sleep(3000);
    }

}
