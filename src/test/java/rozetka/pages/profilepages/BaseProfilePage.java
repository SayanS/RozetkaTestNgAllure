package rozetka.pages.profilepages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.BasePage;

public class BaseProfilePage extends BasePage {
    WebDriver webDriver;

    public BaseProfilePage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

}
