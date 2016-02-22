package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.game.GameStateManager;

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

}
