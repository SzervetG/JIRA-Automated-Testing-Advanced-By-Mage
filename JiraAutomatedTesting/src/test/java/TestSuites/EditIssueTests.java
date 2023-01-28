package TestSuites;

import Models.EditIssueModel.EditIssueWindowModel;
import Models.IssuePageModel;
import Models.LoginPageModel;
import Utility.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class EditIssueTest {

    LoginPageModel loginPage = new LoginPageModel();
    WebDriverManager webDriverManager = new WebDriverManager();

    EditIssueWindowModel editIssueWindow = new EditIssueWindowModel();

    IssuePageModel issuePage = new IssuePageModel();

    @BeforeEach
    void loginToJira(){
        loginPage.login();
    }


    @AfterEach
    void quitDriver(){
        editIssueWindow.resetEditedIssueToOriginal();
        webDriverManager.quitDriver();
    }


    @Test
    void editIssueHappyPath(){
        editIssueWindow.editIssue("https://jira-auto.codecool.metastage.net/browse/MTP-2363");
        Assertions.assertTrue(editIssueWindow.getSummaryFieldValue().contains(editIssueWindow.getEdited()));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/EditIssueURLs.csv")
    void verifyPresenceOfEditButtonOnDifferentIssuePages(String url){
        webDriverManager.openWebPage(url);
        Assertions.assertTrue(issuePage.isEditButtonThere());
    }
}
