package me.simonhaasnoot.geinigspel.game;

import me.simonhaasnoot.geinigspel.game.entity.CharacterObject;
import me.simonhaasnoot.geinigspel.game.entity.GameObject;
import me.simonhaasnoot.geinigspel.game.frame.GameFrame;
import me.simonhaasnoot.geinigspel.game.level.BaseLevel;
import me.simonhaasnoot.geinigspel.game.time.FrameTime;
import me.simonhaasnoot.geinigspel.game.time.Timer;

import java.awt.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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

    /**
     * Constructor.
     */
    public GameStateManager() {

        // Add the character object

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

        // make sure to delete all game objects, clear the gameObject list.
        gameObjects.clear();
        gameObjectsToDestroy.clear();

        // if frozen and you restart you'll get a nullpointer exception, so you have to tell java that frozen is false upon restarting.
        CharacterObject.isFrozen = false;

        // load the new level
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

    public int getHeartCount(){
        return getLevel().getCharacter().getCurrentHearts();
    }

    public void setCharacterDamageTaken(int damage){
        getLevel().getCharacter().setCurrentHearts(getHeartCount() - damage);
    }

    public void pickedUpLifeheart(int heart){
        getLevel().getCharacter().setCurrentHearts(getHeartCount() + heart);
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
            try {
                for (GameObject go : gameObjects) {
                    go.paint(g);
                }
            } catch(ConcurrentModificationException e){
                e.printStackTrace();
             }
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

        if(getHeartCount() <= 0){
            loadLevel(level);
        }
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
