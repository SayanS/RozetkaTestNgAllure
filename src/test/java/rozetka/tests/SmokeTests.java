package rozetka.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import rozetka.dataProviders.DataProviders;
import rozetka.pages.HomePage;
import rozetka.utils.CustomTestListener;
@Listeners({CustomTestListener.class})
@Test(dataProviderClass = DataProviders.class)
public class SmokeTests extends BaseTests{

//    @Test(dataProvider = "headerMenuItems", enabled = true, groups = {"run"})
//    public void checkHeaderMenuLinks(Map<String,String> headerMenuTestData){
//        HomePage homePage=openHomePage();
//        FaqPage faqPage=homePage.getPageHeader().selectMenuItem(headerMenuTestData.get("itemName"));
//        faqPage.enssureThatTitleIs(headerMenuTestData.get("pageTitle"));
//    }

    @Test(dataProvider = "invalidUserCredentials", enabled = true, groups = {"run"})
    public void signInWithInvalidCredentials(String login, String password){
        HomePage homePage=openHomePage();
        homePage.selectPreLoginHeaderMenuOrderTracking()
                .signInFailed(login,password).ensureThatTitleIs("Вход в интернет-магазин");
        homePage.ensureThatHeaderUserTitleIs("войдите в личный кабинет");
    }


}
