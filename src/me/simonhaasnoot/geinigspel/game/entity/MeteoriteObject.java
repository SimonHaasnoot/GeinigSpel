package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.GameManager;
import java.awt.*;


public class MeteoriteObject extends ImageObject{

    /**
     * The meteorite image;
     */
    public static Image meteoriteImg;

    /**
     * The Width of the Meteorite object.
     */
    public static final double SIZE_WIDTH = 300;

    /**
     * The height of the meteorite object.
     */
    public static final double SIZE_HEIGHT = 300;

    /**
     * Set MIN speed.
     */
    public static final int SPEED_MIN = 200;
    /**

     * SET MAX SPEED
     */
    public static final int SPEED_MAX = 500;

    /**
     *
     * @param x
     * @param y
     */
    public MeteoriteObject(double x, double y) {
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadMeteoriteImage());
    }

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param img
     */
    public MeteoriteObject(double x, double y, double width, double height, Image img) {
        super(x, y, width, height, img);

        setSpeedY(Math.random() * (SPEED_MAX - SPEED_MIN) + SPEED_MIN);
        setSpeedX((Math.random() * (SPEED_MAX - SPEED_MIN) + SPEED_MIN)/1.2);
    }

    public synchronized static Image loadMeteoriteImage(){

        if(meteoriteImg != null)
            return meteoriteImg;

        // TODO: Move image path into a constant!
        meteoriteImg = Toolkit.getDefaultToolkit().createImage("Images/Objects/Gifs/MeteoriteGif100ms.gif");
        return meteoriteImg;
    }

    public void update(){
        super.update();

        if(hasCollision(GameManager.getGameStateManager().wizardCharacter)){
            this.destroy();
            HealthViewerObject.CURRENT_HEARTS -= 2;
        }
    }
}
