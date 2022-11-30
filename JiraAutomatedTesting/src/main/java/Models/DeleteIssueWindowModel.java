package Models;

import Models.Base.BaseModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteIssueWindowModel extends BaseModel {

    @FindBy(id = "delete-issue-submit")
    WebElement confirmDeleteButton;

    public void waitForConfirmDeleteButtonToBeClickable(){
        confirmDeleteButton = waitUntilElementIsClickable("id", "delete-issue-submit");
    }


    public void clickDeleteConfirmationButton(){
        confirmDeleteButton.click();
    }
}
