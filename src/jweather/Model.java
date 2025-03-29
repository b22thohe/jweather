package jweather;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Model {
    private static final String CONFIG_FILE = "src/jweather/config.properties";

    // Constructor
    public Model() {

    }

    public String loadApiKey() {

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
            return properties.getProperty("api_key");
        } catch (IOException e) {
            System.out.println("Error loading API key: " + e.getMessage());
            return null;
        }
    }
}
