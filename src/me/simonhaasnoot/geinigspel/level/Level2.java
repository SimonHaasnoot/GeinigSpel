package me.simonhaasnoot.geinigspel.level;
import me.simonhaasnoot.geinigspel.Values;

public class Level2 extends BaseLevel {

    public void update(){

        Values.yObject[0] = Values.yObject[0] + Values.ObjectFallSpeed2;

        // After 15 seconds 1 fireball drops
        if(Values.timeDifference > 5000){
            Values.yObject[1] = Values.yObject[1] + Values.ObjectFallSpeed;
        }
        // After 20 seconds 1 fireball drops
        if(Values.timeDifference > 10000){
            Values.yObject[2] = Values.yObject[2] + Values.ObjectFallSpeed2;
        }
        // After 25 seconds 2 fireball drops
        if(Values.timeDifference > 10000){
            Values.yObject[3] = Values.yObject[3] + Values.ObjectFallSpeed2;
            Values.yObject[4] = Values.yObject[4] + Values.ObjectFallSpeed;
        }
        // After 30 seconds 2 fireball drops
        if(Values.timeDifference > 10000){
            Values.yObject[5] = Values.yObject[5] + Values.ObjectFallSpeed2;
            Values.yObject[6] = Values.yObject[6] + Values.ObjectFallSpeed2;
        }
        // After 35 seconds 2 fireballs drop.
        if(Values.timeDifference > 10000){
            Values.yObject[7] = Values.yObject[7] + Values.ObjectFallSpeed;
            Values.yObject[8] = Values.yObject[8] + Values.ObjectFallSpeed;
        }
        // After 4- seconds 2 fireballs drop.
        if(Values.timeDifference > 10000){
            Values.yObject[9] = Values.yObject[9] + Values.ObjectFallSpeed2;
            Values.yObject[10] = Values.yObject[10] + Values.ObjectFallSpeed2;
        }
        // After 44 seconds 2 fireballs drop.
        if(Values.timeDifference > 10000){
            Values.yObject[11] = Values.yObject[11] + Values.ObjectFallSpeed;
            Values.yObject[12] = Values.yObject[12] + Values.ObjectFallSpeed2;
        }
        // After 48 seconds 2 fireballs drop.
        if(Values.timeDifference > 10000) {
            Values.yObject[13] = Values.yObject[13] + Values.ObjectFallSpeed2;
            Values.yObject[14] = Values.yObject[14] + Values.ObjectFallSpeed2;

        }
    }
}
