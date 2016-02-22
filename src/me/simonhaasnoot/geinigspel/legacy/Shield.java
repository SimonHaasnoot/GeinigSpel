package me.simonhaasnoot.geinigspel.legacy;

/**
 * Created by Simon on 2/18/2016.
 */
public class Shield {

    public Shield() { }

    public void collision(){

        if(Values.playerX + 30 >= Values.randomXshieldSpawn - 10 && Values.playerX  <= Values.randomXshieldSpawn +35 && Values.spawnShield){
            Values.activateShield = true;
        }
    }
}

