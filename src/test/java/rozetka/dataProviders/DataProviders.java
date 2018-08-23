package rozetka.dataProviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import rozetka.utils.FilesUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviders {

    @DataProvider(name="headerMenuItems")
    public static Object[][] headerMenuItems() {
        Object[][] headerMenuExpectedResults;
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Map<String, String>>> headerMenuAllLocalization;
        List<Map<String, String>> results = new ArrayList<>();
        try {
            headerMenuAllLocalization = mapper.readValue(new File("./src/test/resources/data/mainMenuItems.json"), new TypeReference<Map<String, List<Map<String, String>>>>() {
            });
            results = headerMenuAllLocalization.get(FilesUtils.getConfigProperty("localization"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        headerMenuExpectedResults = new Object[results.size()][1];
        for (int i = 0; i < results.size(); i++) {
            headerMenuExpectedResults[i][0] = new Object();
            headerMenuExpectedResults[i][0] = results.get(i);
        }
        return headerMenuExpectedResults;
    }
}
