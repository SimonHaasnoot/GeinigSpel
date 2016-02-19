package me.simonhaasnoot.geinigspel.game.util;

import java.awt.*;

public class Rectangle extends java.awt.Rectangle.Double {

    /**
     * Constructor.
     *
     * @param x The x coordinate of the object.
     * @param y The y coordinate of the object.
     * @param width The width of the game object.
     * @param height The height of the game object.
     */
    public Rectangle(double x, double y, double width, double height) {

    }

    /**
     * Constructor.
     *
     * @param size The dimensions.
     */
    public Rectangle(Dimension size) {
        this(0, 0, size.width, size.height);
    }

    /**
     * Get the location of the game object as integers.
     *
     * @return Location of the game object.
     */
    public Point getLocationInt() {
        return new Point((int) getX(), (int) getY());
    }

    /**
     * Set the location of the rectangle.
     *
     * @param x The X coordinate.
     * @param y The X coordinate.
     */
    public void setLocation(double x, double y) {
        setRect(x, y, getWidth(), getHeight());
    }

    /**
     * Set the location of the rectangle.
     *
     * @param location Location of the rectangle.
     */
    public void setLocationInt(Point location) {
        setLocationInt((int) location.getX(), (int) location.getY());
    }

    /**
     * Set the location of the rectangle.
     *
     * @param x The X coordinate.
     * @param y The Y coordinate.
     */
    public void setLocationInt(int x, int y) {
        setRect(x, y, getWidth(), getHeight());
    }

    /**
     * Get the size of the rectangle as an integer.
     *
     * @return The rectangle size.
     */
    public Dimension getSizeInt() {
        return new Dimension((int) getWidth(), (int) getHeight());
    }
}
