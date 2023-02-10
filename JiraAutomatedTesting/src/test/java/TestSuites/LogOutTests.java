package TestSuites;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogOutTests {

    LoginPage loginPage = new LoginPage();

    HomePage homePage = new HomePage();

    WebDriverManager webDriverManager = new WebDriverManager();


    @BeforeEach
    void loginToJira(){
        loginPage.login();
    }


    @AfterEach
    void quitWebDriver(){
        webDriverManager.quitDriver();
    }


    @Test
    void logOutHappyPath(){
        homePage.clickProfilePicture();
        homePage.clickLogOutButton();
        Assertions.assertEquals(loginPage.logOutMessage, loginPage.getLogoutMessageText());
    }


}
