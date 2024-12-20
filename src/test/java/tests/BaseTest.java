package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;
    CreateNewProjectModal createNewProjectModal;
    ProjectPage projectPage;
    CreateNewTestPage createNewTestPage;

    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

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
        createNewProjectModal = new CreateNewProjectModal();
        projectPage = new ProjectPage();
        createNewTestPage = new CreateNewTestPage();

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
