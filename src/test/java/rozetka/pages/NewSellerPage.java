package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PageHeader;

public class NewSellerPage extends PageHeader {
    WebDriver webDriver;
    public NewSellerPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

}
