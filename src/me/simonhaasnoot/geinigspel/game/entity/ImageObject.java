package me.simonhaasnoot.geinigspel.game.entity;

import java.awt.*;

public class ImageObject extends GameObject {

    /**
     * The image to render.
     */
    private Image img;

    /**
     * Constructor.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public ImageObject(double x, double y, double width, double height) {
        super(x, y, width, height);
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
    public ImageObject(double x, double y, double width, double height, Image img) {
        this(x, y, width, height);
        this.img = img;
    }

    /**
     * Get the image.
     *
     * @return The image.
     */
    public Image getImage() {
        return img;
    }

    /**
     * Set the image.
     *
     * @param img The image.
     */
    public void setImage(Image img) {
        this.img = img;
    }

    @Override
    public boolean paint(Graphics2D g) {
        // Draw the image
        g.drawImage(this.img, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
        return true;
    }
}