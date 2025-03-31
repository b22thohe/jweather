package jweather;

import javax.swing.*;

public class SearchPanel extends JPanel {
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;

    // Constructor
    public SearchPanel() {
        searchLabel = new JLabel("Ange stad: ");
        this.add(searchLabel);
        searchField = new JTextField(15);
        this.add(searchField);
        searchButton = new JButton("Sök");
        this.add(searchButton);
    }

    public String getSearchFieldText() {
        return searchField.getText();
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
