package jweather;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JLabel cityName;
    private JLabel longitudeDataLabel;
    private JLabel latitudeDataLabel;
    private JLabel mainWeatherDataLabel;
    private JLabel detailedWeatherDataLabel;
    private JLabel temperatureLabel;

    // Constructor
    public MainPanel() {
        // Create the panel
        this.setBorder(BorderFactory.createTitledBorder("Weather data"));
        cityName = new JLabel("");
        cityName.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.add(cityName);
        JLabel longitudeLabel = new JLabel("Longitude: ");
        this.add(longitudeLabel);
        longitudeDataLabel = new JLabel("XX.XXXX");
        this.add(longitudeDataLabel);
        JLabel latitudeLabel = new JLabel("Latitude: ");
        this.add(latitudeLabel);
        latitudeDataLabel = new JLabel("XX.XXXX");
        this.add(latitudeDataLabel);
        JLabel mainWeatherLabel = new JLabel("Vädret just nu: ");
        this.add(mainWeatherLabel);
        mainWeatherDataLabel = new JLabel("");
        this.add(mainWeatherDataLabel);
        temperatureLabel = new JLabel("");
        this.add(temperatureLabel);
    }

    public void updateCityName(String cityName) {
        this.cityName.setText(cityName);
    }

    public void updateLongitude(double longitude) {
        String longitudeText = String.valueOf(longitude);
        longitudeDataLabel.setText(longitudeText);
    }

    public void updateLatitude(double latitude) {
        String latitudeText = String.valueOf(latitude);
        latitudeDataLabel.setText(latitudeText);
    }

    public void updateMainWeather(String mainWeather) {
        mainWeatherDataLabel.setText(mainWeather);
    }

    public void updateTemperatureLabel(int temp, int feelsLike, int minTemp, int maxTemp) {
        String temperatureText = "Det är just nu " + temp + " och det känns som " + feelsLike + ". Det senaste dygnet har" +
                " den lägsta temperaturen varit " + minTemp + " och den högsta temperaturen har varit " + maxTemp + ".";
        temperatureLabel.setText(temperatureText);
    }
}
