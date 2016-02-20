package me.simonhaasnoot.geinigspel.game.entity;

import java.awt.*;

public class FireballObject extends ImageObject {

    /**
     * The width of the fireball.
     */
    public static final int SIZE_WIDTH = 64;

    /**
     * The height of the fireball.
     */
    public static final int SIZE_HEIGHT = 64;

    /**
     * The minimum speed the fireball moves downwards.
     */
    public static final double SPEED_MIN = 200.0;

    /**
     * The maximum speed the fireball moves downwards.
     */
    public static final double SPEED_MAX = 400.0;

    /**
     * The fireball image.
     */
    public static Image fireballImg;

    /**
     * Constructor.
     *
     * @param x X position of the fireball.
     * @param y Y position of the fireball.
     */
    public FireballObject(double x, double y) {
        // Construct the fireball
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadFireballImage());
    }

    /**
     * Constructor.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param img
     */
    public FireballObject(double x, double y, double width, double height, Image img) {
        // Construct the parent
        super(x, y, width, height, img);

        // Randomize and set the speed of the fireball
        setSpeedY(Math.random() * (SPEED_MAX - SPEED_MIN) + SPEED_MIN);
    }

    /**
     * Load the fireball image.
     *
     * @return Fireball image.
     */
    public synchronized static Image loadFireballImage() {
        // Return the fireball image if it's already loaded
        if(fireballImg != null)
            return fireballImg;

        // Load the fireball image and return it
        // TODO: Remove this debug line!
        System.out.println("Loading fireball image!");
        // TODO: Move image path into a constant!
        fireballImg = Toolkit.getDefaultToolkit().createImage("Images/Objects/Gifs/FIREBALL.gif");
        return fireballImg;
    }
}
