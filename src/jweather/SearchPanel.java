package jweather;

import javax.swing.*;

public class SearchPanel extends JPanel {
    private JLabel searchLabel;
    private JTextField searchField;

    // Constructor
    public SearchPanel() {
        searchLabel = new JLabel("Enter City Name: ");
        this.add(searchLabel);
        searchField = new JTextField();
        this.add(searchField);
    }
}
