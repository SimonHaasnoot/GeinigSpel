package me.simonhaasnoot.geinigspel.game;

public class GameManager {

    /**
     * Game state manager.
     */
    private GameStateManager gsm;

    /**
     * Constructor.
     */
    public GameManager() {
        // Initialize the game state manager
        this.gsm = new GameStateManager();
    }

    /**
     * Get the game state manager.
     *
     * @return Game state manager.
     */
    public GameStateManager getGameStateManager() {
        return this.gsm;
    }
}
