package me.simonhaasnoot.geinigspel.game.frame;

import me.simonhaasnoot.geinigspel.Values;
import me.simonhaasnoot.geinigspel.game.GameStateManager;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    /**
     * The game state manager.
     */
    private GameStateManager gsm;

    /**
     * Constructor.
     * This immediately shows the game frame as soon as it has been created.
     *
     * @param gsm The game state manager instance.
     */
    public GameFrame(GameStateManager gsm) {
        this(true);

        // Set the game state manager
        this.gsm = gsm;
    }

    /**
     * Constructor.
     *
     * @param show True to immediately show the frame after it has been created.
     */
    public GameFrame(boolean show) {
        this.setTitle("Made by Simon Haasnoot");
        this.setResizable(false);
        this.setPreferredSize(new Dimension(Values.frameX, Values.frameY));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void buildGameFramePanel() {
        // Create the game frame panel
        GameFramePanel panel = new GameFramePanel(this.gsm);

        // Add the panel to the frame
        this.add(panel);
    }

    /**
     * Get the game state manager.
     *
     * @return Game state manager instance.
     */
    public GameStateManager getGameStateManager() {
        return this.gsm;
    }
}
