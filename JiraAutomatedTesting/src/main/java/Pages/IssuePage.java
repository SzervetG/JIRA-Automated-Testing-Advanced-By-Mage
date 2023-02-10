package Pages;

import Pages.BaseModel.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IssuePage extends Base {
    DeleteIssueWindowPage deleteIssueWindow = new DeleteIssueWindowPage();

    @FindBy(id = "edit-issue")
    WebElement editIssueButton;

    @FindBy(id = "summary-val")
    WebElement summaryValue;

    @FindBy(id = "opsbar-operations_more")
    WebElement moreButton;

    @FindBy(id = "delete-issue")
    WebElement deleteButton;

    @FindBy(className = "issue-link")
    WebElement issueKey;


    @FindBy(xpath = "//*[@id=\"issue-content\"]/div/div/h1")
    WebElement issueNotFoundErrorMessage;


    public void waitForMoreButtonToBeClickable(){
        moreButton = waitUntilElementIsClickable("id", "opsbar-operations_more");
    }


    public void waitForDeleteButtonToBeClickable(){
        deleteButton = waitUntilElementIsClickable("id", "delete-issue");
    }


    public void waitForEditButtonToBeClickable() {
        editIssueButton = waitUntilElementIsClickable("id", "edit-issue");
    }

    public void clickEditIssueButton () {
        editIssueButton.click();
    }


    public void waitForMoreButtonToBeClickable() {
        moreButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("opsbar-operations_more")));



    public void clickMoreButton() {
        moreButton.click();
    }


    public void clickDeleteButton() {
        deleteButton.click();
    }


    public void clickEditIssueButton(){
        editIssueButton.click();
    }


    public String getSummaryValue(){
        return summaryValue.getText();
    }


    public void deleteIssue(){

        waitForMoreButtonToBeClickable();
        clickMoreButton();
        waitForDeleteButtonToBeClickable();
        clickDeleteButton();
        deleteIssueWindow.waitForConfirmDeleteButtonToBeClickable();
        deleteIssueWindow.clickDeleteConfirmationButton();
    }


    public boolean isEditButtonThere(){
        return editIssueButton.isDisplayed();
    }
    public String getIssueKey() {
        return issueKey.getText();
    }

    public void openExistingIssue(String projectUrl) {
        webDriverManager.openWebPage(projectUrl);
    }

    public void openNonExistingIssue(String projectUrl) {
        webDriverManager.openWebPage(projectUrl);
    }


    public void projectKeyIsVisible() {
        issueKey.isDisplayed();
    }

    public String getIssueNotFoundErrorMessageText() {
        return issueNotFoundErrorMessage.getText();
    }


}
