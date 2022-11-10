package Models;

import Models.BaseModel.BaseModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageModel extends BaseModel {


    @FindBy(className = "captcha-image")
    WebElement captchaImage;


    public void waitForCaptchaImageToBeClickable(){
        captchaImage = waitUntilElementIsClickable("className", "captcha-image");
    }


    public void login(){
        baseLogin();
    }


    public void setUsernameFieldValue(String username){
        setUsername(username);
    }


    public void setPasswordFieldValue(String password){
        setPassword(password);
    }


    public void clickLoginButton(){
        loginButton.click();
    }

    public void loginWithWrongCredentialsUntilCaptchaAppears(){
        int loginLimit = 3;
        for(int loginTime = 0; loginTime < loginLimit; loginTime++)
        {
            setUsernameFieldValue(USERNAME);
            setPasswordFieldValue("pass");
            clickLoginButton();
        }
    }


}
