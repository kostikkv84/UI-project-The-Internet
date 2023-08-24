import Constants.Constants;
import HH_Pages.ProfileClass;
import HH_Pages.Profile_HH_Page;
import Pages.HH;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;
import static org.aspectj.weaver.AdviceKind.Before;


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
        expectedAttributes.put(Profile_HH_Page.READY_TO_RELOCATE, true);
        expectedAttributes.put(Profile_HH_Page.PHONE_CONFIRMED, false);

        Map<String, Object> actualAttributes = profilePage.getAttributes(); // Создали HashMap из актуальных результатов на странице.
        // сравниваем Actual HashMap с Expected Hash Map
        System.out.println(profilePage.getAttributes());
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

    @Test(dataProvider = "searchText")
    public void testHHSearchIfNotFound(String text){
        setUp("win_chrome");
        String expected = "По запросу «" + text + "» ничего не найдено";
        HH hh_open = new HH(Constants.hh_ru);

        Assert.assertEquals(hh_open.checkFind(text).checkMSG(), expected, "Ответ на поиск не совпал с ожидаемым");
    }

    @Test(dataProvider = "searchTry")
    public void testHHSearchIFound(String text){
        setUp("win_chrome");
        String expected = "вакансии «" + text + "»";
        HH hh_open = new HH(Constants.hh_ru);

        Assert.assertTrue(hh_open.checkFind(text).checkMSG().contains(expected), "Ответ на поиск не совпал с ожидаемым");



    }


// ------------ Before - After methods


//------------------- DataProvider ------------------------------------
@DataProvider(name = "searchText")
public static Object[][] searchText() {
    return new Object[][] {{"Irlix"}, {"##@#@##@"}, {"Molokozavod"}, {"7899654789"}, {"BirdFabrick"}};
}

    @DataProvider(name = "searchTry")
    public static Object[][] searchTry() {
        return new Object[][] {{"Google"}, {"ВОдоканал"}, {"vk"}, {"12345"}, {"Озон"}};
    }

}
