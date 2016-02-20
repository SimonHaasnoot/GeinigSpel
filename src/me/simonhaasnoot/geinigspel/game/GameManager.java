package me.simonhaasnoot.geinigspel.game;

import me.simonhaasnoot.geinigspel.game.frame.GameFrame;
import me.simonhaasnoot.geinigspel.game.input.Input;

public class GameManager {

    /**
     * The game frame.
     */
    private static GameFrame gameFrame;

    /**
     * Game state manager.
     */
    private static GameStateManager gsm;

    /**
     * Initialize.
     */
    public static void init() {
        // Initialize the game state manager
        gsm = new GameStateManager();

        // Initialize the input manager
        Input.init();

        // Initialize the game frame
        gameFrame = new GameFrame(gsm, false);

        // Show the game frame
        gameFrame.setVisible(true);
    }

    /**
     * Get the game state manager.
     *
     * @return Game state manager.
     */
    public static GameStateManager getGameStateManager() {
        return gsm;
    }

    /**
     * Get the game frame.
     *
     * @return Game frame.
     */
    public static GameFrame getGameFrame() {
        return gameFrame;
    }

    /**
     * Update.
     */
    public static void update() {
        // Update all game objects
        gsm.update();

        // Force render the game frame
        gameFrame.repaint();

        // FIXME: Show the number of alive game objects in the title
        gameFrame.setTitle("Made by Simon Haasnoot - Game objects: " + getGameStateManager().getGameObjects().size());
    }
}
