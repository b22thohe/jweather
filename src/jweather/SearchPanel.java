package jweather;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;

    // Constructor
    public SearchPanel() {
        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        searchLabel = new JLabel("Ange stad: ");
        this.add(searchLabel);

        searchField = new JTextField(15);
        Dimension pref = searchField.getPreferredSize();
        searchField.setMaximumSize(new Dimension(Integer.MAX_VALUE, pref.height));
        this.add(searchField);

        searchButton = new JButton("Sök");
        this.add(searchButton);
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
}
