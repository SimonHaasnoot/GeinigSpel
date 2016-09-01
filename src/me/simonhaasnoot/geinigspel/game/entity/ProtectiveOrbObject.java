package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.game.GameManager;

import java.awt.*;


public class ProtectiveOrbObject extends ImageObject {


    public static final int SIZE_WIDTH = 40;
    public static final int SIZE_HEIGHT = 40;

    public static Image orbImage;

    private boolean orbObtained = false;

    public ProtectiveOrbObject(double x, double y){
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadOrbImage());
    }

    public ProtectiveOrbObject(double x, double y, double width, double height, Image img) {
        super(x, y, width, height, img);
    }
    
    public boolean isOrbObtained(){
        if(orbObtained)
            return true;
            else return false;
    }

    public synchronized static Image loadOrbImage(){

        if(orbImage != null)
            return orbImage;

        orbImage = Toolkit.getDefaultToolkit().createImage("Images/Items/glowOrb.png");
        return orbImage;
    }

    public void update(){
        super.update();

        if(hasCollision(GameManager.getGameStateManager().getLevel().getCharacter())){
            orbObtained = true;
            this.destroy();
        }
    }
}
