package jweather;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CenterPanel extends JPanel {
    JLabel tempOutput = new JLabel("0", SwingConstants.CENTER);
    JLabel maxTemp = new JLabel("0", SwingConstants.CENTER);
    JLabel feelsLike = new JLabel("0", SwingConstants.CENTER);
    JLabel minTemp = new JLabel("0", SwingConstants.CENTER);

    // Constructor
    public CenterPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Temp label name
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.25;
        add(new JLabel("Temp ", SwingConstants.CENTER), gbc);

        // Temp label output
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.25;
        add(tempOutput, gbc);

        // MaxTemp label name
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.25;
        add(new JLabel("Max Temp", SwingConstants.CENTER), gbc);

        // MaxTemp label output
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.25;
        add(maxTemp, gbc);


        // Second column
        // FeelsLike label name
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.25;
        add(new JLabel("Feels Like", SwingConstants.CENTER), gbc);

        // FeelsLike label output
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.25;
        add(feelsLike, gbc);

        // MinTemp label name
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.25;
        add(new JLabel("Min Temp", SwingConstants.CENTER), gbc);

        // MinTemp label output
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.25;
        add(minTemp, gbc);

        // Third column, image spanning 4 rows
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/yellow-sun-16526.png")));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(imageLabel, gbc);
    }

    public void setTempOutput(String temp) {
        this.tempOutput.setText(temp);
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp.setText(maxTemp);
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike.setText(feelsLike);
    }

    public void setMinTemp(String minTemp) {
        this.minTemp.setText(minTemp);
    }
}