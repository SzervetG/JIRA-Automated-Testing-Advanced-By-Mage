package Models;

import Models.BaseModel.BaseModel;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPageModel extends BaseModel {


    @FindBy(id = "header-details-user-fullname")
    WebElement profilePicture;

    @FindBy(id = "view_profile")
    WebElement profileInfo;

    @FindBy(id = "up-d-username")
    WebElement usernameInfo;

    @FindBy(className = "captcha-image")
    WebElement captchaImage;

    @FindBy(id = "usernameerror")
    WebElement loginErrorMessage;

    @FindBy(id = "log_out")
    WebElement logoutButton;

    public void login(){
            baseLogin();
        }


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/p[1]/strong")
    WebElement logoutMessage;


    public void setUsername(String username) {
        try {
            usernameField.sendKeys(username);
        } catch (StaleElementReferenceException e) {
            waitForUsernameFieldToBeClickable();
            usernameField.sendKeys(username);
        }
    }


    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }


    public void tryToLoginWithCorrectCredentials() {
        baselogin();
        clickProfilePicture();
        clickProfileInfo();
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


    public void waitForErrorMessageIsVisible() {
        loginErrorMessage = wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
    }


    public String getUsernameFromProfileSummaryPage() {
        return usernameInfo.getText();
    }

    public void tryLoginWithWrongCredentials() {
        waitForUsernameFieldToBeClickable();
        setUsername("automation31");
        setPassword("password");
        clickLoginButton();
        waitForErrorMessageIsVisible();
    }

    public void tryLoginWithEmptyCredentials() {
        waitForUsernameFieldToBeClickable();
        setUsername("");
        setPassword("");
        clickLoginButton();
        waitForErrorMessageIsVisible();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }


    public boolean captchaImageIsVisible() {
        return captchaImage.isDisplayed();
    }

    public void waitForCaptchaImageIsVisible() {
        captchaImage = wait.until(ExpectedConditions.visibilityOf(captchaImage));
    }


    public void threeTimesLoginWithInvalidPassword() {
        for (int i = 0; i < 3; i++) {
            tryLoginWithWrongCredentials();
        }
        waitForCaptchaImageIsVisible();
    }

    // logoutra vonatkozó részek __________________________________________________________________________

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public String getLogoutMessageText() {
        return logoutMessage.getText();
    }

    /*
    public void profilePictureIsNotVisible() {
        profilePicture.isDisplayed();
    }

     */


    public void tryToLogout() {
        login();
        clickProfilePicture();
        clickLogoutButton();

    }
}
