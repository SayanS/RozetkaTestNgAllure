package rozetka.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public final class FilesUtils {
    public static String getProperty(String pathFile, String keyProperty) {
        Properties configProp = new Properties();
        try {
            InputStream input = new FileInputStream(pathFile);
            configProp.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProp.getProperty(keyProperty);
    }

    public static String getConfigProperty(String keyProperty) {
        Properties configProp = new Properties();
        String pathFile="./src/test/resources/config.properties";
        try {
            InputStream input = new FileInputStream(pathFile);
            configProp.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configProp.getProperty(keyProperty);
    }

    public static <T> List<T> getPoJoFromJSON(String pathJsonFile, Class<T> pojo){
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.readValue(new File(pathJsonFile), new TypeReference<List<T>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getBaseUrl(){
        return FilesUtils.getConfigProperty("baseUrl")+"."+FilesUtils.getConfigProperty("localization");
    }

}

