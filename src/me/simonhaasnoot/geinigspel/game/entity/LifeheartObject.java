package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.GameManager;

import java.awt.*;


public class LifeheartObject extends ImageObject {


    /**
     * The height of the heart.
     */
    public static final int SIZE_HEIGHT = 40;

    /**
     * The width of the heart.
     */
    public static final int SIZE_WIDTH = 40;

    public static Image lifeheartImage;



    public LifeheartObject(double x, double  y) {
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadLifeheartImage());
    }

    public LifeheartObject(double x, double y, double width, double height, Image img) {
        super(x, y, width, height, img);
    }

    public synchronized static Image loadLifeheartImage() {
        // Return the fireball image if it's already loaded
        if(lifeheartImage != null)
            return lifeheartImage;

        // TODO: Move image path into a constant!
        lifeheartImage = Toolkit.getDefaultToolkit().createImage("Images/Objects/gameHeart.png");
        return lifeheartImage;
    }

    @Override
    public void update(){
        super.update();

        if(hasCollision(GameManager.getGameStateManager().getLevel().getCharacter())){
            this.destroy();
            GameManager.getGameStateManager().pickedUpLifeheart(1);
        }
    }
}
