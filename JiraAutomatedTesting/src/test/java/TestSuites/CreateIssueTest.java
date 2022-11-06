package TestSuites;

import Models.*;
import Utility.WebDriverManager;
import org.junit.jupiter.api.Test;


public class CreateIssueTest {

    WebDriverManager webDriverManager = new WebDriverManager();
    LoginPageModel loginPage = new LoginPageModel();
    HomePageModel homePage = new HomePageModel();
    CreateIssueWindowModel createIssueWindow = new CreateIssueWindowModel();
    CreateIssueDescriptionFrameModel descriptionFrame = new CreateIssueDescriptionFrameModel();
    IssuePageModel issuePage = new IssuePageModel();
    DeleteIssueWindowModel deleteIssueWindow = new DeleteIssueWindowModel();


    @Test
    public void createIssueSUCCESSFUL(){
        loginPage.login();
        homePage.clickCreateIssueButton();
        createIssueWindow.waitForProjectFieldToBeClickable();
        createIssueWindow.setProjectField("MTP");
        createIssueWindow.setIssueTypeField("Task");
        createIssueWindow.setSummaryField(createIssueWindow.getRandomUuid());
        createIssueWindow.changeToDescriptionFrame();
        descriptionFrame.setDescriptionField(createIssueWindow.getRandomUuid());
        descriptionFrame.changeBackToOriginalFrame();
        createIssueWindow.clickCreateIssueButton();
        homePage.waitForConfirmationLinkToBeClickable();
        homePage.clickConfirmationLink();
        issuePage.waitForMoreButtonToBeClickable();
        issuePage.clickMoreButton();
        issuePage.clickDeleteButton();
        deleteIssueWindow.waitForConfirmDeleteButtonToBeClickable();
        deleteIssueWindow.clickDeleteConfirmationButton();
        webDriverManager.quitDriver();
    }

}
