package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PageHeader;
import rozetka.utils.FilesUtils;

public class ContactsPage extends PageHeader {
    private WebDriver webDriver;

    public ContactsPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = FilesUtils.getBaseUrl() + "/contacts/";
        this.webDriver = webDriver;
    }
}
