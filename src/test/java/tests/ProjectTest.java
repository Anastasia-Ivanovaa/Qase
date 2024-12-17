package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectsPage.isPageOpened();
        projectsPage.openCreateNewProjectModal();
        createNewProjectModal.createNewProject("Ivanova", "WA");

    }

    @Test
    public void checkRemoveProject() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectsPage.isPageOpened();
        projectsPage.removeProject("Ivanova");
    }
}
