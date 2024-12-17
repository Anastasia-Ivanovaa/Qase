package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        loginPage.openPage();
        loginPage.login("anastasiaroubo@gmail.com", "Qase123456Java!");
        projectsPage.waitUntilOpened();
        projectsPage.removeProject("Ivanova");
    }
}
