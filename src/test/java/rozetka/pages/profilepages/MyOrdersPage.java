package rozetka.pages.profilepages;

import org.openqa.selenium.WebDriver;

public class MyOrdersPage extends BaseProfilePage {
    WebDriver webDriver;
    public MyOrdersPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }
}
