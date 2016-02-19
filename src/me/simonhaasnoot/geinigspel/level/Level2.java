package me.simonhaasnoot.geinigspel.level;
import me.simonhaasnoot.geinigspel.Values;


public class Level2 extends BaseLevel {

    public void update(){


        Values.yObject[0] = Values.yObject[0] + Values.fallingSpeed[0];

        // After 15 seconds 1 fireball drops
        if(Values.timeDifference > 5000){
            Values.yObject[1] = Values.yObject[1] + Values.fallingSpeed[1];
        }
        // After 20 seconds 1 fireball drops
        if(Values.timeDifference > 10000){
            Values.yObject[2] = Values.yObject[2] + Values.fallingSpeed[2];
        }
        // After 25 seconds 2 fireball drops
        if(Values.timeDifference > 10000){
            Values.yObject[3] = Values.yObject[3] + Values.fallingSpeed[3];
            Values.yObject[4] = Values.yObject[4] + Values.fallingSpeed[4];
        }
        // After 30 seconds 2 fireball drops
        if(Values.timeDifference > 10000){
            Values.yObject[5] = Values.yObject[5] + Values.fallingSpeed[5];
            Values.yObject[6] = Values.yObject[6] + Values.fallingSpeed[6];
        }
        // After 35 seconds 2 fireballs drop.
        if(Values.timeDifference > 10000){
            Values.yObject[7] = Values.yObject[7] + Values.fallingSpeed[7];
            Values.yObject[8] = Values.yObject[8] + Values.fallingSpeed[8];
        }

        // After 4- seconds 2 fireballs drop.
        if(Values.timeDifference > 10000){
            Values.yObject[9] = Values.yObject[9] + Values.fallingSpeed[9];
            Values.yObject[10] = Values.yObject[10] + Values.fallingSpeed[10];
        }
        // After 44 seconds 2 fireballs drop.
        if(Values.timeDifference > 10000){
            Values.yObject[11] = Values.yObject[11] + Values.fallingSpeed[11];
            Values.yObject[12] = Values.yObject[12] + Values.fallingSpeed[12];
        }
        // After 48 seconds 2 fireballs drop.
        if(Values.timeDifference > 10000) {
            Values.yObject[13] = Values.yObject[13] + Values.fallingSpeed[13];
            Values.yObject[14] = Values.yObject[14] + Values.fallingSpeed[14];

        }
    }

    @Override
    public void spawnMeteorite() { }

    @Override
    public void spawnThunder() { }

    @Override
    public void dropShield() { }

    @Override
    public void spawnFireballs() { }
}
