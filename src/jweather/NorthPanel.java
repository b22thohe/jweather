package jweather;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NorthPanel extends JPanel {
    JLabel dateLabel = new JLabel();
    JLabel townLabel = new JLabel();

    // Constructor
    public NorthPanel() {
        LocalDate currentDate = LocalDate.now();
        dateLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        dateLabel.setText(currentDate.toString());
        this.add(dateLabel);

        townLabel.setText("Skinnskatteberg");
        townLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        this.add(townLabel);
    }

    public void setDateLabel(String date) {
        dateLabel.setText(date);
    }

    public void setTownLabel(String townName) {
        townLabel.setText(townName);
    }
}
