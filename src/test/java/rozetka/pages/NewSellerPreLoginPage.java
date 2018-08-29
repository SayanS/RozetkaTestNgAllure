package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PreLoginPageHeader;

public class NewSellerPreLoginPage extends PreLoginPageHeader {
    WebDriver webDriver;
    public NewSellerPreLoginPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

}
