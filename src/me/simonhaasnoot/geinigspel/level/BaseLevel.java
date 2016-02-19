package me.simonhaasnoot.geinigspel.level;
public abstract class BaseLevel {

    public abstract void update();

    public abstract void spawnMeteorite();
    public abstract void spawnThunder();
    public abstract void dropShield();
    public abstract void spawnFireballs();
}
