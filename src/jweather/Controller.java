package jweather;

import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Controller {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private MainView gui;
    private Model model;
    private final String apiKey;
    private String requestedCity;
    private String cityName;
    private double longitude;
    private double latitude;
    private String weatherMain;
    private String weatherDescription;
    private int temp;
    private int feelsLike;
    private int minTemp;
    private int maxTemp;
    private int humidity;
    private int windSpeed;
    private String windSpeedName;

    // Constructor
    public Controller(MainView gui, Model model) {
        this.gui = gui;
        this.model = model;
        apiKey  = model.loadApiKey();
        requestedCity = new String();

        // If SearchPanel exists, then attach action listener to search button
        if (gui.searchPanel != null) {
            setSearchActionListener();
        }
    }

    private void setSearchActionListener() {
        gui.searchPanel.getSearchButton().addActionListener(
            new ActionListener() {

                /**
                 * Invoked when an action occurs.
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    requestedCity = gui.searchPanel.getSearchFieldText();
                    System.out.println(requestedCity);
                    getWeatherData(requestedCity);
                    displayWeatherData();
                }
            }
        );
    }

    public void getWeatherData(String city) {
        try {
            // Prepare the request URL
            String url = BASE_URL + city + "&appid=" + apiKey + "&units=metric";
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

    public void parseWeather(String responseBody) {
        // Format the response as JSON
        JSONObject json = new JSONObject(responseBody);

        // Extract all useful data
        cityName = json.getString("name");
        JSONObject coord = json.getJSONObject("coord");
        longitude = coord.getDouble("lon");
        latitude = coord.getDouble("lat");
        weatherMain = json.getJSONArray("weather").getJSONObject(0).getString("main");
        weatherDescription = json.getJSONArray("weather").getJSONObject(0).getString("description");
        JSONObject main = json.getJSONObject("main");
        temp = (int) Math.round(main.getDouble("temp"));
        feelsLike = (int) Math.round(main.getDouble("feels_like"));
        minTemp = (int) Math.round(main.getDouble("temp_min"));
        maxTemp = (int) Math.round(main.getDouble("temp_max"));
        humidity = main.getInt("humidity");
        JSONObject wind = json.getJSONObject("wind");
        windSpeed = (int) Math.round(wind.getDouble("speed"));
        windSpeedName = getWindSpeedName(windSpeed);

        // String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
    }

    /**
     * Get the name of windSpeed value
     * Read more: https://www.spc.noaa.gov/faq/tornado/beaufort.html
     * @param windSpeed
     * @return String
     */
    private String getWindSpeedName(int windSpeed) {
        if (windSpeed <= 0.2) {
            return "Vindstilla";
        } else if (windSpeed >= 0.3 && windSpeed <= 3.3) {
            return "Svag vind";
        } else if (windSpeed >= 3.4 && windSpeed <= 7.9) {
            return "Måttlig vind";
        } else if (windSpeed >= 8 && windSpeed <= 13.8) {
            return "Frisk vind";
        } else if (windSpeed >= 13.9 && windSpeed <= 24.4) {
            return "Hård vind";
        } else if (windSpeed >= 24.5 && windSpeed <= 32.6) {
            return "Storm";
        } else if (windSpeed > 32.7) {
            return "Orkan";
        } else {
            return "End of the world";
        }
    }

    public void displayWeatherData() {
        gui.mainPanel.updateCityName(cityName);
        gui.mainPanel.updateLatitude(latitude);
        gui.mainPanel.updateLongitude(longitude);
        gui.mainPanel.updateMainWeather(weatherMain);
        gui.mainPanel.updateTemperatureLabel(temp, feelsLike, minTemp, maxTemp);
    }
}
