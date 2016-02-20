package me.simonhaasnoot.geinigspel.legacy;

import me.simonhaasnoot.geinigspel.Values;

/**
 * Created by Simon on 2/18/2016.
 */
public class Thunder {

    public void collision(){

        if(Values.thunderCollide){

            if((Values.playerX + 30 > Values.randomXthunderSpawn && Values.playerX < Values.randomXthunderSpawn + 150) &&
                    Values.spawnThunder && (Values.timeDifferenceThunder > 2000 && Values.timeDifferenceThunder < 2400)) {

                Values.lives -= 1;
                Values.thunderCollide = false;
            }
        }
    }
}
