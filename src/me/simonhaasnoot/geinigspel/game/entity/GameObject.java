package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.util.FrameTime;
import me.simonhaasnoot.geinigspel.game.util.Rectangle;

import java.awt.*;

public abstract class GameObject {

    /**
     * The position and size of the game object.
     */
    private Rectangle pos;

    /**
     * The speed on the X coordinate, as pixel per second.
     */
    private double speedX = 0.0;

    /**
     * The speed on the Y coordinate, as pixel per second.
     */
    private double speedY = 0.0;



    //public boolean destroy


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
    public GameObject(double x, double y, double width, double height) {
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
        return pos.getLocationInt();
    }

    /**
     * Set the location of the object.
     *
     * @param loc The location.
     */
    public void setLocation(Point loc) {
        this.pos.setLocationInt(loc);
    }

    /**
     * Set the location of the object.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public void setLocation(double x, double y) {
        this.pos.setLocation(x, y);
    }

    /**
     * Get the x coordinate of the game object.
     *
     * @return The x coordinate.
     */
    public double getX() {
        return this.pos.getX();
    }
    
    /**
     * Set the x coordinate of the game object.
     *
     * $param x The x coordinate.
     */
    public void setX(double x) {
        setLocation(x, getY());
    }

    /**
     * Get the y coordinate of the game object.
     *
     * @return The y coordinate.
     */
    public double getY() {
        return this.pos.getY();
    }

    /**
     * Set the y coordinate of the game object.
     *
     * $param y The y coordinate.
     */
    public void setY(double y) {
        setLocation(getX(), y);
    }

    /**
     * Get the width of the game object.
     *
     * @return Width of the game object.
     */
    public double getWidth() {
        return this.pos.getWidth();
    }

    /**
     * Get the height of the game object.
     *
     * @return Height of the game object.
     */
    public double getHeight() {
        return this.pos.getHeight();
    }

    /**
     * Translate (or move) the game object relatively for the given X and Y values.
     *
     * @param x Relative X movement.
     * @param y Relative Y movement.
     */
    public void translate(double x, double y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    /**
     * Get the size of the game object.
     *
     * @return The size.
     */
    public Dimension getSize() {
        return pos.getSizeInt();
    }

    /**
     * Check whether this game object has collision with another rectangle.
     *
     * @param other The other.
     *
     * @return True if both objects intersect, false otherwise.
     */
    public boolean hasCollision(Rectangle other) {
        return getPosition().intersects(other);
    }

    /**
     * Check whether this game object has collision with an other game object.
     *
     * @param other The other.
     *
     * @return True if both objects intersect, false otherwise.
     */
    public boolean hasCollision(GameObject other) {
        return hasCollision(other.getPosition());
    }

    /**
     * Paint the game object.
     *
     * @param g The graphics canvas to render on.
     *
     * @return True if something was painted, false if not.
     */
    public abstract boolean paint(Graphics2D g);

    /**
     * Update the game object.
     */
    public void update() {
        // Translate the object
        if(speedX != 0.0 || speedY != 0.0)
            translate(FrameTime.deltaTime * speedX, FrameTime.deltaTime * speedY);
    }

    /**
     * Get the speed on the X coordinate, as pixels per second.
     *
     * @return Speed on the X coordinate.
     */
    public double getSpeedX() {
        return speedX;
    }

    /**
     * Set the speed on the X coordinate, as pixels per second.
     *
     * @param speedX Speed on the X coordinate.
     */
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    /**
     * Get the speed on the Y coordinate, as piYels per second.
     *
     * @return Speed on the Y coordinate.
     */
    public double getSpeedY() {
        return speedY;
    }

    /**
     * Set the speed on the Y coordinate, as pixels per second.
     *
     * @param speedY Speed on the Y coordinate.
     */
    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
}
