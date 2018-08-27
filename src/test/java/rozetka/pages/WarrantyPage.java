package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PageHeader;

public class WarrantyPage extends PageHeader {
    WebDriver webDriver;
    public WarrantyPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }
}
