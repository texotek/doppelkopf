package de.dd.client.ui;

import java.awt.Color;
import java.awt.Point;

import javax.swing.*;

public class MainView extends JFrame {
    public MainView() {
        this.setLocation(new Point(400, 300));
        this.setSize(1200, 800);
        this.getContentPane().setBackground(new Color(0xFF0000));

        this.getContentPane().setBackground(new Color(255 << 16 | 64 << 8 | 128));
        this.setJMenuBar(null);
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public String askForName() {
        String name = (String) JOptionPane.showInputDialog(
                this,
                "Name",
                "Enter your name",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");

        return name == null ? "" : name.trim();
    }

    public void main() {
        showWindow();
    }
}
