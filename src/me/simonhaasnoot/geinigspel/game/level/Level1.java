package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.GameStateManager;
import me.simonhaasnoot.geinigspel.game.entity.*;
import me.simonhaasnoot.geinigspel.game.time.FrameTime;

import java.awt.*;

public class Level1 extends BaseLevel {

    @Override
    public void start(GameStateManager gsm) {
        // Get the game state manager
        GameStateManager gameStateManager = GameManager.getGameStateManager();

        // Set the frame background
        gameStateManager.setBackgroundImage(Toolkit.getDefaultToolkit().createImage("Images/Landscape/1028x768BB.png"));

        // Create the health object
        gameStateManager.addGameObject(new HealthViewerObject(0, 0));
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
        if(Math.random() < FrameTime.time / ((Math.sqrt(FrameTime.time)*2) * 250.0 ))
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


