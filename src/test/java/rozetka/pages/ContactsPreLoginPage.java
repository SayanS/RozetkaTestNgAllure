package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PreLoginPageHeader;

public class ContactsPreLoginPage extends PreLoginPageHeader {
    private WebDriver webDriver;

    public ContactsPreLoginPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = getBaseUrlForCurrentLocalization() + "/contacts/";
        this.webDriver = webDriver;
    }
}
