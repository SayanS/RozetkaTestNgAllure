package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PreLoginPageHeader;
import rozetka.utils.FilesUtils;

public class CreditPreLoginPage extends PreLoginPageHeader {
    private WebDriver webDriver;

    public CreditPreLoginPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = FilesUtils.getBaseUrl() + "/credit/";
        this.webDriver = webDriver;
    }
}
