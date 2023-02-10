package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteIssueWindowPage extends Base {

    @FindBy(id = "delete-issue-submit")
    WebElement confirmDeleteButton;

    public void waitForConfirmDeleteButtonToBeClickable(){
        confirmDeleteButton = waitUntilElementIsClickable("id", "delete-issue-submit");
    }


    public void clickDeleteConfirmationButton(){
        confirmDeleteButton.click();
    }
}
