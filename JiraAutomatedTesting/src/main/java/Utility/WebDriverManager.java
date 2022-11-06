package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {


    public static WebDriver webDriver = null;

    private static String baseUrl = ConstantData.baseUrl;

    public static void createWebDriver(){
        if(webDriver == null){
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            webDriver = new ChromeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.get(baseUrl);
    }


    public WebDriver getWebDriver(){
        createWebDriver();
        return webDriver;
    }


    public void quitDriver(){
        webDriver.quit();
        webDriver = null;
    }


    public void openWebPage(String url){
        webDriver.get(url);
    }
}
