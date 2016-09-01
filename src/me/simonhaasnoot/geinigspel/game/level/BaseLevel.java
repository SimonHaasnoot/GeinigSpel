package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.game.GameStateManager;
import me.simonhaasnoot.geinigspel.game.entity.CharacterObject;

import java.awt.*;

public abstract class BaseLevel {

    /**
     * Called when the level is started.
     *
     * @param gsm The GameStateManager instance.
     */
    public abstract void start(GameStateManager gsm);

    /**
     * Called each time the level is updated.
     *
     * @param gsm The GameStateManager instance.
     */
    public abstract void update(GameStateManager gsm);

    /**
     *
     * @return wizardObject. (the playable character).
     */
    public abstract CharacterObject getCharacter();

    /**
     * register all keys pressed.
     */
    public abstract void registerKeys(GameStateManager gsm);

    /**
     * Called everytime the update method is called, draws certain level things on screen.
     * @param g the drawable content.
     */
    public abstract void paint(Graphics2D g);
}
