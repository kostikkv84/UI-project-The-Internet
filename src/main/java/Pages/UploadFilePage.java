package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UploadFilePage {
    public static SelenideElement uploadInput = $("#file-upload");
    public static SelenideElement button = $("#file-submit");
    public static SelenideElement uploadedMessage = $("h3");
}
