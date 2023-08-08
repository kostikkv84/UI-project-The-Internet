package The_Internet_Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class IFramePage {

    public SelenideElement iframe = $x("//iframe");
    public SelenideElement textArea = $x("//p");
    public SelenideElement newFileBtn = $x("//button[@role=\"menuitem\"]//span[1]");
    public SelenideElement newFile = $x("//div[@class=\"tox-collection__item-label\"]");

    public SelenideElement newEditBtn = $x("//button[@role=\"menuitem\"]//span[contains(text(),\"Edit\")]");
    public SelenideElement newEditBtnUndo = $x("//div[@title=\"Undo\"]");

    public SelenideElement newViewBtn = $x("//button[@role=\"menuitem\"]//span[3]");
    public SelenideElement newFormatBtn = $x("//button[@role=\"menuitem\"]//span[4]");



    public void clearFrame(){
        switchTo().frame(iframe);
        textArea.clear();
        textArea.shouldNotHave(text("Your content goes here."));
        switchTo().defaultContent();
    }
    public void changeTextFrame(){
        switchTo().frame(iframe);
        textArea.clear();
      //  executeJavaScript("document.getElementByXpath(\"//p\").textContent=\"New Text\"");

       // switchTo().defaultContent();
    }
    public void checkTextFrame(){
        switchTo().frame(iframe);
        textArea.shouldHave(text("Your content goes here."));
        switchTo().defaultContent();
    }
    public void changeText(){
        Selenide.executeJavaScript("document.getElementByXpath(\"//div[@class=\"example\"]/h3\").textContent = \"My new!\"");
        Selenide.executeJavaScript("document.getElementByXpath(\"//div[@class=\"example\"]/h3\").innerHTML = \"My new text!\"");

    }
}
