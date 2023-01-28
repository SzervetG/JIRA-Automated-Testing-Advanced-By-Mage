package TestSuites;

import Pages.*;
import Pages.CreateIssuePage.CreateIssueWindowPage;
import Utility.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class CreateIssueTests {

    WebDriverManager webDriverManager = new WebDriverManager();
    LoginPage loginPage = new LoginPage();
    CreateIssueWindowPage createIssueWindow = new CreateIssueWindowPage();
    IssuePage issuePage = new IssuePage();


    @BeforeEach
    void loginToJira(){
        loginPage.login();
    }

    @Test
    void createIssueHappyPath(){
        createIssueWindow.createIssueToProject("MTP", "Task");
        Assertions.assertEquals(createIssueWindow.getIssueUuid(), issuePage.getSummaryValue());
        issuePage.deleteIssue();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CreateIssueIssueTypes.csv")
    void validateIssueParameterPresenceInCreateIssueProcedure(String projectName, String issueType){
        createIssueWindow.setIssueParameters(projectName, issueType);
        Assertions.assertEquals(projectName, createIssueWindow.getProjectFieldValue());
        Assertions.assertEquals(issueType, createIssueWindow.getIssueTypeFieldValue());
    }

    @AfterEach
    void quitDriver(){
        webDriverManager.quitDriver();
    }

}
