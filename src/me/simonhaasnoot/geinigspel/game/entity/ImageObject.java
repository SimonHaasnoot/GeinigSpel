package me.simonhaasnoot.geinigspel.game.entity;

import java.awt.*;

public class ImageObject extends GameObject {

    /**
     * The image to render.
     */
    private Image img;

    /**
     * True to flip the image on the X axis.
     */
    private boolean flipX = false;

    /**
     * True to flip the image on the Y axis.
     */
    private boolean flipY = false;

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

    /**
     * Check whether this image is flipped on the X axis.
     *
     * @return True if flipped on the X axis.
     */
    public boolean isFlippedX() {
        return flipX;
    }

    /**
     * Set whether the image is flipped on the X axis.
     *
     * @param flipX True if flipped on the X axis.
     */
    public void setFlippedX(boolean flipX) {
        this.flipX = flipX;
    }

    /**
     * Check whether this image is flipped on the Y axis.
     *
     * @return True if flipped on the Y axis.
     */
    public boolean isFlippedY() {
        return flipY;
    }

    /**
     * Set whether the image is flipped on the Y axis.
     *
     * @param flipY True if flipped on the Y axis.
     */
    public void setFlippedY(boolean flipY) {
        this.flipY = flipY;
    }

    /**
     * Paint the game object.
     *
     * @param g The graphics canvas to render on.
     *
     * @return True if succeed, false if not.
     */
    public boolean paint(Graphics2D g) {
        // Get the position and size of the image
        int x = (int) getX();
        int y = (int) getY();
        int width = (int) getWidth();
        int height = (int) getHeight();

        // Check whether the image should be flipped on the X axis
        if(isFlippedX()) {
            x += width;
            width *= -1;
        }

        // Check whether the image should be flipped on the Y axis
        if(isFlippedY()) {
            y += height;
            height *= -1;
        }

        // Draw the image
        g.drawImage(this.img, x, y, width, height, null);
        return true;
    }
}