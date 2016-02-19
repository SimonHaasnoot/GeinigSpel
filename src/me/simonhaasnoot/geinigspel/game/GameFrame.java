package me.simonhaasnoot.geinigspel.game;

import me.simonhaasnoot.geinigspel.Values;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    /**
     * Constructor.
     */
    public GameFrame() {
        this.setTitle("Made by Simon Haasnoot");
        this.setResizable(false);
        this.setPreferredSize(new Dimension(Values.frameX, Values.frameY));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
