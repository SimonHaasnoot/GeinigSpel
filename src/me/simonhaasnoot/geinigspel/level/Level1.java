package me.simonhaasnoot.geinigspel.level;

import me.simonhaasnoot.geinigspel.Values;

public class Level1 extends BaseLevel {

    private int                 count;
    private boolean             ThundercountBool = true;
    private int                 shieldDropSpawntime = (int)(Math.random()*2000 + 1000);

    public void update() {

            dropShield();
            spawnThunder();
            spawnFireballs();
        }

    public void spawnThunder(){

        if(Values.timeDifference >= Values.thunderRandomTime[0] - 50 && Values.timeDifference <= Values.thunderRandomTime[0]){
            Values.spawnThunder = true;
            Values.thunderCollide = true;

            if(ThundercountBool){
                ThundercountBool = false;
                count++;
            }
        }

        if(count == 1){
            if(Values.timeDifference >= Values.thunderRandomTime[1] - 50 && Values.timeDifference <= Values.thunderRandomTime[1]){
                Values.spawnThunder = true;
                Values.thunderCollide = true;

                if(ThundercountBool) {
                    ThundercountBool = false;
                    count++;
                     }
            }
        }
    }

    public void dropShield() {

        if (Values.timeDifference >= shieldDropSpawntime - 50 && Values.timeDifference <= shieldDropSpawntime) {
            Values.spawnShield = true;
        }
    }

    public void spawnFireballs(){

        Values.yObject[0] = Values.yObject[0] + Values.fallingSpeed[0];

        // After 15 seconds 1 fireball drops
        if(Values.timeDifference > 15000){
            Values.yObject[1] = Values.yObject[1] + Values.fallingSpeed[1];
        }
        // After 20 seconds 1 fireball drops
        if(Values.timeDifference > 25000){
            Values.yObject[2] = Values.yObject[2] + Values.fallingSpeed[2];
        }
        // After 25 seconds 2 fireball drops
        if(Values.timeDifference > 35000){
            Values.yObject[3] = Values.yObject[3] + Values.fallingSpeed[3];
            Values.yObject[4] = Values.yObject[4] + Values.fallingSpeed[4];
        }
        // After 30 seconds 2 fireball drops
        if(Values.timeDifference > 40000){
            Values.yObject[5] = Values.yObject[5] + Values.fallingSpeed[5];
            Values.yObject[6] = Values.yObject[6] + Values.fallingSpeed[6];
        }
        // After 35 seconds 2 fireballs drop.
        if(Values.timeDifference > 50000){
            Values.yObject[7] = Values.yObject[7] + Values.fallingSpeed[7];
            Values.yObject[8] = Values.yObject[8] + Values.fallingSpeed[8];
        }
        // After 40 seconds 2 fireballs drop.
        if(Values.timeDifference > 55000){
            Values.yObject[9] = Values.yObject[9] + Values.fallingSpeed[9];
            Values.yObject[10] = Values.yObject[10] + Values.fallingSpeed[10];
        }
        // After 44 seconds 2 fireballs drop.
        if(Values.timeDifference > 60000){
            Values.yObject[11] = Values.yObject[11] + Values.fallingSpeed[11];
            Values.yObject[12] = Values.yObject[12] + Values.fallingSpeed[12];
        }
        // After 48 seconds 2 fireballs drop.
        if(Values.timeDifference > 64000){
            Values.yObject[13] = Values.yObject[13] + Values.fallingSpeed[13];
            Values.yObject[14] = Values.yObject[14] + Values.fallingSpeed[14];
        }

        if(Values.timeDifference > 68000){
            Values.yObject[15] = Values.yObject[15] + Values.fallingSpeed[15];
            Values.yObject[16] = Values.yObject[16] + Values.fallingSpeed[16];
        }
        if(Values.timeDifference > 75000){
            Values.yObject[17] = Values.yObject[17] + Values.fallingSpeed[17];
            Values.yObject[18] = Values.yObject[18] + Values.fallingSpeed[18];
        }
        if(Values.timeDifference > 80000){
            Values.yObject[19] = Values.yObject[19] + Values.fallingSpeed[19];
            Values.yObject[20] = Values.yObject[20] + Values.fallingSpeed[20];
        }
        if(Values.timeDifference > 85000){
            Values.yObject[21] = Values.yObject[21] + Values.fallingSpeed[21];
            Values.yObject[22] = Values.yObject[22] + Values.fallingSpeed[22];
        }
        if(Values.timeDifference > 90000){
            Values.yObject[23] = Values.yObject[23] + Values.fallingSpeed[23];
            Values.yObject[24] = Values.yObject[24] + Values.fallingSpeed[24];
        }
        if(Values.timeDifference > 92000){
            Values.yObject[25] = Values.yObject[25] + Values.fallingSpeed[25];
            Values.yObject[26] = Values.yObject[26] + Values.fallingSpeed[26];
        }
        if(Values.timeDifference > 95000){
            Values.yObject[27] = Values.yObject[27] + Values.fallingSpeed[27];
            Values.yObject[28] = Values.yObject[28] + Values.fallingSpeed[28];
        }
        if(Values.timeDifference > 100000){
            Values.yObject[29] = Values.yObject[29] + Values.fallingSpeed[29];
            Values.yObject[30] = Values.yObject[30] + Values.fallingSpeed[30];
        }
    }
}
