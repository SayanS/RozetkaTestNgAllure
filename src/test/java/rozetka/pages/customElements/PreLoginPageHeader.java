package rozetka.pages.customElements;

import org.openqa.selenium.WebDriver;
import rozetka.pages.popups.AuthPopUp;

public class PreLoginPageHeader extends BasePageHeader{
    WebDriver webDriver;

    public PreLoginPageHeader(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

    public AuthPopUp selectMenuItemOrderTracking(){
        menuItemOrderTraking.click();
        return new AuthPopUp(webDriver);
    }
}
