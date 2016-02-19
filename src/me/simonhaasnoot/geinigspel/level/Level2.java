package me.simonhaasnoot.geinigspel.level;

import me.simonhaasnoot.geinigspel.Values;

public class Level2 extends BaseLevel {

    public void update(){
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
