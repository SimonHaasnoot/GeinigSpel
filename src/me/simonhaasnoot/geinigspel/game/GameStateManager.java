package me.simonhaasnoot.geinigspel.game;
import me.simonhaasnoot.geinigspel.game.entity.CharacterObject;
import me.simonhaasnoot.geinigspel.game.entity.GameObject;
import me.simonhaasnoot.geinigspel.game.frame.GameFrame;
import me.simonhaasnoot.geinigspel.game.level.BaseLevel;
import me.simonhaasnoot.geinigspel.game.time.FrameTime;
import me.simonhaasnoot.geinigspel.game.time.Timer;

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
    public Timer levelTimer = new Timer();

    /**
     * The backgroundImg image.
     */
    private Image backgroundImg;

    public CharacterObject wizardCharacter;

    /**
     * Constructor.
     */
    public GameStateManager() {

        // Add the character object
        wizardCharacter = new CharacterObject(GameFrame.FRAME_WIDTH/2, GameFrame.FRAME_HEIGHT - CharacterObject.SIZE_HEIGHT*1.85);
        addGameObject(wizardCharacter);

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

        // Call the start method in the level
        this.level.start(this);

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

        // draw the sky
        g.drawImage(this.backgroundImg, 0, 0, GameManager.getGameFrame().getWidth(), GameManager.getGameFrame().getHeight(), null);

        //FIXME might move this to level?
        if(FrameTime.time > 55 && FrameTime.time < 60) {
            Font font = new Font("TimesRoman", Font.PLAIN, 26);
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString("WARNING! Incoming meteorites detected!", GameFrame.WIDTH / 2 + GameFrame.FRAME_HEIGHT / 3, GameFrame.FRAME_HEIGHT / 4);
        }

        {
            //noinspection ForLoopReplaceableByForEach
            for(int i = 0; i < this.gameObjects.size(); i++)
                this.gameObjects.get(i).paint(g);
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

        //FIXME fix me kappa
        //this.level.paint();
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

    /**
     * Get the backgroundImg image.
     *
     * @return Background image.
     */
    public Image getBackgroundImage() {
        return backgroundImg;
    }

    /**
     * Set the backgroundImg image.
     *
     * @param background Background image.
     */
    public void setBackgroundImage(Image background) {
        this.backgroundImg = background;
    }
}
