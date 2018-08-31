package rozetka.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import rozetka.dataProviders.DataProviders;
import rozetka.pages.HomePage;
import rozetka.pages.MyOrdersPage;
import rozetka.pages.customElements.PostLoginPageHeader;
import rozetka.pages.customElements.PreLoginPageHeader;
import rozetka.pages.popups.AuthPopUp;
import rozetka.pojo.Document;
import rozetka.utils.CustomTestListener;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

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
        MyOrdersPage myOrdersPage = authPopUp.signInWithValidCredentials(login, password);
        myOrdersPage.ensureThatCurrentUrlIsCorrect();
        myOrdersPage.ensureThatTitleIs("Мои заказы");
        PostLoginPageHeader postLoginPageHeader = (PostLoginPageHeader) myOrdersPage.getPageHeader();
        postLoginPageHeader.ensureThatPostloginHeaderUserTitleIs(userName);
    }



    @Test(enabled = true, groups = {"pending"})
    public void getThreeTheMostSimilarDocuments() {
        Map<String, Integer> resultRating = new HashMap<>();
        Integer currentRating=0;
        ObjectMapper mapper=new ObjectMapper();
        List<Document> docsFeatures= null;

        try {
            docsFeatures = mapper.readValue(new File("./src/test/resources/data/documents.json"), new TypeReference<List<Document>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < docsFeatures.size(); i++) {
            for (int j = i + 1; j < docsFeatures.size(); j++) {
                currentRating=docsFeatures.get(i).getSimilarityLavelFor(docsFeatures.get(j));
                resultRating.put(i+"/"+j, currentRating);
            }
        }
        Stream<Map.Entry<String,Integer>> sorted = resultRating.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        Set<String> resDocs=new HashSet<>();
        Object[] result= sorted.toArray();

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
            if(resDocs.size()<3) {
                resDocs.add(result[i].toString().split("=")[0].split("/")[0]);
            }
            if(resDocs.size()<3){
                resDocs.add(result[i].toString().split("=")[0].split("/")[1]);
            }
        }

        System.out.println("3 documents that highest similarity:");
        resDocs.forEach(doc->System.out.println(doc));
        int i=0;
    }

}
