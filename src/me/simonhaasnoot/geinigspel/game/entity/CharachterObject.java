package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CharachterObject extends ImageObject {

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

    public static double SPEED_NORMAL = 200;

    /**
     * the supersonic character OP speed.
     */

    public static double SPEED_MAX = 600;

    /**
     * character image.
     */
    public static Image characterImg;


    /**
     *
     * @param x set x position for Character.
     * @param y set y position for Character.
     */
    public CharachterObject(double x, double y) {
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadCharacterImage());
    }

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param img
     */
    public CharachterObject(double x, double y, double width, double height, Image img) {
        // Construct the parent
        super(x, y, width, height, img);

        // Do not destroy the player when it goes out of the screen
        setDestroyOffScreen(false);
        setDestroyOffScreenSoft(false);

        setSpeedX(5);
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
}
