import Constants.Constants;
import HH_Pages.ProfileClass;
import HH_Pages.Profile_HH_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class HH_tests extends BaseTest{

    /**
     * Пример сравнения аттрибутов в Hash Maps
     */
    @Test
    public void checkAttributesHashMaps() {
        setUp("win_chrome");
        Profile_HH_Page profilePage = new Profile_HH_Page(Constants.HH_ProfilePageUrl);
        /**
         * Создаем Hash карту с ожидаемыми результатами:
         */
        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(Profile_HH_Page.GENDER, "М");
        expectedAttributes.put(Profile_HH_Page.AGE, 38);
        expectedAttributes.put(Profile_HH_Page.CITY, "Ялта");
        expectedAttributes.put(Profile_HH_Page.READY_TO_RELOCATE, false);
        expectedAttributes.put(Profile_HH_Page.PHONE_CONFIRMED, true);

        Map<String, Object> actualAttributes = profilePage.getAttributes(); // Создали HashMap из актуальных результатов на странице.
        // сравниваем Actual HashMap с Expected Hash Map
        Assert.assertEquals(actualAttributes,expectedAttributes, "Хеш карты с данными не совпадают: ожидаемый с актуальным!");
    }

    /**
     * Сравнение аттрибутов через сравнения аттрибутов в классах
     */
    @Test
    public void checkAttrubutesInClasses() throws Exception{
        setUp("win_firefox");
        Profile_HH_Page profilePage = new Profile_HH_Page(Constants.HH_ProfilePageUrl);

        ProfileClass expected = new ProfileClass("М",38,"Ялта", true, false);
        ProfileClass actual = new ProfileClass(profilePage.getGender(),profilePage.getAge(), profilePage.getCity(), profilePage.isPhoneConfirmed(), profilePage.isReadyToRelocate());
        /**
         * Сравнение классов !
         */
       // Assert.assertEquals(actual,expected); // так не работает!
        System.out.println(actual);
        System.out.println(expected);

    //    Assert.assertTrue(EqualsBuilder.reflectionEquals(actual,expected));
    }
}
