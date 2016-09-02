package me.simonhaasnoot.geinigspel.game;

import me.simonhaasnoot.geinigspel.game.entity.CharacterObject;
import me.simonhaasnoot.geinigspel.game.entity.GameObject;
import me.simonhaasnoot.geinigspel.game.level.BaseLevel;
import me.simonhaasnoot.geinigspel.game.time.FrameTime;
import me.simonhaasnoot.geinigspel.game.time.Timer;
import me.simonhaasnoot.geinigspel.game.level.PauseMenu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameStateManager {

    /**
     * The level that is currently loaded.
     */
    private BaseLevel level;

    /**
     *
     * The menu that is loaded upon pausing.
     */
    private PauseMenu pauseMenu;

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
     * variable for keeping track of the game pause state.
     */
    private boolean isGamePaused = false;

    /**
     * Constructor.
     */
    public GameStateManager() {
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

        // game is not paused upon loading a new level, just implemented to ensure.
        isGamePaused = false;

        // if frozen and you restart you'll get a nullpointer exception, so you have to tell java that frozen is false upon restarting.
        CharacterObject.isFrozen = false;

        // load the new level
        this.level = level;

        // Reset and start the level timer
        this.levelTimer.restart();

        // Call the start method in the level
        this.level.start(this);

    }

    public void pauseGame(){
        if(!isGamePaused){

            // pause the timer
            levelTimer.stop();

            // set the character speed to 0
            if(getLevel().getCharacter() != null)
            getLevel().getCharacter().setSpeedX(0);

            // set the variable to true again
            isGamePaused = true;

        } else{
          levelTimer.start();
            isGamePaused = false;
        }
    }

    public boolean isGamePaused(){
        return isGamePaused;
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

        // draw the sky
        g.drawImage(this.backgroundImg, 0, 0, GameManager.getGameFrame().getWidth(), GameManager.getGameFrame().getHeight(), null);

        // draw level components

        // draw all gameObjects
        for (GameObject go : gameObjects)
            go.paint(g);

        if(isGamePaused()){
            if(pauseMenu == null) {
                pauseMenu = new PauseMenu();
            }
            pauseMenu.paint(g);
        }

        if (level != null)
        level.paint(g);
    }

    public PauseMenu getPauseMenu() {
        return this.pauseMenu;
    }

    /**
     * Update.
     */
    public synchronized void update() {

        FrameTime.updateFrameTime(levelTimer);

        // Update the level if it's loaded
            if (level != null)
                level.update(this);

        // Update all game objects
        this.gameObjects.forEach(GameObject::update);

        // Destroy all the game objects in the 'to destroy' list
        for(GameObject g : this.gameObjectsToDestroy)
            this.gameObjects.remove(g);
        this.gameObjectsToDestroy.clear();

        if(GameManager.getGameStateManager().getLevel().getCharacter() != null){
            if(getHeartCount() <= 0) {
            loadLevel(level);
            }
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
