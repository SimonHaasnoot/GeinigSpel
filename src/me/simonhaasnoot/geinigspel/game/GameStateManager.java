package me.simonhaasnoot.geinigspel.game;

import me.simonhaasnoot.geinigspel.entity.GameObject;
import me.simonhaasnoot.geinigspel.level.BaseLevel;

import java.util.List;

public class GameStateManager {

    /**
     * The level that is currently loaded.
     */
    private BaseLevel level;

    /**
     * The game objects that are currently loaded.
     */
    private List<GameObject> gameObjects;

    /**
     * Get the current level.
     *
     * @return Current level.
     */
    public BaseLevel getLevel() {
        return level;
    }

    /**
     * Load a level.
     *
     * @param level The level to load.
     */
    public void loadLevel(BaseLevel level) {
        this.level = level;
    }

    /**
     * Get a list of all game objects that are currently loaded.
     *
     * @return Game objects.
     */
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
