package rozetka.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import rozetka.dataProviders.DataProviders;
import rozetka.pages.BasePage;
import rozetka.pages.HomePage;
import rozetka.utils.CustomTestListener;

import java.util.List;
import java.util.Map;
@Listeners({CustomTestListener.class})
@Test(dataProviderClass = DataProviders.class)
public class SmokeTests extends BaseTests{

//    @Test(dataProvider = "headerMenuItems", enabled = true, groups = {"run"})
//    public void checkHeaderMenuLinks(Map<String,String> headerMenuTestData){
//        HomePage homePage=openHomePage();
//        FaqPage faqPage=homePage.getPageHeader().selectMenuItem(headerMenuTestData.get("itemName"));
//        faqPage.enssureThatTitleIs(headerMenuTestData.get("pageTitle"));
//    }

    @Test(dataProvider = "headerMenuTestDataForCurrentLocalization", enabled = true, groups = {"run"})
    public void checkHeaderMenuLinks(List<Map<String, String>> headerMenuTestData){
        for(int i=0; i<headerMenuTestData.size();i++) {
            openHomePage().selectMenuItem(headerMenuTestData.get(i).get("itemName"));
        }
        }

//        FaqPage faqPage=homePage.getPageHeader().selectMenuItem(headerMenuTestData.get("itemName"));
//        faqPage.enssureThatTitleIs(headerMenuTestData.get("pageTitle"));
    }

//    @Test(enabled = true, groups = {"run"})
//    public void checkLogInViaOrderTrackingItemOfHeaderMenu(){
//        HomePage homePage=openHomePage();
//        homePage.getPageHeader().se
//    }
}
