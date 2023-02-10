package TestSuites;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Utility.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests {

    LoginPage login = new LoginPage();
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();
    WebDriverManager manager = new WebDriverManager();

    @Test
    public void successfulLogin() {
        login.LoginWithCorrectCredentials();
        homePage.clickProfilePicture();
        homePage.viewProfile();
        Assertions.assertEquals(profilePage.getUsernameDataValue(), login.USERNAME);
    }

    @Test
    public void logInWithEmptyCredentials() {
        login.LoginWithEmptyCredentials();
        Assertions.assertEquals(login.getLoginErrorMessage(),
                "Sorry, your username and password are incorrect - please try again.");
    }

    @Test
    public void logInWithWrongCredentials() {
        login.LoginWithWrongPassword();
        Assertions.assertEquals(login.getLoginErrorMessage(),
                "Sorry, your username and password are incorrect - please try again.");
    }


    @AfterEach
    void quit() {
        manager.quitDriver();
    }

}
