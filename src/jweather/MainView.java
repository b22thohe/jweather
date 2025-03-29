package jweather;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    MainPanel mainPanel;
    SearchPanel searchPanel;

    // Constructor
    public MainView(String title) {
        super(title);

        // Enable window buttons functionality
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size and preferred size of application window
        this.setSize(600, 400);
        this.setPreferredSize(new Dimension(600, 400));
        // Set layout manager of frame
        this.setLayout(new BorderLayout());

        // Add panels to gui
        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);
        searchPanel = new SearchPanel();
        this.add(searchPanel, BorderLayout.NORTH);

        // Display the window
        this.setVisible(true);

        revalidate();
        repaint();
    }
}
