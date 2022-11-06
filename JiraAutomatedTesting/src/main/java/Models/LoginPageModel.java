package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageModel extends BaseModel {

    WebDriverWait wait;

    @FindBy(id = "header-details-user-fullname")
    WebElement profilePicture;

    @FindBy(id = "view_profile")
    WebElement profileInfo;

    @FindBy(id = "up-d-username")
    WebElement usernameInfo;


    public void login(){
        baseLogin();
    }


    public void waitForUsernameToBeClickable(){
        usernameInfo = wait.until(ExpectedConditions.elementToBeClickable(By.id("up-d-username")));
    }

    public void setUsername(String username){
        usernameField.sendKeys(username);
    }


    public void setPassword(String password){
        passwordField.sendKeys(password);
    }


    public void clickLoginButton(){
        loginButton.click();
    }


    public void clickProfilePicture(){
        profilePicture.click();
    }


    public void clickProfileInfo(){
        profileInfo.click();
    }


    public void waitForUsernameInfoToBeClickable(){
        usernameInfo = wait.until(ExpectedConditions.elementToBeClickable(By.id("up-d-username")));
    }


    public String getUsernameFromProfileSummaryPage(){
        waitForUsernameInfoToBeClickable();
        return usernameInfo.getText();
    }
}
