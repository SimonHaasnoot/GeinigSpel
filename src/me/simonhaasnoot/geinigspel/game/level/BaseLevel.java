package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.game.GameStateManager;

public abstract class BaseLevel {

    public abstract void start(GameStateManager gsm);

    public abstract void update(GameStateManager gsm);
}
