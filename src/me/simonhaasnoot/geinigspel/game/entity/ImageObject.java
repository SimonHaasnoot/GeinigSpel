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
     * @param x The X coordinate of the object.
     * @param y The X coordinate of the object.
     * @param width The width of the object.
     * @param height The height of the object.
     */
    public ImageObject(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    /**
     * Constructor.
     *
     * @param x The X coordinate of the object.
     * @param y The X coordinate of the object.
     * @param width The width of the object.
     * @param height The height of the object.
     * @param img The image.
     */
    public ImageObject(double x, double y, double width, double height, Image img) {
        // Use the main constructor
        this(x, y, width, height);

        // Set the image
        setImage(img);
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