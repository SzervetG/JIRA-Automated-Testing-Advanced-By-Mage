package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    @FindBy(xpath = "//div[@class=\"issue-error\"]/h1")
    WebElement issueNotFoundErrorMessage;


    public String existingIssueKey = "MTP-2363";

    public String issueCanNotBeViewed = "You can't view this issue";


    public void waitForMoreButtonToBeClickable(){
        moreButton = waitUntilElementIsClickable("id", "opsbar-operations_more");
    }


    public void waitForDeleteButtonToBeClickable(){
        deleteButton = waitUntilElementIsClickable("id", "delete-issue");
    }


    public void waitForEditButtonToBeClickable() {
        editIssueButton = waitUntilElementIsClickable("id", "edit-issue");
    }


    public void waitForProjectKeyToBeClickable() {
        issueKey = waitUntilElementIsClickable("className", "issue-link");
    }


    public void waitForViewErrorMessageToBeClickable() {
        issueNotFoundErrorMessage = waitUntilElementIsClickable("xpath", "//*[@id=\"issue-content\"]/div/div/h1");
    }


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



    public String getIssueNotFoundErrorMessageText() {
        return issueNotFoundErrorMessage.getText();
    }

}
