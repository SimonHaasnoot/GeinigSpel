package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.GameStateManager;
import me.simonhaasnoot.geinigspel.game.frame.GameFrame;
import me.simonhaasnoot.geinigspel.game.frame.GameFramePanel;
import me.simonhaasnoot.geinigspel.game.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CharacterObject extends ImageObject {

    /**
     * The width of the character.
     */
    public static final int SIZE_WIDTH = 70;

    /**
     * The height of the character.
     */
    public static final int SIZE_HEIGHT = 90;

    /**
     * The Speed of the character.
     */
    public static double SPEED_NORMAL = 350;

    /**
     * The supersonic character OP speed.
     */
    public static double SPEED_MAX = 600;

    /**
     * Character image.
     */
    public static Image characterImg;

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
        // Return the fireball image if it's already loaded
        if(characterImg != null)
            return characterImg;

        // TODO: Move image path into a constant!
        characterImg = Toolkit.getDefaultToolkit().createImage("Images/Characters/Wizard.png");
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


    }
}
