package me.simonhaasnoot.geinigspel.level;

import me.simonhaasnoot.geinigspel.Values;

public class Level1 extends BaseLevel {

    public void update() {
        dropShield();
        spawnThunder();
        spawnFireballs();
        spawnMeteorite();
    }

    public void spawnMeteorite(){

        int meteoriteSpawntime = (int)(Math.random()*1000 + 8000);

        if((meteoriteSpawntime - Values.timeDifference) < 5000){
            Values.spawnMeteoriteWarning = true;
        }

        if(Values.timeDifference >= meteoriteSpawntime - 50 && Values.timeDifference <= meteoriteSpawntime){
            Values.spawnMeteorite = true;

        }
        if(Values.spawnMeteorite ){
            Values.spawnMeteoriteWarning = false;

            Values.meteoriteX = Values.meteoriteX - 6;
            Values.meteoriteY = Values.meteoriteY + 5;
        }

    }

    public void spawnThunder() {
        boolean thundercountBool = true;

        for(int i = 0; i < Values.thunderRandomTime.length; i++) {
            if(Values.timeDifference >= Values.thunderRandomTime[i] - 50 && Values.timeDifference <= Values.thunderRandomTime[i]){
                Values.spawnThunder = true;
                Values.thunderCollide = true;

                if(thundercountBool){
                    thundercountBool = false;
                }
            }
        }
    }

    public void dropShield() {

        int shieldDropSpawntime = (int)(Math.random()*50000 + 1000);

        if (Values.timeDifference >= shieldDropSpawntime - 50 && Values.timeDifference <= shieldDropSpawntime) {
            Values.spawnShield = true;
        }
    }

    public void spawnFireballs(){
        // The times all the fireballs should be dropped at
        final int[] fireballTimes = {
                0,
                5000,
                10000,
                15000,
                15000,
                25000,
                25000,
                35000,
                35000,
                50000,
                50000,
                60000,
                60000,
                64000,
                64000,
                68000,
                68000,
                75000,
                75000,
                80000,
                80000,
                85000,
                85000,
                90000,
                90000,
                92000,
                92000,
                95000,
                95000,
                100000,
                100000,
        };

        // Loop through all the fireball spawn times
        for(int i = 0; i < fireballTimes.length; i++) {
            // Make sure this time has passed before spawning and moving the fireball
            if(Values.timeDifference <= fireballTimes[i])
                continue;

            // Spawn and move the current fireball
            Values.yObject[i] = Values.yObject[i] + Values.fallingSpeed[i];
        }
    }
}
