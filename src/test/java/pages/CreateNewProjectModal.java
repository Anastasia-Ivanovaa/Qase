package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreateNewProjectModal extends BasePage {

    private final String CREATE_PROJECT_BUTTON = "Create project";
    private final String PROJECT_NAME_FIELD = "[id=project-name]";
    private final String PROJECT_CODE_FIELD = "[id=project-code]";

    @Override
    public void openPage() {
    }

    @Override
    public void isPageOpened() {
        $(byText(CREATE_PROJECT_BUTTON)).shouldBe(Condition.visible);
    }

    public void createNewProject(String projectName, String projectCode) {
        $(PROJECT_NAME_FIELD).setValue(projectName);
        $(PROJECT_CODE_FIELD).setValue(projectCode);
        $(byText(CREATE_PROJECT_BUTTON)).click();
    }
}
