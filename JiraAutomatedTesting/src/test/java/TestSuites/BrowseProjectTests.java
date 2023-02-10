package TestSuites;

import Pages.LoginPage;
import Pages.ProjectPage;
import Utility.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BrowseProjectTests {

    LoginPage loginPage = new LoginPage();
    ProjectPage projectPage = new ProjectPage();
    WebDriverManager webDriverManager = new WebDriverManager();

    @BeforeEach
    void loginToJira(){
        loginPage.login();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/BrowseProjectTestData.csv")
    void validateProjectPage(String projectName, String projectPageLink){
        webDriverManager.openWebPage(projectPageLink);
        projectPage.waitForProjectNameToBeClickable();
        Assertions.assertEquals(projectName, projectPage.getProjectName());
    }

    @AfterEach
    void quitWebDriver(){
        webDriverManager.quitDriver();
    }
}
