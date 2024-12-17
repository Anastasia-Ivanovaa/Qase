package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    public void openPage() {
        open("projects");
    }

    public void waitUntilOpened() {
        $(byText("Create new project")).shouldBe(Condition.visible, Condition.clickable);
    }

    public void removeProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $(byText("Delete project")).click();
    }
}
