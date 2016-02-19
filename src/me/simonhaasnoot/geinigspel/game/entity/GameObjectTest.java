package me.simonhaasnoot.geinigspel.game.entity;

import java.awt.*;

public class GameObjectTest extends GameObject {

    public GameObjectTest(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public boolean paint(Graphics2D g) {
        // Set the font size
        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 20));

        // Draw a test string
        g.drawString("This is some test", 10, 30);

        return true;
    }
}
