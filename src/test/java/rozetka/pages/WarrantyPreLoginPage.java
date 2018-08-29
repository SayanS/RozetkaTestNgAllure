package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PreLoginPageHeader;

public class WarrantyPreLoginPage extends PreLoginPageHeader {
    WebDriver webDriver;
    public WarrantyPreLoginPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }
}
