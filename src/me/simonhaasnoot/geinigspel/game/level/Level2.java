package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.GameStateManager;
import me.simonhaasnoot.geinigspel.game.entity.CharacterObject;
import me.simonhaasnoot.geinigspel.game.entity.FireballObject;
import me.simonhaasnoot.geinigspel.game.time.FrameTime;

import java.awt.*;

public class Level2 extends BaseLevel {

    @Override
    public void start(GameStateManager gsm) {

        // Set the frame background
        GameManager.getGameStateManager().setBackgroundImage(Toolkit.getDefaultToolkit().createImage("Images/Landscape/1028x768BB.png"));

    }

    @Override
    public void update(GameStateManager gsm) {
        // Spawn the fireballs
        if (Math.random() < FrameTime.time / (Math.sqrt(FrameTime.time) * 250.0 / 150))
            gsm.addGameObject(new FireballObject(Math.random() * GameManager.getGameFrame().getWidth() - FireballObject.SIZE_WIDTH, -FireballObject.SIZE_HEIGHT));

    }

    @Override
    public CharacterObject getCharacter() {
        return null;
    }

    @Override
    public void registerKeys() {

    }

}
