package jweather;

import javax.swing.*;

public class SouthPanel extends JPanel {
    JLabel windLabel = new JLabel("Wind: ");
    JLabel windLabelOutput = new JLabel("0");
    JLabel humidityLabel = new JLabel("Humidity: ");
    JLabel humidityLabelOutput = new JLabel("0");

    // Constructor
    public SouthPanel() {
        add(windLabel);
        add(windLabelOutput);
        add(humidityLabel);
        add(humidityLabelOutput);
    }

    public void setWindLabelOutput(String windSpeed) {
        this.windLabelOutput.setText(windSpeed);
    }

    public void setHumidityLabelOutput(String humidity) {
        this.humidityLabelOutput.setText(humidity);
    }
}
