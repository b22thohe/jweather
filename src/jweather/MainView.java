package jweather;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    MainForm mainForm = new MainForm();

    // Constructor
    public MainView(String title) {
        super(title);

        // Enable window buttons functionality
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size and preferred size of application window
        this.setSize(600, 400);
        this.setPreferredSize(new Dimension(600, 400));

        // Add panels to gui
        this.setContentPane(mainForm.getMainPanel());

        // Display the window
        this.setVisible(true);

        revalidate();
        repaint();
    }
}
