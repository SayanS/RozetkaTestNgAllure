package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PreLoginPageHeader;
import rozetka.utils.FilesUtils;

public class DeliveriesAndPaymentsPreLoginPage extends PreLoginPageHeader {
    private WebDriver webDriver;

    public DeliveriesAndPaymentsPreLoginPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = FilesUtils.getBaseUrl() + "/payments-and-deliveries/";
        this.webDriver = webDriver;
    }

}
