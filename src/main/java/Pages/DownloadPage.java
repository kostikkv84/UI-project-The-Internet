package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DownloadPage {

    public static SelenideElement xmlFile = $x("//a[text()=\"5mb script.xml\"]");
    public static SelenideElement pdfFile = $x("//a[text()=\"adhar card.pdf\"]");
    public static SelenideElement pngFile = $x("//a[text()=\"pw.png\"]");
    public static SelenideElement txtFile = $x("//a[text()=\"some-file.txt\"]");


}
