package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HoverPage {

    public static SelenideElement img1 = $x("//div[@class=\"figure\"][1]");
    public static SelenideElement img2 = $x("//div[@class=\"figure\"][2]");
    public static SelenideElement img3 = $x("//div[@class=\"figure\"][3]");


    public static SelenideElement name1 = $x("//div[@class=\"figcaption\"]//h5[contains(text(),\"name: user1\")]");
    public static SelenideElement name2 = $x("//div[@class=\"figcaption\"]//h5[contains(text(),\"name: user2\")]");
    public static SelenideElement name3 = $x("//div[@class=\"figcaption\"]//h5[contains(text(),\"name: user3\")]");

    public static void hover1 () {
        actions().moveToElement(img1).build().perform();
    }
    public static void hover2 () {
        actions().moveToElement(img2).build().perform();
    }
    public static void hover3 () {
        actions().moveToElement(img3).build().perform();
    }

}
