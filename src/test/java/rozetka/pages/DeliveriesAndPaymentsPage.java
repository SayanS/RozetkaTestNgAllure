package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PageHeader;
import rozetka.utils.FilesUtils;

public class DeliveriesAndPaymentsPage extends PageHeader {
    private WebDriver webDriver;

    public DeliveriesAndPaymentsPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = FilesUtils.getBaseUrl() + "/payments-and-deliveries/";
        this.webDriver = webDriver;
    }

}
