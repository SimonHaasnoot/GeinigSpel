package me.simonhaasnoot.geinigspel.game.Main;
import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.level.MainMenu;

public class Main {

    /**
     * Main method, called on start.
     *
     * @param args Start arguments.
     */
    public static void main(String[] args) {
        // Initialize the game manager
        GameManager.init();

        // Load a level
        GameManager.getGameStateManager().loadLevel(new MainMenu());

        // Update the game manager
        //noinspection InfiniteLoopStatement
        while (true) {
            GameManager.update();

            // TODO: Configure this!
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
