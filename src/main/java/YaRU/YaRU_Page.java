package YaRU;

import static com.codeborne.selenide.Selenide.open;

public class YaRU_Page {

    public YaRU_Page(String url) {
        open(url);
    }
}
