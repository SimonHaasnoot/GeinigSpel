package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.GameManager;

import java.awt.*;

/**
 * Created by Simon on 2/23/2016.
 */
public class FreezeFireballObject extends ImageObject{
    /**
     * The width of the fireball.
     */
    public static final int SIZE_WIDTH = 32;

    /**
     * The height of the fireball.
     */
    public static final int SIZE_HEIGHT = 32;

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
    public static Image freezeFireballImg;

    /**
     * Constructor.
     *
     * @param x X position of the fireball.
     * @param y Y position of the fireball.
     */
    public FreezeFireballObject(double x, double y) {
        // Construct the fireball
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadFreezeFireballImage());
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
    public FreezeFireballObject(double x, double y, double width, double height, Image img) {
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
    public synchronized static Image loadFreezeFireballImage() {
        // Return the fireball image if it's already loaded
        if(freezeFireballImg != null)
            return freezeFireballImg;

        // TODO: Move image path into a constant!
        freezeFireballImg = Toolkit.getDefaultToolkit().createImage("Images/Objects/Gifs/FreezeFireball.gif");
        return freezeFireballImg;
    }

    @Override
    public void update(){
        super.update();

        // this happens if the iceball collides with the character.
        if(hasCollision(GameManager.getGameStateManager().wizardCharacter)){
            this.destroy();
                CharacterObject.isFrozen = true;
                CharacterObject.loadCharacterImage();
                System.out.println("You're frozen!");
        }
    }
}
