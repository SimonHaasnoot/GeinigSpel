package me.simonhaasnoot.geinigspel.level;

import me.simonhaasnoot.geinigspel.Values;

public class Level1 extends BaseLevel {

    @Override
    public void update() {
        // First fireball comes down upon game start.
        Values.yArray[0] = Values.yArray[0] + Values.fireballValsnelheid2;

        // After 15 seconds 1 fireball drops
        if(Values.difference > 15000){
            Values.yArray[1] = Values.yArray[1] + Values.fireballValsnelheid;
        }
        // After 20 seconds 1 fireball drops
        if(Values.difference > 20000){
            Values.yArray[2] = Values.yArray[2] + Values.fireballValsnelheid2;
        }
        // After 25 seconds 2 fireball drops
        if(Values.difference > 25000){
            Values.yArray[3] = Values.yArray[3] + Values.fireballValsnelheid2;
            Values.yArray[4] = Values.yArray[4] + Values.fireballValsnelheid;
        }
        // After 30 seconds 2 fireball drops
        if(Values.difference > 30000){
            Values.yArray[5] = Values.yArray[5] + Values.fireballValsnelheid2;
            Values.yArray[6] = Values.yArray[6] + Values.fireballValsnelheid2;
        }
        // After 35 seconds 2 fireballs drop.
        if(Values.difference > 35000){
            Values.yArray[7] = Values.yArray[7] + Values.fireballValsnelheid;
            Values.yArray[8] = Values.yArray[8] + Values.fireballValsnelheid;
        }
        // After 4- seconds 2 fireballs drop.
        if(Values.difference > 40000){
            Values.yArray[9] = Values.yArray[9] + Values.fireballValsnelheid2;
            Values.yArray[10] = Values.yArray[10] + Values.fireballValsnelheid2;
        }
        // After 44 seconds 2 fireballs drop.
        if(Values.difference > 44000){
            Values.yArray[11] = Values.yArray[11] + Values.fireballValsnelheid;
            Values.yArray[12] = Values.yArray[12] + Values.fireballValsnelheid2;
        }
        // After 48 seconds 2 fireballs drop.
        if(Values.difference > 48000){
            Values.yArray[13] = Values.yArray[13] + Values.fireballValsnelheid2;
            Values.yArray[14] = Values.yArray[14] + Values.fireballValsnelheid2;
        }
    }
}
