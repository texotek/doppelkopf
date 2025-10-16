package de.dd.ui;

import java.awt.Color;
import java.awt.Point;
import javax.swing.*;

public class MainView extends JFrame {
    public MainView() {
        this.setLocation(new Point(400, 300));
        this.setSize(1200, 800);

        this.getContentPane().setBackground(new Color(255 << 16 | 64 << 8 | 128));
        this.setJMenuBar(null);

        this.setVisible(true);
    }
}
