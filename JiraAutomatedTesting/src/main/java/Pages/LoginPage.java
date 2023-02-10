package Pages;

import Utility.ReadConfig;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {

    public String USERNAME = ReadConfig.read("jiraUser");
    public String PASSWORD = ReadConfig.read("jiraPass");

    @FindBy(id = "login-form-username")
    protected WebElement usernameField;

    @FindBy(id = "login-form-password")
    protected WebElement passwordField;

    @FindBy(id = "login")
    protected WebElement loginButton;

    @FindBy(id = "header-details-user-fullname")
    protected WebElement profilePicture;

    @FindBy(id = "usernameerror")
    WebElement loginErrorMessage;

    @FindBy(id = "log_out")
    WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/p[1]/strong")
    WebElement logoutMessage;


    public String logOutMessage = "You are now logged out. Any automatic login has also been stopped.";


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


    public void clickLogoutButton() {
        logoutButton.click();
    }


    public void clickProfilePicture(){
        profilePicture.click();
    }


    protected void waitForUsernameFieldToBeClickable(){
        usernameField = waitUntilElementIsClickable("id", "login-form-username");
    }


    private void waitForProfilePictureToBeClickable(){
        profilePicture = waitUntilElementIsClickable("id", "header-details-user-fullname");
    }


    public void waitForErrorMessageIsVisible() {
        loginErrorMessage = waitUntilElementIsClickable("id", "usernameerror");
    }


    public void login(){
        waitForUsernameFieldToBeClickable();
        setUsername(USERNAME);
        setPassword(PASSWORD);
        clickLoginButton();
        waitForProfilePictureToBeClickable();
    }


    public void loginWithParameters(String username, String password){
        waitForUsernameFieldToBeClickable();
        setUsername(username);
        setPassword(password);
        System.out.println(password);
        clickLoginButton();
    }


    public void LoginWithCorrectCredentials() {
        loginWithParameters(USERNAME, PASSWORD);
        waitForProfilePictureToBeClickable();
    }




    public void LoginWithWrongPassword() {
        loginWithParameters(USERNAME, "password");
        waitForErrorMessageIsVisible();
    }

    public void LoginWithEmptyCredentials() {
        loginWithParameters("", "");
        waitForErrorMessageIsVisible();
    }


    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }




    public String getLogoutMessageText() {
        return logoutMessage.getText();
    }


    public void Logout() {
        clickProfilePicture();
        clickLogoutButton();

    }
}
