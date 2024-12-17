package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        $(byText("Create new project")).shouldBe(Condition.visible, Condition.clickable);
    }
}
