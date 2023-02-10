package TestSuites;

import Pages.IssuePage;
import Pages.LoginPage;
import Utility.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BrowseIssueTests {

    LoginPage loginPage = new LoginPage();
    IssuePage issuePage = new IssuePage();
    WebDriverManager webDriverManager = new WebDriverManager();


    @BeforeEach
    void loginToJira(){
        loginPage.login();
    }


    @AfterEach
    void quitWebDriver(){
        webDriverManager.quitDriver();
    }


    @Test
    void browseExistingIssue(){
        webDriverManager.openWebPage("https://jira-auto.codecool.metastage.net/browse/MTP-2363");
        issuePage.waitForProjectKeyToBeClickable();
        Assertions.assertEquals(issuePage.existingIssueKey, issuePage.getIssueKey());
    }


    @Test
    void browseNonExistingIssue(){
        webDriverManager.openWebPage("https://jira-auto.codecool.metastage.net/browse/MTP-4793278");
        issuePage.waitForViewErrorMessageToBeClickable();
        Assertions.assertEquals(issuePage.issueCanNotBeViewed, issuePage.getIssueNotFoundErrorMessageText());
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/BrowseIssueTestData.csv")
    void browseSpecificProjectIssue(String issueKey){
        webDriverManager.openWebPage("https://jira-auto.codecool.metastage.net/browse/"+ issueKey);
        issuePage.waitForProjectKeyToBeClickable();
        Assertions.assertEquals(issueKey, issuePage.getIssueKey());
    }

}
