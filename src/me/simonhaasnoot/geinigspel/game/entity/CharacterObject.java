package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.frame.GameFrame;
import me.simonhaasnoot.geinigspel.game.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CharacterObject extends ImageObject {

    /**
     * The width of the character.
     */
    public static final int SIZE_WIDTH = 65;

    /**
     * The height of the character.
     */
    public static final int SIZE_HEIGHT = 90;

    /**
     * The Speed of the character.
     */
    public static double SPEED_NORMAL = 500;

    /**
     * The supersonic character OP speed.
     */
    public static double SPEED_MAX = 1000;


    /**
     * Timer to count time of being frozen.
     */
    public static double StartFrozenTime;

    /**
     * Define if the character is frozen.
     */
    public static boolean isFrozen = false;

    /**
     * Character image.
     */
    public static Image characterImg;

    /**
     * Define the current hearts.
     */
    public int currentHearts = 3;

    /**
     * @param x set x position for Character.
     * @param y set y position for Character.
     */
    public CharacterObject(double x, double y) {
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadCharacterImage());
    }

    public CharacterObject(double x, double y, double width, double height, Image img) {
        // Construct the parent
        super(x, y, width, height, img);

        // Do not destroy the player when it goes out of the screen
        setDestroyOffScreen(false);
        setDestroyOffScreenSoft(false);
    }

    /**
     * Load Character image.
     * @return character image.
     */
    public synchronized static Image loadCharacterImage() {

        if(!isFrozen) {
            characterImg = Toolkit.getDefaultToolkit().createImage("Images/Characters/Wizard.png");
            SPEED_NORMAL = 500;
        }

        if(isFrozen){
            StartFrozenTime = GameManager.getGameStateManager().levelTimer.getElapsedTime();
            SPEED_NORMAL = 0;
            characterImg = Toolkit.getDefaultToolkit().createImage("Images/Characters/FrozenCharacter.png");
            GameManager.getGameStateManager().getLevel().getCharacter().setImage(characterImg);
        }

        return characterImg;
    }

    public int getCurrentHearts() {
        return currentHearts;
    }

    public void setCurrentHearts(int currentHearts) {
        this.currentHearts = currentHearts;
    }

    @Override
    public void update() {
        // Call the super
        super.update();

        setSpeedX(0);
        // Configure the speed based on the pressed keys
        if(Input.isPressed(KeyEvent.VK_LEFT) || Input.isPressed(KeyEvent.VK_A))
            setSpeedX(-SPEED_NORMAL);
        if(Input.isPressed(KeyEvent.VK_RIGHT) || Input.isPressed(KeyEvent.VK_D))
            setSpeedX(SPEED_NORMAL);

        // Properly flip the character if it's moving left or right
        if(GameManager.getGameStateManager().levelTimer.isRunning()) {
            if (getSpeedX() < 0)
                setFlippedX(true);
            else if (getSpeedX() > 0)
                setFlippedX(false);
        }

        // Set the MIN and MAX of the field your playing in.
        if(GameManager.getGameStateManager().getLevel().getCharacter().getX() > GameFrame.FRAME_WIDTH - getWidth())
            GameManager.getGameStateManager().getLevel().getCharacter().setX(GameFrame.FRAME_WIDTH - getWidth());

        if(GameManager.getGameStateManager().getLevel().getCharacter().getX() < 0)
            GameManager.getGameStateManager().getLevel().getCharacter().setX(0);

        // what to do when frozen and unfrozen
        if(isFrozen){
            if(GameManager.getGameStateManager().levelTimer.getElapsedTime() - StartFrozenTime > 1) {
            isFrozen = false;
            loadCharacterImage();
            GameManager.getGameStateManager().getLevel().getCharacter().setImage(characterImg);
            }
        }
    }
}
