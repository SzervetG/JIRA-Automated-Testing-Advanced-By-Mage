package Pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;
import java.util.UUID;

public class CreateIssueWindowPage extends Base {
    HomePage homePage = new HomePage();

    @FindBy(id = "project-field")
    WebElement projectField;

    @FindBy(id = "issuetype-field")
    WebElement issueTypeField;

    @FindBy(id = "summary")
    WebElement summaryField;

    @FindBy(id = "create-issue-submit")
    WebElement createIssueButton;

    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    WebElement cancelButton;


    private String randomUuid;


    public CreateIssueWindowPage(){
        randomUuid = setRandomUuid();
    }


    public String getIssueUuid(){
        return this.randomUuid;
    }


    public String getProjectFieldValue(){
        projectField = waitUntilElementIsClickable("id", "project-field");
        return projectField.getAttribute("value");
    }


    public String getIssueTypeFieldValue(){
        issueTypeField = waitUntilElementIsClickable("id", "issuetype-field");
        return issueTypeField.getAttribute("value");
    }


    public void waitForProjectFieldToBeClickable(){
        projectField = waitUntilElementIsClickable("id", "project-field");
    }


    public void waitForIssueTypeFieldToBeClickable(){
        issueTypeField = waitUntilElementIsClickable("xpath", "//input[@id=\"issuetype-field\"]");
    }


    public void waitForSummaryFieldToBeClickable(){
        summaryField = waitUntilElementIsClickable("id", "summary");
    }


    public void waitForCreateButtonToBeClickable(){
        createIssueButton = waitUntilElementIsClickable("id", "create-issue-submit");
    }


    public void overwriteProjectField(String projectName){
        try {
            waitForProjectFieldToBeClickable();
            overWriteFieldToSpecifiedValue(projectField, projectName);
        } catch (ElementNotInteractableException | NoSuchElementException e){
            waitForProjectFieldToBeClickable();
            overWriteFieldToSpecifiedValue(projectField, projectName);
        }
    }


    public void overwriteIssueTypeField(String issueType){
        try {
            waitForIssueTypeFieldToBeClickable();
            overWriteFieldToSpecifiedValue(issueTypeField, issueType);
        } catch (ElementNotInteractableException e){
            waitForIssueTypeFieldToBeClickable();
            overWriteFieldToSpecifiedValue(issueTypeField, issueType);
        }
    }


    public void setSummaryField(String summary){
        try {
            waitForSummaryFieldToBeClickable();
            overWriteFieldToSpecifiedValue(summaryField, summary);
        } catch (ElementNotInteractableException e){
            waitForSummaryFieldToBeClickable();
            overWriteFieldToSpecifiedValue(summaryField, summary);
        }
    }


    public void clickSummaryField(){
        summaryField.click();
    }


    public void clickCreateIssueButton(){
        createIssueButton.click();
    }


    public void clickCancelButton(){
        cancelButton.click();
    }


    public String setRandomUuid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    public void createIssueToProject(String projectName, String issueType){

        homePage.clickCreateIssueButton();
        overwriteProjectField(projectName);
        overwriteIssueTypeField(issueType);
        setSummaryField(randomUuid);
        waitForCreateButtonToBeClickable();
        clickCreateIssueButton();
        homePage.waitForConfirmationLinkToBeClickable();
        homePage.clickConfirmationLink();
    }


    public void setIssueParameters(String projectName, String issueType){
        homePage.clickCreateIssueButton();
        overwriteProjectField(projectName);
        overwriteIssueTypeField(issueType);
        waitForSummaryFieldToBeClickable();
        clickSummaryField();
    }

}
