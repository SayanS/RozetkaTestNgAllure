package rozetka.pages.customElements;

import org.openqa.selenium.WebDriver;
import rozetka.pages.BasePage;

public class ProfileLeftSideMenu extends BasePage {
    WebDriver webDriver;

    public ProfileLeftSideMenu(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

}
