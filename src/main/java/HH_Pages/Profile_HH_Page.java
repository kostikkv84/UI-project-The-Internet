package HH_Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Profile_HH_Page {

    SelenideElement age = $x("//span[@data-qa=\"resume-personal-age\"]");
    SelenideElement gender = $x("//span[@data-qa=\"resume-personal-gender\"]");
    SelenideElement city = $x("//span[@data-qa=\"resume-personal-address\"]");
    SelenideElement relocate = $x("//span[@data-qa=\"resume-personal-address\"]//ancestor::p");
    SelenideElement phoneNumber = $x("//span[@data-qa=\"resume-contact-preferred\"]");

    // ключи для HASH MAP
    public static String GENDER = "пол";
    public static String AGE = "возраст";
    public static String CITY = "город";
    public static String PHONE_CONFIRMED = "подтвержденный номер";
    public static String READY_TO_RELOCATE = "готовность к пееезду";

    /**
     * получение актуального результата из селекторов на сайте
     * @return
     */
    public Map<String, Object> getAttributes () {
      /* Вариант простой для наглядности:
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(GENDER, getGender());
        attributes.put(AGE, getAge());
        attributes.put(CITY, getCity());
        attributes.put(PHONE_CONFIRMED, isPhoneConfirmed());
        attributes.put(READY_TO_RELOCATE, isReadyToRelocate());
        return attributes; */
        /**
         * Создание HashMap продвинутое: необходима Java 9 и выше.
         */
        return new HashMap<>(){{
            put(GENDER, getGender());
            put(AGE, getAge());
            put(CITY, getCity());
            put(PHONE_CONFIRMED, isPhoneConfirmed());
            put(READY_TO_RELOCATE, isReadyToRelocate());
        }};
    }

// ---- Получение М или Ж - классический способ
 /*   public String gender () {
        if (gender.getText() == "Мужчина") {
            return "М";
        } else {
            return  "Ж";
        }
    }*/

    /**
     * Получение М или Ж используя Тернальный оператор - пример ....
     * @return
     */
    public String getGender () {
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }

    // ----- Из строки (38 лет) - получили число 38, заменив " лет" на ничего "" и спарсив str в int.
    public int getAge () {
        return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }

    public String getCity () {
        return  city.getText();
    }

    public boolean isReadyToRelocate() {
        return relocate.getText().split(", ")[1].equals("не готов к переезду");
    }

    // ВИден ли телефон на странице
    public boolean isPhoneConfirmed(){
        return phoneNumber.isDisplayed();
    }

    public Profile_HH_Page(String URL) {
        Selenide.open(URL);
    }



}
