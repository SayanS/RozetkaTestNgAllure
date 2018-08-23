package rozetka.pages.popups;

import org.openqa.selenium.WebDriver;
import rozetka.pages.BasePage;

public class AuthPopUp extends BasePage {
    WebDriver webDriver;

    public AuthPopUp(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

}
