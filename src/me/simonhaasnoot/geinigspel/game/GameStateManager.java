package me.simonhaasnoot.geinigspel.game;

import me.simonhaasnoot.geinigspel.game.entity.GameObject;
import me.simonhaasnoot.geinigspel.game.entity.GameObjectTest;
import me.simonhaasnoot.geinigspel.game.entity.ImageObject;
import me.simonhaasnoot.geinigspel.game.level.BaseLevel;
import me.simonhaasnoot.geinigspel.game.util.FrameTime;
import me.simonhaasnoot.geinigspel.game.util.Timer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameStateManager {

    /**
     * The level that is currently loaded.
     */
    private BaseLevel level;

    /**
     * The game objects that are currently loaded.
     */
    private List<GameObject> gameObjects = new ArrayList<>();

    /**
     * The game objects that have to be destroyed when possible.
     */
    private List<GameObject> gameObjectsToDestroy = new ArrayList<>();

    /**
     * The time that has passed since the current level was started.
     */
    private Timer levelTimer = new Timer();

    /**
     * Constructor.
     */
    public GameStateManager() {
        // FIXME: THIS IS SOME TEST CODE!
        // TEST: Create a game object
        GameObjectTest got = new GameObjectTest(10, 10, 100, 100);
        got.setSpeedY(10.0);
        addGameObject(got);

        // TEST: Create a moving wizard
        Image img = Toolkit.getDefaultToolkit().createImage("Images/Characters/Wizard.png");
        ImageObject imgObj = new ImageObject(30, 30, 140 / 2, 181 / 2, img);
        imgObj.setSpeedX(100);
        addGameObject(imgObj);

        // Start the timer
        this.levelTimer.restart();
    }

    /**
     * Constructor.
     *
     * @param level The level to load.
     */
    public GameStateManager(BaseLevel level) {
        loadLevel(level);
    }

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
        // TODO: Make sure the given level is valid, unload the current level, load this level.

        // Set the loaded level
        this.level = level;

        // Reset and start the level timer
        this.levelTimer.restart();
    }

    /**,
     * Get a list of all game objects that are currently loaded.
     *
     * @return Game objects.
     */
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Paint all the game objects that are currently loaded.
     *
     * @param g The graphics canvas.
     */
    public void paintGameObjects(Graphics2D g) {
        // Update the frame timer
        FrameTime.updateFrameTime(levelTimer);

        // Loop through all the game objects and paint them
        for(GameObject obj : this.gameObjects) {
            obj.paint(g);
        }
    }

    /**
     * Update.
     */
    public synchronized void update() {
        // Update the level if it's loaded
        if(level != null)
            level.update(this);

        // Update all game objects
        this.gameObjects.forEach(GameObject::update);

        // Destroy all the game objects in the 'to destroy' list
        for(GameObject g : this.gameObjectsToDestroy)
            this.gameObjects.remove(g);
        this.gameObjectsToDestroy.clear();
    }

    /**
     * Add a game object.
    */
    public synchronized void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    /**
     * Destroy a game object.
     *
     * @param gameObject Game object to destroy.
     */
    public synchronized void destroyGameObject(GameObject gameObject) {
        this.gameObjectsToDestroy.add(gameObject);
    }
}
