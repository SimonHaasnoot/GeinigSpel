package me.simonhaasnoot.geinigspel.game.frame;

import me.simonhaasnoot.geinigspel.game.GameStateManager;
import me.simonhaasnoot.geinigspel.game.input.key.InputKeyListener;
import me.simonhaasnoot.geinigspel.game.util.Rectangle;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    /**
     * The game state manager.
     */
    private GameStateManager gsm;

    /**
     * Width of the frame.
     */
    public static int FRAME_WIDTH = 1028;

    /**
     * Height of the frame.
     */
    public static int FRAME_HEIGHT = 768;

    /**
     * Constructor.
     * This immediately shows the game frame as soon as it has been created.
     *
     * @param gsm The game state manager instance.
     */
    public GameFrame(GameStateManager gsm) {
        this(gsm, true);
    }

    /**
     * Constructor.
     *
     * @param gsm The game state manager instance.
     * @param show True to immediately show the frame after it has been created.
     */
    public GameFrame(GameStateManager gsm, boolean show) {
        this.setTitle("Made by Simon Haasnoot");
        this.setResizable(false);
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        // Set the game state manager instance
        this.gsm = gsm;

        // Build the game frame panel and add it to the
        this.add(buildGameFramePanel());

        // Register the input manager key listener
        this.addKeyListener(new InputKeyListener());
    }

    /**
     * Create the game frame panel.
     *
     * @return Game frame panel.
     */
    public JPanel buildGameFramePanel() {
        // Create and return the JPanel that was built
        return new GameFramePanel(this.gsm);
    }

    /**
     * Get the game state manager.
     *
     * @return Game state manager instance.
     */
    public GameStateManager getGameStateManager() {
        return this.gsm;
    }

    /**
     * Get a rectangle with the size of the frame.
     *
     * @return Frame rectangle.
     */
    public Rectangle getFrameRectangle() {
        return new Rectangle(0, 0, getWidth(), getHeight());
    }
}
