package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.GameStateManager;
import me.simonhaasnoot.geinigspel.game.entity.*;
import me.simonhaasnoot.geinigspel.game.frame.GameFrame;
import me.simonhaasnoot.geinigspel.game.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Level1 extends BaseLevel {

    private CharacterObject wizardCharacter;

    @Override
    public void start(GameStateManager gsm) {
        // Get the game state manager

        // Set the frame background
        if(gsm.getBackgroundImage() == null)
            gsm.setBackgroundImage(Toolkit.getDefaultToolkit().createImage("Images/Landscape/1028x768BB.png"));

        // Create the health object
        gsm.addGameObject(new HealthViewerObject(0, 0));

        wizardCharacter = new CharacterObject(GameFrame.FRAME_WIDTH/2, GameFrame.FRAME_HEIGHT - CharacterObject.SIZE_HEIGHT*1.85);
        gsm.addGameObject(wizardCharacter);

    }

    @Override
    public void update(GameStateManager gsm) {

        // Spawn the fireballs
        if(Math.random() < gsm.levelTimer.getElapsedTime() / (Math.sqrt(gsm.levelTimer.getElapsedTime()) * 250.0 ))
            gsm.addGameObject(new FireballObject(Math.random() * GameManager.getGameFrame().getWidth() -FireballObject.SIZE_WIDTH, -FireballObject.SIZE_HEIGHT));


        // spawn freezeballs
        if(Math.random() < gsm.levelTimer.getElapsedTime() / ((Math.sqrt(gsm.levelTimer.getElapsedTime())*8) * 250.0 ))
            gsm.addGameObject(new FreezeFireballObject(Math.random() * GameManager.getGameFrame().getWidth() -FireballObject.SIZE_WIDTH, -FireballObject.SIZE_HEIGHT));


        // spawn thunder clouds
//        if(Math.random() < FrameTime.time / ((Math.sqrt(FrameTime.time)*20) * 250.0 ))
//            gsm.addGameObject(new ThunderObject(Math.random() * GameManager.getGameFrame().getWidth() - ThunderObject.SIZE_WIDTH, 150));


        // spawn meteorite
        if(gsm.levelTimer.getElapsedTime() > 60) {
            if (Math.random() < gsm.levelTimer.getElapsedTime() / ((Math.sqrt(gsm.levelTimer.getElapsedTime()) *30) * 1000.0))
                gsm.addGameObject(new MeteoriteObject(-300, -300));
        }

        //spawn lifehearts
        if(Math.random() < gsm.levelTimer.getElapsedTime() / ((Math.sqrt(gsm.levelTimer.getElapsedTime()) *60) * 250.0)) {
            gsm.addGameObject(new LifeheartObject(Math.random() * GameManager.getGameFrame().getWidth() - LifeheartObject.SIZE_WIDTH, GameFrame.FRAME_HEIGHT - LifeheartObject.SIZE_HEIGHT * 3.2));
        }

    }

    @Override
    public CharacterObject getCharacter() {
        return wizardCharacter;
    }

    @Override
    public void registerKeys() {
        if(Input.isPressed(KeyEvent.VK_ESCAPE) || Input.isPressed(KeyEvent.VK_R))
            GameManager.getGameStateManager().loadLevel(new Level1());

        if(Input.isPressed(KeyEvent.VK_P)) {
            wizardCharacter.setSpeedX(0);
            //GameManager.getGameStateManager().levelTimer.


        }

    }

}


