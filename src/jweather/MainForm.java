package jweather;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainForm extends JPanel {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JPanel bottomPanel;
    private JLabel searchLabel;
    private JLabel tempLabel;
    private JLabel feelsLikeLabel;
    private JLabel tempOutput;
    private JLabel feelsLikeOutput;
    private JLabel minTempLabel;
    private JLabel maxTempLabel;
    private JLabel minTempOutput;
    private JLabel maxTempOutput;
    private JLabel windLabel;
    private JLabel humidityLabel;
    private JLabel windOutput;
    private JLabel humidityOutput;
    private JLabel dateLabel;
    private JLabel cityLabel;
    private JLabel weatherImageLabel;

    public MainForm() {
        ResourceBundle bundle = ResourceBundle.getBundle("resources/messages");
        dateLabel.setText(bundle.getString("date_label"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getSearchFieldText() {
        return searchField.getText();
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setDateLabel(String date) {
        dateLabel.setText(date);
    }

    public void setCityLabel(String townName) {
        cityLabel.setText(townName);
    }

    public void setTempOutput(String temp) {
        this.tempOutput.setText(temp);
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTempOutput.setText(maxTemp);
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLikeOutput.setText(feelsLike);
    }

    public void setMinTemp(String minTemp) {
        this.minTempOutput.setText(minTemp);
    }

    public void setWindLabelOutput(String windSpeed) {
        this.windOutput.setText(windSpeed);
    }

    public void setHumidityLabelOutput(String humidity) {
        this.humidityOutput.setText(humidity);
    }

    public void setWeatherImageLabel(URL weatherIcon) {
        ImageIcon icon = new ImageIcon(weatherIcon);
        this.weatherImageLabel.setIcon(icon);
    }
}
