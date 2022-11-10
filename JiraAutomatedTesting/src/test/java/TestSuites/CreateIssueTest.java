package TestSuites;

import Models.*;
import Models.CreateIssueModel.CreateIssueWindowModel;
import Utility.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class CreateIssueTest {

    WebDriverManager webDriverManager = new WebDriverManager();
    LoginPageModel loginPage = new LoginPageModel();
    CreateIssueWindowModel createIssueWindow = new CreateIssueWindowModel();
    IssuePageModel issuePage = new IssuePageModel();


    @BeforeEach
    void loginToJira(){
        loginPage.login();
    }

    @Test
    void createIssueHappyPath(){
        createIssueWindow.createIssueToProject("MTP", "Task");
//        Assertions.assertTrue(createIssueWindow.getIssueUuid() == issuePage.getSummaryValue());
        Assertions.assertEquals(createIssueWindow.getIssueUuid(), issuePage.getSummaryValue());
        issuePage.deleteIssue();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CreateIssueIssueTypes.csv")
    void validateIssueParameterPresenceInCreateIssueProcedure(String projectName, String issueType){
        createIssueWindow.setIssueParameters(projectName, issueType);
//        Assertions.assertTrue(projectName == createIssueWindow.getProjectFieldValue() && issueType == createIssueWindow.getIssueTypeFieldValue());
        Assertions.assertEquals(projectName, createIssueWindow.getProjectFieldValue());
        Assertions.assertEquals(issueType, createIssueWindow.getIssueTypeFieldValue());
    }

    @AfterEach
    void quitDriver(){
        webDriverManager.quitDriver();
    }

}
