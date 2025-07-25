package jweather;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public class Controller {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final MainView gui;
    private final Model model;
    private final String apiKey;
    private String requestedCity;
    private String cityName;
    private double longitude;
    private double latitude;
    private String weatherMain;
    private String weatherDescription;
    private String weatherIcon;
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
        requestedCity = "";

        setSearchActionListener();

    }

    private void setSearchActionListener() {
        ActionListener searchAction = new ActionListener() {

            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                requestedCity = gui.mainForm.getSearchFieldText();
                System.out.println(requestedCity);
                getWeatherData(requestedCity);
                try {
                    displayWeatherData();
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        gui.mainForm.getSearchField().addActionListener(searchAction);
        gui.mainForm.getSearchButton().addActionListener(searchAction);
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
                // ...parse the response and store in appropriate variables
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
        @SuppressWarnings("SpellCheckingInspection") JSONObject coord = json.getJSONObject("coord");
        longitude = coord.getDouble("lon");
        latitude = coord.getDouble("lat");
        weatherMain = json.getJSONArray("weather").getJSONObject(0).getString("main");
        weatherDescription = json.getJSONArray("weather").getJSONObject(0).getString("description");
        weatherIcon = json.getJSONArray("weather").getJSONObject(0).getString("icon");
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
     * Read more: <a href="https://www.spc.noaa.gov/faq/tornado/beaufort.html">Wind speed scale</a>
     * @param windSpeed integer value
     * @return String
     */
    private String getWindSpeedName(int windSpeed) {
        if (windSpeed <= 0.51) {
            return "Calm";
        } else if (windSpeed >= 0.51 && windSpeed <= 1.54) {
            return "Light Breeze";
        } else if (windSpeed >= 1.54 && windSpeed <= 8.2) {
            return "Moderate Breeze";
        } else if (windSpeed >= 8.2 && windSpeed <= 13.9) {
            return "Strong Breeze";
        } else if (windSpeed >= 13.9 && windSpeed <= 20.6) {
            return "Gale";
        } else if (windSpeed >= 20.6 && windSpeed <= 28.3) {
            return "Storm";
        } else {
            return "End of the world";
        }
    }

    public void displayWeatherData() throws MalformedURLException {
        SwingUtilities.invokeLater(() -> {
            try {
                // Set all the labels
                LocalDate today = LocalDate.now();
                gui.mainForm.setDateLabel(String.valueOf(today));
                gui.mainForm.setCityLabel(cityName);
                gui.mainForm.setTempOutput(String.valueOf(temp));
                gui.mainForm.setFeelsLike(String.valueOf(feelsLike));
                gui.mainForm.setMaxTemp(String.valueOf(maxTemp));
                gui.mainForm.setMinTemp(String.valueOf(minTemp));
                gui.mainForm.setWindLabelOutput(windSpeedName);
                gui.mainForm.setHumidityLabelOutput(String.valueOf(humidity));

                // Set icon
                URL iconUrl = getWeatherIconUrl(weatherIcon);
                gui.mainForm.setWeatherImageLabel(iconUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }

    private URL getWeatherIconUrl(String weatherIcon) throws MalformedURLException {
        String urlString = "https://openweathermap.org/img/wn/" + weatherIcon + "@4x.png";
        return new URL(urlString);
    }
}
