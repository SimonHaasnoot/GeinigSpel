package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.Values;
import me.simonhaasnoot.geinigspel.game.GameStateManager;

public class Level2 extends BaseLevel {

    @Override
    public void start(GameStateManager gsm) {

    }

    @Override
    public void update(GameStateManager gsm){
        // The times all the fireballs should be dropped at
        final int[] fireballTimes = {
                0,
                5000,
                10000,
                10000,
                10000,
                10000,
                10000,
                10000,
                10000,
                10000,
                10000,
                10000,
                10000,
                10000,
                10000,
        };

        // Loop through all the fireball spawn times
        for(int i = 0; i < fireballTimes.length; i++) {
            // Make sure this time has passed before spawning and moving the fireball
            if(Values.timeDifference <= fireballTimes[i])
                continue;

            // Spawn and move the current fireball
            Values.yObject[i] += Values.fallingSpeed[i];
        }
    }
}
