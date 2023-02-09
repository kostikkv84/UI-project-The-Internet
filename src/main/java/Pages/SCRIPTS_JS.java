package Pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SCRIPTS_JS {

    public static void removeClass (){
        executeJavaScript("document.getElementById(\"file-submit\").classList.remove(\"button\")");
    }
}
