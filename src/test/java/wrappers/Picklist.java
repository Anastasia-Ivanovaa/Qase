package wrappers;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Picklist {

    private final String label;
    private final String pickListPattern = "//label[contains(text(), '%s')]/following::div[@role='combobox']";
    private final String picklistOptionPattern = "//div[text() = '%s']";

    public Picklist(String label) {
        this.label = label;
    }

    public void select(String option) {
        $(By.xpath(String.format(pickListPattern, label))).click();
        $(By.xpath(String.format(picklistOptionPattern, option))).click();
    }
}
