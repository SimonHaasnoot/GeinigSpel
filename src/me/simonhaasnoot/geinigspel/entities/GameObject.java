package me.simonhaasnoot.geinigspel.entities;

import java.awt.*;

public class GameObject {

    /**
     * The position and size of the game object.
     */
    private Rectangle pos;

    /**
     * Constructor.
     * Because the position of the game object will not be specified, the object will be placed at position (0, 0).
     *
     * @param size The size of the object.
     */
    public GameObject(Dimension size) {
        this(new Rectangle(size));
    }

    /**
     * Constructor.
     * 
     * @param pos Object position and size.
     */
    public GameObject(Rectangle pos) {
        this.pos = pos;
    }

    /**
     * Constructor.
     * 
     * @param x The x coordinate of the object.
     * @param y The y coordinate of the object.
     * @param width The width of the game object.
     * @param height The height of the game object.
     */
    public GameObject(int x, int y, int width, int height) {
        this(new Rectangle(x, y, width, height));
    }

    /**
     * Get the position and size of the game object.
     *
     * @return The position and size.
     */
    public Rectangle getPosition() {
        return pos;
    }

    /**
     * Get the location of the game object on the screen.
     *
     * @return The position.
     */
    public Point getLocation() {
        return pos.getLocation();
    }

    /**
     * Set the location of the object.
     *
     * @param loc The location.
     */
    public void setLocation(Point loc) {
        this.pos.setLocation(loc);
    }

    /**
     * Set the location of the object.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public void setLocation(int x, int y) {
        this.pos.setLocation(x, y);
    }

    /**
     * Get the x coordinate of the game object.
     *
     * @return The x coordinate.
     */
    public int getX() {
        return (int) getLocation().getX();
    }
    
    /**
     * Set the x coordinate of the game object.
     *
     * $param x The x coordinate.
     */
    public void setX(int x) {
        setLocation(x, getY());
    }

    /**
     * Get the y coordinate of the game object.
     *
     * @return The y coordinate.
     */
    public int getY() {
        return (int) getLocation().getY();
    }

    /**
     * Set the y coordinate of the game object.
     *
     * $param y The y coordinate.
     */
    public void setY(int y) {
        setLocation(getX(), y);
    }

    /**
     * Translate (or move) the game object relatively for the given X and Y values.
     *
     * @param x Relative X movement.
     * @param y Relative Y movement.
     */
    public void translate(int x, int y) {
        // TODO: Make sure this translates the game object properly!
        getPosition().translate(x, y);
    }

    /**
     * Get the size of the game object.
     *
     * @return The size.
     */
    public Dimension getSize() {
        return pos.getSize();
    }

    /**
     * Check whether this game object has collision with an other game object.
     *
     * @param other The other.
     *
     * @return True if both objects intersect, false otherwise.
     */
    public boolean hasCollision(GameObject other) {
        return getPosition().intersects(other.getPosition());
    }
}
