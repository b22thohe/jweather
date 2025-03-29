package jweather;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JLabel longitudeDataLabel;
    private JLabel latitudeDataLabel;

    // Constructor
    public MainPanel() {
        // Create the panel
        this.setBorder(BorderFactory.createTitledBorder("Weather data"));
        JLabel longitudeLabel = new JLabel("Longitude: ");
        this.add(longitudeLabel);
        longitudeDataLabel = new JLabel("XX.XXXX");
        this.add(longitudeDataLabel);
        JLabel latitudeLabel = new JLabel("Latitude: ");
        this.add(latitudeLabel);
        latitudeDataLabel = new JLabel("XX.XXXX");
        this.add(latitudeDataLabel);
    }

    public void updateLongitude(double longitude) {
        String longitudeText = String.valueOf(longitude);
        longitudeDataLabel.setText(longitudeText);
    }

    public void updateLatitude(double latitude) {
        String latitudeText = String.valueOf(latitude);
        latitudeDataLabel.setText(latitudeText);
    }


}
