package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base {

    @FindBy(id = "create_link")
    WebElement createIssueButton;

    @FindBy(id = "header-details-user-fullname")
    WebElement profilePicture;

    @FindBy(id = "view_profile")
    WebElement viewProfileButton;

    @FindBy(id = "log_out")
    WebElement logOutButton;

    @FindBy(id = "quickSearchInput")
    WebElement searchField;

    @FindBy(className = "issue-created-key")
    WebElement createIssueConfirmationLink;


    public void clickProfilePicture(){
        profilePicture.click();
    }


    public void viewProfile(){
        viewProfileButton.click();
    }


    public void clickLogOutButton(){
        logOutButton.click();
    }


    public void clickCreateIssueButton(){
        createIssueButton.click();
    }


    public void waitForConfirmationLinkToBeClickable(){
        createIssueConfirmationLink = waitUntilElementIsClickable("className", "issue-created-key");
    }


    public void clickConfirmationLink(){
        createIssueConfirmationLink.click();
    }
}
