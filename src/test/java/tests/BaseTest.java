package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectsPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.baseUrl = "https://app.qase.io/";

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}
