import YaRU.YaRU_Page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.http.ContentType;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class YaTests extends BaseTest{

    public final String URL = "https://ya.ru/";

    @Test
    public void authKeycloak(){
        setUp("win_firefox");
        Selenide.open("http://keycloak-dev.lan/auth/admin");

        $("#root").shouldBe(Condition.visible);
                 /**
         * ПОлучаем Cookie И записываем в переменную.
         */
        String crsfToken = WebDriverRunner.getWebDriver().manage().getCookieNamed("KC_RESTART").getValue();
        System.out.println(crsfToken);
            // Отправляем запрос, записываем куки авторизации
       String sessionID = given()
                .contentType(ContentType.MULTIPART)
                .cookie("KC_RESTART", crsfToken)
                .multiPart("username","admin")
                .multiPart("password","admin")
                .multiPart("credentialId", "")
               .queryParam("session_code","s0xuNJJ0gnZZyhirokJ9ZXDe6kuW3r3W1XmNRTfMJ64")
               .queryParam("execution", "6192601c-0f9c-4fa6-a898-1e11ce33aafd")
               .queryParam("client_id","security-admin-console")
               .queryParam("tab_id","pUXWdYdX8dU")
               .when()
                .post("http://keycloak-dev.lan/auth/realms/master/login-actions/authenticate?session_code=s0xuNJJ0gnZZyhirokJ9ZXDe6kuW3r3W1XmNRTfMJ64&execution=6192601c-0f9c-4fa6-a898-1e11ce33aafd&client_id=security-admin-console&tab_id=pUXWdYdX8dU")
                .then().log().all().extract().cookie("AUTH_SESSION_ID_LEGACY");

        System.out.println(sessionID);
       Date expDate = new Date();
       expDate.setTime(expDate.getTime()+(1000*1000)); // сдвигаем срок действия куки

        Cookie cookie = new Cookie("AUTH_SESSION_ID_LEGACY", sessionID, "keycloak-dev.lan", "/auth/realms/master/", expDate);
        System.out.println(cookie);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        Selenide.refresh(); // перегружаем страницу
        open("http://keycloak-dev.lan/auth/admin/master/console/#/realms");
        sleep(5000);
    }



    @Test
    public void authGitlab(){
        setUp("win_firefox");
        Selenide.open("https://gitlab.lan/"); // открываем сайт, страницу авторизации
            // получаем куки, с сервера
        String crsfToken = WebDriverRunner.getWebDriver().manage().getCookieNamed("experimentation_subject_id").getValue();
        System.out.println(crsfToken);
            // отправляем запрос с полученным куки для получения куки сессии
        String sessionID = given()
                .contentType(ContentType.MULTIPART)
                .cookie("known_sign_in", crsfToken)
                .multiPart("utf8","✓\n")
                .multiPart("authenticity_token","JpoLPDlR1LRny1lP4q/RKKyVOTpbOVqhqH4lvUJRGIShj4rtdCMX1eS5kfGFXiNW9Eqwr/7nd/Vrb/dUBkD0VQ==")
                .multiPart("username", "konstantin.kostylev")
                .multiPart("password", "2zxhkTpa")
                .post("https://gitlab.lan/users/auth/ldapmain/callback")
                .then().log().all().extract().cookie("_gitlab_session");

     //   System.out.println(sessionID);
        Date expDate = new Date();
        expDate.setTime(expDate.getTime()+(10000*10000));
         System.out.println("Дата действия куки: " + expDate);
        // подготавливаем измененный куки сессии
        Cookie cookie = new Cookie("_gitlab_session", sessionID, "gitlab.lan", "/", expDate);
        System.out.println(expDate);
            //ПОдставляем куки сесси в браузер
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        Selenide.refresh();
        //Selenide.open("http://jira.lan:8080/browse/IC-420");
        sleep(5000);
    }
}
