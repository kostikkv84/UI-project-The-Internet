package The_Internet_Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DownloadPage {

    public static SelenideElement xmlFile = $x("//a[contains(text(),\".xml\")]");
    public static SelenideElement pdfFile = $x("//a[contains(text(),\".pdf\")]");
    public static SelenideElement pngFile = $x("//a[contains(text(),\".png\")]");
    public static SelenideElement txtFile = $x("//a[contains(text(),\".txt\")]");


}
