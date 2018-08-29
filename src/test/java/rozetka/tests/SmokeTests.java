package rozetka.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import rozetka.dataProviders.DataProviders;
import rozetka.pages.HomePage;
import rozetka.pages.MyOrdersPage;
import rozetka.pages.customElements.PostLoginPageHeader;
import rozetka.pages.customElements.PreLoginPageHeader;
import rozetka.pages.popups.AuthPopUp;
import rozetka.utils.CustomTestListener;

@Listeners({CustomTestListener.class})
@Test(dataProviderClass = DataProviders.class)
public class SmokeTests extends BaseTests {

//    @Test(dataProvider = "headerMenuItems", enabled = true, groups = {"run"})
//    public void checkHeaderMenuLinks(Map<String,String> headerMenuTestData){
//        HomePage homePage=openHomePage();
//        FaqPreLoginPage faqPage=homePage.getPreLoginPageHeader().selectMenuItem(headerMenuTestData.get("itemName"));
//        faqPage.enssureThatTitleIs(headerMenuTestData.get("pageTitle"));
//    }

    @Test(dataProvider = "invalidUserCredentials", enabled = true, groups = {"run"})
    public void checkInabilityToSignInWithInvalidCredentials(String login, String password) {
        HomePage homePage = openHomePage();
        AuthPopUp authPopUp = homePage.getPageHeader().selectHeaderMenuItemOrderTracking();
        authPopUp.signInWithInvalidCredentials(login, password).ensureThatTitleIs("Вход в интернет-магазин");
        homePage.ensureThatCurrentUrlIsCorrect();
        PreLoginPageHeader preLoginPageHeader = (PreLoginPageHeader) homePage.getPageHeader();
        preLoginPageHeader.ensureThatHeaderPreloginUserTitleIs("войдите в личный кабинет");
    }

    @Test(dataProvider = "validUserCredentials", enabled = true, groups = {"run"})
    public void checkAbilityToSignIUnWithValidCredentials(String login, String password, String userName) {
        AuthPopUp authPopUp = openHomePage().getPageHeader()
                .selectHeaderMenuItemOrderTracking();
       MyOrdersPage myOrdersPage=authPopUp.signInWithValidCredentials(login, password);
       myOrdersPage.ensureThatCurrentUrlIsCorrect();
       myOrdersPage.ensureThatTitleIs("Мои заказы");
       PostLoginPageHeader postLoginPageHeader= (PostLoginPageHeader) myOrdersPage.getPageHeader();
       postLoginPageHeader.ensureThatPostloginHeaderUserTitleIs(userName);
    }


}
