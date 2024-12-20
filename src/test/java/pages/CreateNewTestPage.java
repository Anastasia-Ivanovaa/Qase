package pages;

import com.codeborne.selenide.Condition;
import wrappers.Picklist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreateNewTestPage extends BasePage {

    private final String CONFIGURE_FIELDS_BUTTON = "Configure fields";
    private final String TITLE_FIELD = "[id='title']";
    private final String SAVE_BUTTON = "Save";

    @Override
    public BasePage openPage() {
        return null;
    }

    @Override
    public CreateNewTestPage isPageOpened() {
        $(byText(CONFIGURE_FIELDS_BUTTON)).shouldBe(Condition.visible, Condition.clickable);
        return this;
    }

    public void fillTheForm() {
        $(TITLE_FIELD).setValue("Check valid login");
        new Picklist("Status").select("Draft");
        new Picklist("Severity").select("Minor");
        new Picklist("Priority").select("Medium");
        new Picklist("Type").select("Security");
        new Picklist("Layer").select("Unit");
        new Picklist("Is flaky").select("Yes");
        new Picklist("Behavior").select("Negative");
        $(byText(SAVE_BUTTON)).click();
    }
}
