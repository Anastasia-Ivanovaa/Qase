package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage extends BasePage {

    private final String CREATE_NEW_PROJECT_BUTTON = "Create new project";
    private final String DELETE_PROJECT_BUTTON = "//button[@type='button']/span[contains(text(),'Delete project')]";

    public void openPage() {
        open("projects");
    }

    public void isPageOpened() {
        $(byText(CREATE_NEW_PROJECT_BUTTON)).shouldBe(Condition.visible, Condition.clickable);
    }

    public void openCreateNewProjectModal() {
        $(byText(CREATE_NEW_PROJECT_BUTTON)).click();
    }

    public void removeProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $x(DELETE_PROJECT_BUTTON).click();
    }
}
