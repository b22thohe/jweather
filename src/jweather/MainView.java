package jweather;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    NorthPanel northPanel = new NorthPanel();
    CenterPanel centerPanel = new CenterPanel();
    SouthPanel southPanel = new SouthPanel();
    SearchPanel searchPanel = new SearchPanel();

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
        this.add(northPanel, BorderLayout.NORTH);

        this.add(centerPanel, BorderLayout.CENTER);

        this.add(southPanel, BorderLayout.SOUTH);

        this.add(searchPanel, BorderLayout.EAST);

        // Display the window
        this.setVisible(true);

        revalidate();
        repaint();
    }
}
