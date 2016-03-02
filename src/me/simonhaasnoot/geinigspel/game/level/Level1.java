package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.GameStateManager;
import me.simonhaasnoot.geinigspel.game.entity.FireballObject;
import me.simonhaasnoot.geinigspel.game.entity.FreezeFireballObject;
import me.simonhaasnoot.geinigspel.game.entity.MeteoriteObject;
import me.simonhaasnoot.geinigspel.game.entity.ThunderObject;
import me.simonhaasnoot.geinigspel.game.time.FrameTime;

import java.awt.*;

public class Level1 extends BaseLevel {

    @Override
    public void start(GameStateManager gsm) {

        // Set the frame background
        GameManager.getGameStateManager().setBackgroundImage(Toolkit.getDefaultToolkit().createImage("Images/Landscape/1028x768BB.png"));

    }

    @Override
    public void update(GameStateManager gsm) {

        // Spawn the fireballs
        if(Math.random() < FrameTime.time / (Math.sqrt(FrameTime.time) * 250.0 ))
            gsm.addGameObject(new FireballObject(Math.random() * GameManager.getGameFrame().getWidth() -FireballObject.SIZE_WIDTH, -FireballObject.SIZE_HEIGHT));


        // spawn freezeballs
        if(Math.random() < FrameTime.time / ((Math.sqrt(FrameTime.time)*8) * 250.0 ))
            gsm.addGameObject(new FreezeFireballObject(Math.random() * GameManager.getGameFrame().getWidth() -FireballObject.SIZE_WIDTH, -FireballObject.SIZE_HEIGHT));


        // spawn thunder clouds
        if(Math.random() < FrameTime.time / ((Math.sqrt(FrameTime.time)*6) * 250.0 ))
            gsm.addGameObject(new ThunderObject(Math.random() * GameManager.getGameFrame().getWidth() - ThunderObject.SIZE_WIDTH, 150));


        // spawn meteorite
        if(FrameTime.time > 60) {
            if (Math.random() < FrameTime.time / ((Math.sqrt(FrameTime.time) *10) * 1000.0))
                gsm.addGameObject(new MeteoriteObject(-300, -300));

        }
    }
//
//    @Override
//    public void paint(Graphics g) {
//
//    }
}


