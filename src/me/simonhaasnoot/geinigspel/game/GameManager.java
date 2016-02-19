package me.simonhaasnoot.geinigspel.game;

import me.simonhaasnoot.geinigspel.game.frame.GameFrame;

public class GameManager {

    /**
     * The game frame.
     */
    private GameFrame gameFrame;

    /**
     * Game state manager.
     */
    private GameStateManager gsm;

    /**
     * Constructor.
     */
    public GameManager() {
        // Initialize the game frame
        this.gameFrame = new GameFrame(false);

        // Initialize the game state manager
        this.gsm = new GameStateManager();

        // TODO: Show the game frame?
    }

    /**
     * Get the game state manager.
     *
     * @return Game state manager.
     */
    public GameStateManager getGameStateManager() {
        return this.gsm;
    }

    /**
     * Get the game frame.
     *
     * @return Game frame.
     */
    public GameFrame getGameFrame() {
        return gameFrame;
    }

    /**
     * Update.
     */
    public void update() {
        // TODO: Update all game objects.

        // Force render the game frame
        // TODO: Make sure this works!
        this.gameFrame.repaint();
    }
}
