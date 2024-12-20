package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        loginPage.openPage()
                .isPageOpened()
                .login(user, password)
                .isPageOpened()
                .openCreateNewProjectModal()
                .createNewProject("Iva", "WA", "Test project");
        $(byText("Iva")).shouldBe(Condition.visible);
    }

    @Test
    public void checkRemoveProject() {
        loginPage.openPage()
                .isPageOpened()
                .login(user, password)
                .isPageOpened()
                .removeProject("Iva");
        $(byText("Iva")).shouldNotBe(Condition.visible);
    }
}
