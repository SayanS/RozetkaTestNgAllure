package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PreLoginPageHeader;
import rozetka.utils.FilesUtils;

public class ContactsPreLoginPage extends PreLoginPageHeader {
    private WebDriver webDriver;

    public ContactsPreLoginPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = FilesUtils.getBaseUrl() + "/contacts/";
        this.webDriver = webDriver;
    }
}
