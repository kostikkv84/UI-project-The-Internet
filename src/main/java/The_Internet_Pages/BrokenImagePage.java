package The_Internet_Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BrokenImagePage {

    public ElementsCollection images = $$(".example img");


    /**
     * Метод проверяющий длинну изображения. Если 0 то изображение не отображается.
     * @param image
     */
    public void isImageBroken(SelenideElement image)
    {
        if (image.getAttribute("naturalWidth").equals("0"))
        {
            System.out.println(image.getAttribute("outerHTML") + " is broken.");
        } else {
            System.out.println(image.getAttribute("outerHTML") + " is normal.");
        }
    }


}
