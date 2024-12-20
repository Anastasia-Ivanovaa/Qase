package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage extends BasePage {

    private final String CASE_BUTTON = "[id='create-case-button']";

    @Override
    public ProjectPage openPage() {
        return null;
    }

    @Override
    public ProjectPage isPageOpened() {
        $(CASE_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public CreateNewTestPage openCreateTestCasePage(){
        $(CASE_BUTTON).click();
        return new CreateNewTestPage();
    }
}
