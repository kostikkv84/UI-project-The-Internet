import org.testng.Assert;
import org.testng.annotations.Test;
import uitestingplayground.MouseOver;

import static com.codeborne.selenide.Selenide.open;

public class TestUItestingBackground extends BaseTest{

    @Test
    public void testClickMouse(){
        setUp("win_firefox");
        open(mouseOverURL);
        MouseOver mouseClick = new MouseOver();
        Assert.assertTrue(mouseClick.count() == 0);
            mouseClick.clickMe.click();
            mouseClick.clickMeActive.click();
        Assert.assertEquals(mouseClick.clickCount.getText(), "2");

    }

    @Test
    public void testClickMouse1(){
        setUp("win_firefox");
        open(mouseOverURL);
        MouseOver mouseClick = new MouseOver();

        Assert.assertTrue(mouseClick.count() == 0);
        for (int i = 0; i<=2; i++){
            mouseClick.clickMe.click();
        }
        Assert.assertEquals(mouseClick.count(), 2);

    }
}
