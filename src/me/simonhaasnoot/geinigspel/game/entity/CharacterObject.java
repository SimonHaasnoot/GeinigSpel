package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.frame.GameFrame;
import me.simonhaasnoot.geinigspel.game.input.Input;
import me.simonhaasnoot.geinigspel.game.time.FrameTime;

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
    public static int currentHearts = 3;

    /**
     * @param x set x position for Character.
     * @param y set y position for Character.
     */
    public CharacterObject(double x, double y) {
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadCharacterImage());
    }

    /**
     * @param x
     * @param y
     * @param width
     * @param height
     * @param img
     */
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
            StartFrozenTime = FrameTime.time;
            SPEED_NORMAL = 0;
            characterImg = Toolkit.getDefaultToolkit().createImage("Images/Characters/FrozenCharacter.png");
            GameManager.getGameStateManager().wizardCharacter.setImage(characterImg);
        }

        return characterImg;
    }

    @Override
    public void update() {
        // Call the super
        super.update();

        // Create a variable for the horizontal speed of the character
        int speed = 0;

        // Configure the speed based on the pressed keys
        if(Input.isPressed(KeyEvent.VK_LEFT) || Input.isPressed(KeyEvent.VK_A))
            speed -= SPEED_NORMAL;
        if(Input.isPressed(KeyEvent.VK_RIGHT) || Input.isPressed(KeyEvent.VK_D))
            speed += SPEED_NORMAL;

        // Properly flip the character if it's moving left or right
        if(speed < 0)
            setFlippedX(true);
        else if(speed > 0)
            setFlippedX(false);

        // Set the speed of the character
        setSpeedX(speed);

        // Set the MIN and MAX of the field your playing in.
        if(GameManager.getGameStateManager().wizardCharacter.getX() > GameFrame.FRAME_WIDTH - getWidth())
            GameManager.getGameStateManager().wizardCharacter.setX(GameFrame.FRAME_WIDTH - getWidth());

        if(GameManager.getGameStateManager().wizardCharacter.getX() < 0)
            GameManager.getGameStateManager().wizardCharacter.setX(0);

        // what to do when frozen and unfrozen
        if(isFrozen)
        if(FrameTime.time - StartFrozenTime > 1){
            isFrozen = false;
            loadCharacterImage();
            GameManager.getGameStateManager().wizardCharacter.setImage(characterImg);
        }
    }
}
