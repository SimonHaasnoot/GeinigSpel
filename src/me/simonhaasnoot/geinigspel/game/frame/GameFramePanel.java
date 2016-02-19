package me.simonhaasnoot.geinigspel.game.frame;

import me.simonhaasnoot.geinigspel.game.GameStateManager;

import javax.swing.*;
import java.awt.*;

public class GameFramePanel extends JPanel {

    /**
     * Game state manager instance.
     */
    private GameStateManager gsm;

    /**
     * Constructor.
     *
     * @param gsm Game state manager instance.
     */
    public GameFramePanel(GameStateManager gsm) {
        this.gsm = gsm;
    }

    /**
     * Paint the panel.
     *
     * @param g Graphics.
     */
    public void paintComponent(Graphics g) {
        // Paint the super
        super.paintComponent(g);

        // Create a 2D graphics object
        Graphics2D g2d = (Graphics2D) g;

        // Paint all game objects
        this.gsm.paintGameObjects(g2d);
    }
}
