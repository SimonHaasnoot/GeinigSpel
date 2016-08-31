package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.time.FrameTime;

import java.awt.*;

/**
 * Created by Simon on 3/2/2016.
 */
public class ThunderObject extends ImageObject {

    /**
     * The meteorite image;
     */
    public static Image thunderImg;

    /**
     * The Width of the Meteorite object.
     */
    public static final double SIZE_WIDTH = 150;

    /**
     * The height of the meteorite object.
     */
    public static final double SIZE_HEIGHT = 550;

    /**
     * Define the time the cloud will last.
     */
    private double startFrozenTime;

    /**
     *
     * @param x
     * @param y
     */
    public ThunderObject(double x, double y) {
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadThunderImage());
    }

    public ThunderObject(double x, double y, double width, double height, Image img) {
        super(x, y, width, height, img);

        startFrozenTime = FrameTime.time;
    }

    public static synchronized Image loadThunderImage(){

        // TODO: Move image path into a constant!
        thunderImg = Toolkit.getDefaultToolkit().createImage("Images/Objects/Gifs/ThunderwithCloudgif.gif");
        return thunderImg;
    }

    public void update(){
        super.update();


        if(hasCollision(GameManager.getGameStateManager().getLevel().getCharacter())){
            GameManager.getGameStateManager().setCharacterDamageTaken(2);
        }
        if(FrameTime.time - startFrozenTime > 1.5){
            this.destroy();
        }
    }


}
