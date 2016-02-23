package me.simonhaasnoot.geinigspel.game.entity;

import java.awt.*;

public class HealthViewerObject extends ImageObject{

    /**
     * Define the Width of the hearts.
     */
    public static final int SIZE_WIDTH = 50;

    /**
     * Define the Height of the hearts.
     */
    public static final int SIZE_HEIGHT = 50;

    /**
     * Define the minimum lives u can have.
     */
    public static final int MIN_HEARTS = 1;

    /**
     * Define the current hearts.
     */
    public static int CURRENT_HEARTS = 3;

    /**
     * Define the maximum hearts u can get.
     */
    public static final int MAX_HEARTS = 6;

    /**
     * The Heart image.
     */
    public static Image heartImg;

    /** Constructor.
     *
     * @param x position of the heart.
     * @param y position of the heart.
     */
    public HealthViewerObject(double x, double y) {
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadHeartImage());
    }

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param img
     */
    public HealthViewerObject(double x, double y, double width, double height, Image img) {
        super(x, y, width, height, img);
    }



    /**
     *
     * @return heartImg;
     */
    public synchronized static Image loadHeartImage() {
        // Return the fireball image if it's already loaded
        if(heartImg != null)
            return heartImg;

        // TODO: Move image path into a constant!
        heartImg = Toolkit.getDefaultToolkit().createImage("Images/Objects/gameHeart.png");
        return heartImg;
    }

    @Override
    public void update(){
        super.update();
    }

}
