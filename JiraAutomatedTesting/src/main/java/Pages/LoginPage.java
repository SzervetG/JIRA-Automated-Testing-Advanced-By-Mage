package Pages;

import Pages.BaseModel.Base;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {

    protected String USERNAME = System.getProperty("jiraUser");
    protected String PASSWORD = System.getProperty("jiraPass");

    @FindBy(id = "login-form-username")
    protected WebElement usernameField;

    @FindBy(id = "login-form-password")
    protected WebElement passwordField;

    @FindBy(id = "login")
    protected WebElement loginButton;

    @FindBy(id = "header-details-user-fullname")
    protected WebElement profilePicture;


    protected void setUsername(String username){
        try{
            usernameField.sendKeys(username);
        } catch (StaleElementReferenceException e){
            waitForUsernameFieldToBeClickable();
            usernameField.sendKeys(username);
        }
    }


    protected void setPassword(String password){
        try {
            passwordField.sendKeys(password);
        } catch (StaleElementReferenceException e){
            passwordField = waitUntilElementIsClickable("id", "login-form-password");
            passwordField.sendKeys(password);
        }
    }


    protected void clickLoginButton(){
        loginButton.click();
    }


    protected void waitForUsernameFieldToBeClickable(){
        usernameField = waitUntilElementIsClickable("id", "login-form-username");
    }


    private void waitForProfilePictureToBeClickable(){
        profilePicture = waitUntilElementIsClickable("id", "header-details-user-fullname");
    }


    public void login(){
        waitForUsernameFieldToBeClickable();
        setUsername(USERNAME);
        setPassword(PASSWORD);
        clickLoginButton();
        waitForProfilePictureToBeClickable();
    }
}
