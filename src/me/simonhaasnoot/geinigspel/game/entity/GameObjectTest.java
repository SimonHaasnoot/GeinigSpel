package me.simonhaasnoot.geinigspel.game.entity;

import java.awt.*;
import java.awt.geom.Line2D;

public class GameObjectTest extends GameObject {

    public GameObjectTest(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public boolean paint(Graphics2D g) {
        // Draw a line for testing
        g.draw(new Line2D.Double(getX(), getY(), getX() + 100.0, getY() + 100.0));
        return true;
    }
}
