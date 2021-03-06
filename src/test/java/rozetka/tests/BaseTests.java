package rozetka.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import rozetka.pages.HomePage;
import rozetka.utils.CustomTestListener;
import rozetka.utils.FilesUtils;

import java.util.concurrent.TimeUnit;

@Test(alwaysRun = true, groups={"run"})
@Listeners({CustomTestListener.class})
public class BaseTests {
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("-incognito");
        chromeOptions.addArguments("--start-maximized", "true");
        chromeOptions.addArguments("disable-popup-blocking", "true");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--private");
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.setCapability("marionette", true);

        switch (FilesUtils.getConfigProperty("webDriver").toUpperCase()) {
            case "CHROME": {
                System.setProperty("webdriver.chrome.driver", FilesUtils.getConfigProperty("pathWebDriver"));
                webDriver = new ChromeDriver(chromeOptions);
                break;
            }
            case "FIREFOX": {
                System.setProperty("webdriver.firefox.driver", FilesUtils.getConfigProperty("pathWebDriver"));
                webDriver = new FirefoxDriver(firefoxOptions);
                webDriver.manage().window().maximize();
                break;
            }
            default: {
                System.setProperty("webdriver.chrome.driver", FilesUtils.getConfigProperty("pathWebDriver"));
                webDriver = new ChromeDriver(chromeOptions);
                break;
            }
        }
        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterTest
    public void tearDown(){
        webDriver.manage().deleteAllCookies();
        if(webDriver!=null){
            webDriver.close();
            webDriver.quit();
        }
    }

    @BeforeMethod
    public void saveWebDriver(ITestContext context){
        context.setAttribute("driverKey", webDriver);
    }

    @Step
    public HomePage openHomePage() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        return homePage;
    }


//    clean test site -Drun.browser=chrome -Dbase.url=https://eldorado.ua/ -DsuiteXml=eldoradoTestng.xml
}
