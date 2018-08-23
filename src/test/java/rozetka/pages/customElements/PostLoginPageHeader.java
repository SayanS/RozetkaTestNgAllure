package rozetka.pages.customElements;

import org.openqa.selenium.WebDriver;
import rozetka.pages.profilepages.MyOrdersPage;

public class PostLoginPageHeader extends BasePageHeader{
    WebDriver webDriver;

    public PostLoginPageHeader(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

    public MyOrdersPage selectMenuItemOrderTracking(){
        menuItemOrderTraking.click();
        return new MyOrdersPage(webDriver);
    }
}
