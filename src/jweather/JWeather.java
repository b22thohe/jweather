package jweather;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Properties;
import java.util.Scanner;
import org.json.JSONObject;

@SuppressWarnings("SpellCheckingInspection")
public class JWeather {
    private static final String API_KEY = loadApiKey();
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String CONFIG_FILE = "src/jweather/config.properties";

    public static void main(String[] args) {
        // Ask the user to input city name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        scanner.close();

        // Make request for data for chosen city
        fetchWeather(city);
    }

    private static void fetchWeather(String city) {
        try {
            // Prepare the request URL
            String url = BASE_URL + city + "&appid=" + API_KEY + "&units=metric";
            // Create a new Http client
            HttpClient client = HttpClient.newHttpClient();
            // Create the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Send the request and store the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // If request is ok...
            if (response.statusCode() == 200) {
                // ...parse the response
                parseWeather(response.body());
            } else {
                System.out.println("Error: Unable to fetch weather data. Check city name or API key.");
            }
        } catch (IOException io) {
            System.out.println("Error: Unable to fetch weather data (IOException).");
        } catch (InterruptedException ie) {
            System.out.println("Error: Unable to fetch weather data (InterruptedException).");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void parseWeather(String responseBody) {
        // Format the response as JSON
        JSONObject json = new JSONObject(responseBody);
        // Get city name
        String cityName = json.getString("name");
        // Get the data associated to key 'main'
        JSONObject main = json.getJSONObject("main");
        // Save the temperature as Double
        double temperature = main.getDouble("temp");
        // Save humidity as int
        int humidity = main.getInt("humidity");
        // Finally, save the weather description
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");

        System.out.println("\nWeather in " + cityName + ":");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Condition: " + description);
    }

    /**
     * Loads the Openweathermap.org API key from properties file
     * NOTE! You need to register at Openweathermap.org to get your own API key.
     * Then just rename the config.properties.template file to config.properties
     * and add your key to the file.
     * @return String containing the API key
     */
    private static String loadApiKey() {

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
