package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageModel extends BaseModel {

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

    @FindBy(xpath = "//a[contains(text(), \"has been successfully created\")]")
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
        createIssueConfirmationLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"has been successfully created\")]")));
    }


    public void clickConfirmationLink(){
        createIssueConfirmationLink.click();
    }


    public void searchIssue(String issueName){
        searchField.sendKeys(issueName);
        searchField.sendKeys(Keys.ENTER);
    }
}
