package TestSuites;

import Models.LoginPageModel;
import Utility.ConstantData;
import Utility.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    LoginPageModel login = new LoginPageModel();
    WebDriverManager manager = new WebDriverManager();

    @Test
    public void successfulLogin() {
        login.tryToLoginWithCorrectCredentials();
        Assertions.assertEquals(login.getUsernameFromProfileSummaryPage(), ConstantData.jiraUser);
    }

    @Test
    public void logInWithEmptyCredentials() {
        login.tryLoginWithEmptyCredentials();
        Assertions.assertEquals(login.getLoginErrorMessage(),
                "Sorry, your username and password are incorrect - please try again.");
    }

    @Test
    public void logInWithWrongCredentials() {
        login.tryLoginWithWrongCredentials();
        Assertions.assertEquals(login.getLoginErrorMessage(),
                "Sorry, your username and password are incorrect - please try again.");
    }


    @AfterEach
    void quit() {
        manager.quitDriver();
    }

}
