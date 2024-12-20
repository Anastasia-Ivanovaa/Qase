package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectTest extends BaseTest {

    @Test
    public void createTestCase() {
        loginPage.openPage()
                .isPageOpened()
                .login(user, password)
                .isPageOpened()
                .openProject("Iva")
                .isPageOpened()
                .openCreateTestCasePage()
                .isPageOpened()
                .fillTheForm();
        $(byText("Check valid login")).shouldBe(Condition.visible);
    }
}
