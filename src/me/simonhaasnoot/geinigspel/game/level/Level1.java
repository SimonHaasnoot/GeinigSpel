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

    //// TODO: 1-9-2016 Make make a portrait object
    private Image portraitImage;

    @Override
    public void start(GameStateManager gsm) {
        // Get the game state manager

        // Set the frame background
            gsm.setBackgroundImage(Toolkit.getDefaultToolkit().createImage("Images/Landscape/1028x768BB.png"));

        if(portraitImage == null)
        portraitImage = Toolkit.getDefaultToolkit().createImage("Images/Portraits/itemPortrait.png");

        // Create the health object
        gsm.addGameObject(new HealthViewerObject(0, 0));


        // create the player
        gsm.addGameObject(wizardCharacter = new CharacterObject(GameManager.getGameFrame().getWidth()/2, 0));
    }

    @Override
    public void update(GameStateManager gsm) {

        // Spawn the fireball
        if(Math.random() < gsm.levelTimer.getElapsedTime() / (Math.sqrt(gsm.levelTimer.getElapsedTime()) * 250.0 ))
            gsm.addGameObject(new FireballObject(Math.random() * GameManager.getGameFrame().getWidth() -FireballObject.SIZE_WIDTH, -FireballObject.SIZE_HEIGHT));


        // spawn freeze
        if(Math.random() < gsm.levelTimer.getElapsedTime() / ((Math.sqrt(gsm.levelTimer.getElapsedTime())*8) * 250.0 ))
            gsm.addGameObject(new FreezeFireballObject(Math.random() * GameManager.getGameFrame().getWidth() -FireballObject.SIZE_WIDTH, -FireballObject.SIZE_HEIGHT));


        // spawn thunder cloud
//        if(Math.random() < FrameTime.time / ((Math.sqrt(FrameTime.time)*20) * 250.0 ))
//            gsm.addGameObject(new ThunderObject(Math.random() * GameManager.getGameFrame().getWidth() - ThunderObject.SIZE_WIDTH, 150));


        // spawn meteorite
        if(gsm.levelTimer.getElapsedTime() > 60) {
            if (Math.random() < gsm.levelTimer.getElapsedTime() / ((Math.sqrt(gsm.levelTimer.getElapsedTime()) *30) * 1000.0))
                gsm.addGameObject(new MeteoriteObject(-300, -300));
        }

        //spawn lifeheart
        if(Math.random() < gsm.levelTimer.getElapsedTime() / ((Math.sqrt(gsm.levelTimer.getElapsedTime()) *80) * 250.0)) {
            gsm.addGameObject(new LifeheartObject((Math.random() * GameManager.getGameFrame().getWidth() - LifeheartObject.SIZE_WIDTH)
                    + LifeheartObject.SIZE_WIDTH , GameManager.getGameFrame().getHeight() - (GameManager.getGameFrame().getHeight()/19.2) * 3.2));
        }

        // spawn protective orb
        if(Math.random() < gsm.levelTimer.getElapsedTime() / ((Math.sqrt(gsm.levelTimer.getElapsedTime())* 1) * 250.0)) {
            gsm.addGameObject(new ProtectiveOrbObject(Math.random() * GameManager.getGameFrame().getWidth() - ProtectiveOrbObject.SIZE_WIDTH,
                    GameManager.getGameFrame().getHeight() - (GameManager.getGameFrame().getHeight()/19.2) * 3.2));
        }

    }

    @Override
    public void registerKeys(GameStateManager gsm) {

        // reset the level
        if(Input.isPressed(KeyEvent.VK_R))
            gsm.loadLevel(new Level1());

        // pause the game
        if(Input.isPressedOnce(KeyEvent.VK_ESCAPE) || Input.isPressedOnce(KeyEvent.VK_P))
            gsm.pauseGame();

        // use your item
        if(Input.isPressedOnce(KeyEvent.VK_SPACE)) ;
    }

    @Override
    public void paint(Graphics2D g) {

        // warning message for incoming meteorites
        if(GameManager.getGameStateManager().levelTimer.getElapsedTime() > 55 && GameManager.getGameStateManager().levelTimer.getElapsedTime() < 60) {
            Font font = new Font("Calibri", Font.PLAIN, 26);
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString("WARNING! Incoming meteorites detected!", GameFrame.FRAME_HEIGHT / 3, GameFrame.FRAME_HEIGHT / 4);
        }


        g.drawImage(portraitImage, GameManager.getGameFrame().getWidth()  - 120, GameFrame.HEIGHT +
                HealthViewerObject.SIZE_HEIGHT + HealthViewerObject.SIZE_HEIGHT/2, 100, 100, null);
    }

    @Override
    public CharacterObject getCharacter() {
        return wizardCharacter;
    }

}


