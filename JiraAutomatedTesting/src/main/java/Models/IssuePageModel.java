package Models;

import Models.BaseModel.BaseModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssuePageModel extends BaseModel {
    DeleteIssueWindowModel deleteIssueWindow = new DeleteIssueWindowModel();

    @FindBy(id = "edit-issue")
    WebElement editIssueButton;

    @FindBy(id = "summary-val")
    WebElement summaryValue;

    @FindBy(id = "opsbar-operations_more")
    WebElement moreButton;

    @FindBy(id = "delete-issue")
    WebElement deleteButton;


    public void waitForMoreButtonToBeClickable(){
        moreButton = waitUntilElementIsClickable("id", "opsbar-operations_more");
    }


    public void waitForDeleteButtonToBeClickable(){
        deleteButton = waitUntilElementIsClickable("id", "delete-issue");
    }


    public void waitForEditButtonToBeClickable(){
        editIssueButton = waitUntilElementIsClickable("id", "edit-issue");
    }


    public void clickMoreButton(){
        moreButton.click();
    }


    public void clickDeleteButton(){
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

}
