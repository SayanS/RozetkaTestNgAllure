package rozetka.pages;

import org.openqa.selenium.WebDriver;

public class GoogleSignInPage extends BasePage {
    WebDriver webDriver;

    public GoogleSignInPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public String emailField="//*[@id='identifierId']";
    public String nextButton="//span[.='Next']";




}
