package jweather;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JLabel weatherPlaceholder;
    private JLabel cityName;
    private JLabel temperature;
    private JLabel feelLike;
    private JLabel windSpeed;
    private JLabel lowTemp;
    private JLabel highTemp;
    private JLabel humidity;
    private JLabel weatherMain;
    private JLabel weatherDescription;

    // Constructor
    public MainPanel() {
        // Create the constraints for GridbagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        // Set a GridLayout for this panel
        GridBagLayout thisLayout = new GridBagLayout();
        this.setLayout(thisLayout);
        // Create a panel border
        this.setBorder(BorderFactory.createTitledBorder("Weather data"));
        // WEATHER ICON
        ImageIcon weatherIcon = new ImageIcon(getClass().getResource("/images/yellow-sun-16526.png"));
        weatherPlaceholder = new JLabel(weatherIcon);
        addComponent(weatherPlaceholder, this, thisLayout, gbc,0,0,1,1);
        // CITY NAME
        cityName = new JLabel("");
        cityName.setFont(new Font("Tahoma", Font.BOLD, 24));
        addComponent(cityName, this, thisLayout, gbc, 1, 0,1,1);
        // TEMPERATURE
        temperature = new JLabel("XX°");
        temperature.setFont(new Font("Tahoma", Font.BOLD, 18));
        addComponent(temperature, this, thisLayout, gbc, 1, 1,1,1);
        // FEELS LIKE TEMPERATURE
        feelLike = new JLabel("Känns som: XX°");
        feelLike.setFont(new Font("Tahoma", Font.PLAIN, 12));
        addComponent(feelLike, this, thisLayout, gbc, 1, 2,1,1);
        // WIND SPEED
        windSpeed = new JLabel("Vindstyrka: Orkan");
        windSpeed.setFont(new Font("Tahoma", Font.PLAIN, 12));
        addComponent(windSpeed, this, thisLayout, gbc, 0, 3,1,1);
        // LOWEST TEMPERATURE
        lowTemp = new JLabel("Lägsta temperatur: XX°");
        lowTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
        addComponent(lowTemp, this, thisLayout, gbc, 1, 3,1,1);
        // HUMIDITY
        humidity = new JLabel("Luftfuktighet: XX%");
        humidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
        addComponent(humidity, this, thisLayout, gbc, 0, 4,1,1);
        // HIGHEST TEMPERATURE
        highTemp = new JLabel("Högsta temperatur: XX°");
        highTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
        addComponent(highTemp, this, thisLayout, gbc, 1, 4,1,1);
        // WEATHER TYPE
        weatherMain = new JLabel("Molnigt");
        weatherMain.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addComponent(weatherMain, this, thisLayout, gbc, 0, 5,1,1);
        // WEATHER DESCRIPTION
        weatherDescription = new JLabel("Just nu ser vi: Uppsprickande moln");
        weatherDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addComponent(weatherDescription, this, thisLayout, gbc, 1, 5,1,1);
    }

    public void addComponent(Component component, Container container, GridBagLayout layout, GridBagConstraints gbc, int gridx, int gridy, int gridwidth, int gridheight) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;

        layout.setConstraints(component, gbc);
        container.add(component);
    }

    public void setWeatherPlaceholder(JLabel weatherPlaceholder) {
        this.weatherPlaceholder = weatherPlaceholder;
    }

    public void setCityName(String cityName) {
        this.cityName.setText(cityName);
    }

    public void setTemperature(int temperature) {
        this.temperature.setText(temperature + "°");
    }

    public void setFeelLike(int feelLike) {
        this.feelLike.setText(feelLike + "°");
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed.setText("Vindstyrka: " + windSpeed);
    }

    public void setLowTemp(int lowTemp) {
        this.lowTemp.setText(lowTemp + "°");
    }

    public void setHighTemp(int highTemp) {
        this.highTemp.setText(highTemp + "°");
    }

    public void setHumidity(int humidity) {
        this.humidity.setText(humidity + "%");
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain.setText(weatherMain);
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription.setText("Just nu ser vi: " + weatherDescription);
    }
}
