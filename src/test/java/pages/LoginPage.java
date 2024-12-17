package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage{

    private final String PASSWORD = "[name=password]";
    private final String USER = "[name=email]";
    private final String SIGN_IN_BUTTON = "Sign in";


    public void openPage() {
        open("login");
    }

    public void isPageOpened() {
        $(byText(SIGN_IN_BUTTON)).shouldBe(Condition.visible);
    }

    public void login(String user, String password) {
        $(USER).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(SIGN_IN_BUTTON)).click();
    }
}
