package me.simonhaasnoot.geinigspel.game;

import me.simonhaasnoot.geinigspel.game.frame.GameFrame;

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

        // if game isn't paused run the game
        if(!gsm.isGamePaused()) {

            // Update all game objects
            gsm.update();

            //register ingame keys
            gsm.getLevel().registerKeys(gsm);


            gameFrame.setTitle("Made by Simon Haasnoot - Game objects: " +
                    getGameStateManager().getGameObjects().size() +
                    " - Lives: " +
                    GameManager.getGameStateManager().getLevel().getCharacter().getCurrentHearts() +
                    " - Frame time: " + GameManager.getGameStateManager().levelTimer.getElapsedTime());
        }
        else{
            gsm.getPauseMenu().registerKeys();
        }
        // Force render the game frame
        gameFrame.repaint();
    }
}
