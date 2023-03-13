import Pages.*;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

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
        setUp("win_firefox");
        new MainPage(BASE_URL).abTestingLinkOpen()
                .text.shouldHave(Condition.text("Also known as split testing. "));
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
        addRemoveElements.deleteButton.shouldNotBe(visible); // кнопки удалить нет
        for(int i=0; i<=3;i++){
            addRemoveElements.addButton.shouldBe(visible).click();        }
             addRemoveElements.deleteButtons.shouldBe(CollectionCondition.size(4));
            addRemoveElements.deleteButton.shouldBe(visible).click();
            addRemoveElements.deleteButtons.shouldBe(CollectionCondition.size(3));
    }

    /**
     * Проверка аутентификации через всплывающее окно
     */
    @Test
    public void baseAuth(){
        setUp("win_firefox");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.authPageLinkOpen().congratulations.shouldHave(Condition.text("Congratulations!"));
    }

    /**
     * Выводим список испорченных изображений.
     * для примера
     */
    @Test
    public void brokenImage(){
        setUp("win_firefox");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.brokenImageLinkOpen();
        BrokenImagePage brokenImages = new BrokenImagePage();
        for (SelenideElement image : brokenImages.images) {
            brokenImages.isImageBroken(image);
        }
    }

    /**
     * Нажимаем на кнопки по индексу в коллекции, id кнопок меняются.
     */
    @Test
    public void challengingDomExample1(){
        setUp("win_firefox");
        new MainPage(BASE_URL).challengingDOMPageLinkOpen();
        for(int i=0; i<ChallengingDOMPage.buttons.size();i++){
            ChallengingDOMPage.buttons.get(i).click();
        }
    }
    /**
     * Привязка к селекторам по Class.
     * id кнопок меняются.
     */
    @Test
    public void challengingDomExample2(){
        setUp("win_firefox");
        new MainPage(BASE_URL).challengingDOMPageLinkOpen();
        ChallengingDOMPage.bazClick.shouldBe(visible).click();
        ChallengingDOMPage.fooClick.shouldBe(visible).click();
        ChallengingDOMPage.quxClick.shouldBe(visible).click();
    }

    /**
     * Проверка нажатия на чекбоксы
     *
     */
    @Test
    public void checkboxesTest() {
        setUp("win_firefox");
        new MainPage(BASE_URL).checkboxesPageLinkOpen();
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.checkboxesClick();
        checkboxesPage.checkbox1.shouldBe(checked);
        checkboxesPage.checkbox2.shouldNotBe(checked);
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
        switchTo().alert().getText().contains("You selected a context menu"); // проверка текста алерта
        System.out.println(switchTo().alert().getText());
        switchTo().alert().accept(); // закрываем алерт
    }

    /**
     * Исчезновение кнопки.
     */
    @Test
    public void disapElementTest(){
        setUp("win_firefox");
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.disappearingElem();
        DisapElemPage disapElempage = new DisapElemPage();
        disapElempage.homeBtn.shouldBe(visible).click();
        sleep(5000);
        disapElempage.homeBtn.shouldNotBe(visible);
    }

    /**
     * Перетаскиваем элемент, проверяем, что хедер первого элемента изменился.
     */
    @Test
    public void dragNDropTest(){
        setUp("win_firefox");
        new MainPage(BASE_URL).dragNDropLinkOpen()
                .dragNDropActions();
        Assert.assertEquals(new DragNDropPage().elemHeader.getText(), "B");

    }

    /**
     * Выбор option из select. Проверка аттрибута selected при выборе option
     */
    @Test
    public void dropDownMenuTest(){
        setUp("win_firefox");
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
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/dynamic_content");
        DynamicContentPage dynamicContent = new DynamicContentPage();
        String image = dynamicContent.divImage().getAttribute("src");
        String getText = dynamicContent.divText().getText();
        dynamicContent.changeContent().click(); // нажимаем сменить контент
        Assert.assertNotEquals(dynamicContent.divImage().getAttribute("src"),image);
        Assert.assertNotEquals(dynamicContent.divText().getText(),getText);
        sleep(1000);
    }

    /**
     * Кнопка удаляет чекбокс, проверяет удаление
     * Кнопка меняется и добавляет новый чекбокс
     * Проверяется создание нового чекбокса
     */
    @Test
    public void dynamicControlsDelAddText(){
        setUp("win_firefox");
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
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/dynamic_controls");
        DynamicControlPage.input.shouldHave(attribute("disabled"));
        DynamicControlPage.enabledBtn.shouldBe(visible).click();
        DynamicControlPage.input.shouldNotHave(attribute("disabled")).setValue("text123");
        DynamicControlPage.enabledBtn.shouldNotBe(visible);
        DynamicControlPage.disabledBtn.shouldBe(visible).click();
        DynamicControlPage.input.shouldHave(attribute("disabled"));
        DynamicControlPage.disabledBtn.shouldNotBe(visible);
       // sleep(5000);
    }

    /**
     * Стартуем по кнопке, кнопка исчезает.
     * Дожидаемся завершения Loadingbar
     * Проверяем появление сообщения об успехе - "Hello World!"
     */
    @Test
    public void dynamicLoadOneTest() throws InterruptedException {
        setUp("win_firefox");
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

    /**
     * Закрываем всплывающий див при открытии старницы сайта
     */
    @Test
    public void closeModalTest(){
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/entry_ad");
        EntryADPage adPage = new EntryADPage();
        adPage.modalClose();
        adPage.modalWindow.shouldNotBe(visible);
        sleep(1000);
    }

    // !!!! доделать вывод курсора за пределы окна
    @Test
    public void modalIfCursorOutWindow() {
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/exit_intent");
        ExitIntentPage.bodyPage.shouldBe(visible);
        actions().moveByOffset(100,2000);
        sleep(5000);
    }
    
    @Test
    public void downloadXMLTest () throws FileNotFoundException {
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/download");
        File downloadedFile = DownloadPage.xmlFile.download(10000);
    }

    @Test
    public void downloadPDFTest () throws FileNotFoundException {
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/download");
        File downloadedFile = DownloadPage.pdfFile.download(10000);
    }
    @Test
    public void downloadPNGTest () throws FileNotFoundException {
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/download");
        File downloadedFile = DownloadPage.pngFile.download(10000);
    }
    @Test
    public void downloadTXTTest () throws FileNotFoundException {
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/download");
        File downloadedFile = DownloadPage.txtFile.download(10000);
    }

    /**
     * Upload file Test
     */
    @Test
    public void fileUploadTest(){
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/upload");
        UploadFilePage.uploadInput.uploadFile(new File("uploadFile.jpg"));
        UploadFilePage.button.click();
        UploadFilePage.uploadedMessage.shouldBe(visible).shouldHave(text("File Uploaded!"));
    }

    /**
     * Для примера. Удаление аттрибута Class(через JS) и проверка, что аттрибут удален.
     */
    @Test
    public void removeClassFromButton(){
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/upload");
        SCRIPTS_JS.removeClass();
        $("#file-submit").shouldNotHave(attribute("class", "button"));
    }

    /**
     * Скрол вниз страницы до футера, проверка, что закрепленное меню не ушло за экран после скрола.
     */
    @Test
    public void floatingMenuTest(){
        setUp("win_firefox");
        open("http://the-internet.herokuapp.com/floating_menu");
        FloatingPage.footer.scrollTo();
        FloatingPage.footer.shouldBe(visible).click();
        FloatingPage.menu.shouldBe(visible);
    }

    @Test
    public void wrongLoginTest(){
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/login");
        $("#username").setValue("login");
        $("#password").setValue("pass");
        $(".radius").click();
        $("#flash").shouldBe(visible).shouldHave(text("Your username is invalid!"));
        sleep(5000);
    }

    /**
     * new file - фрейм очищается при создании нового файла.
     */
    @Test
    public void iFramesNewFileTest(){
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/iframe");
        IFramePage iFramePage = new IFramePage();
        iFramePage.newFileBtn.click();
        iFramePage.newFile.click();
        switchTo().frame(iFramePage.iframe);
        iFramePage.textArea.shouldNotHave(text("Your content goes here."));
        sleep(3000);
    }

    /**
     * ДОДЕЛАТЬ! Требуется изменить текст в Frame и проверить, отмену действия.
     */
    @Test
    @Ignore
    public void iFramesUndoTest(){
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/iframe");
        IFramePage iFramePage = new IFramePage();
        iFramePage.changeTextFrame();
        iFramePage.textArea.shouldBe(empty);
        sleep(3000);
        switchTo().defaultContent();
        iFramePage.newEditBtn.click();

        iFramePage.newEditBtnUndo.click();
        iFramePage.textArea.shouldHave(text("Your content goes here."));

    }

    /**
     * Разобраться со всплывающим разрешением доступа к Геолокации в браузере
     */
    @Test
    @Ignore
    public void geoTest(){
        setUp("win_chrome");
        open("https://the-internet.herokuapp.com/geolocation");
        GeolocationPage geo = new GeolocationPage();
            geo.geoButton.click();
        sleep(3000);
        geo.latValue.shouldBe(exist);
        geo.longValue.shouldHave(text("34."));

    }

    @Test
    public void alertTest() {
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/javascript_alerts");
        ScriptAlertsPage alertModal = new ScriptAlertsPage();
        alertModal.alertBtn.click();
        Alert alert = switchTo().alert();
        String actual = alert.getText();
        sleep(1000);
        alert.dismiss();
        alertModal.alertClickedMsg.shouldHave(text("You successfully clicked an alert"));
        Assert.assertEquals(actual,"I am a JS Alert");

    }

    @Test
    public void siblingTestCount (){
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/large");
        LargePage.listSibling.shouldHave(CollectionCondition.size(150));
        System.out.println(LargePage.listSibling.size());
    }

    @Test
    public void lettersPressedTest () {
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/key_presses");
        KeysPressedPage page = new KeysPressedPage();
        page.inputsLettersKeys();
    }

    @Test
    public void keysPressedTest () {
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/key_presses");
        KeysPressedPage page1 = new KeysPressedPage();
        page1.altPressed();
        sleep(5000);
    }

    /**
     * Слейдер, прокрутка стрелками. Тест
     */
    @Test
    public void sliderTest(){
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/horizontal_slider");
        SliderPage.slideRight();
        SliderPage.count.shouldHave(text("3"));
        SliderPage.slideLeft();
        SliderPage.count.shouldHave(text("0.5"));
    }
    /**
     * Слейдер, прокрутка мышкой. Тест
     */
    @Test
    public void sliderTestMouse(){
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/horizontal_slider");
       // SliderPage.slider.click();
        actions()
                .moveToElement(SliderPage.slider)
                .clickAndHold(SliderPage.slider)
                .moveByOffset(40,1)
                .release().perform();
        SliderPage.count.shouldNotHave(text("2.5"));
    }
    

    /**
     * Тест наведения курсора на элементы
     */
    @Test
    public void hoverToElements(){
        setUp("win_firefox");
        open("https://the-internet.herokuapp.com/hovers");
            HoverPage.hover1();
            HoverPage.name1.shouldBe(visible);
            HoverPage.hover2();
            HoverPage.name2.shouldBe(visible);
            HoverPage.hover3();
            HoverPage.name3.shouldBe(visible);

    }

}
