package me.simonhaasnoot.geinigspel.legacy;

import me.simonhaasnoot.geinigspel.Values;

/**
 * Created by Simon on 2/18/2016.
 */
public class Character{

    public Character() { }

    public void collision() {

        // als de player verder dan 710px gaat kan hij niet meer verder
        if(Values.playerX >= 1028 -  65){
            Values.playerX = 1028- 65;
        }

        // als de player lager gaat dan 10px kan hij niet meer verder
        if(Values.playerX <= 0){
            Values.playerX = 0;
        }
    }

    public void isDead(){
        if(Values.lives == 0){
            Values.deadChar = true;
        }
    }

    public void move(){
        // used for going left and right.
        if(Values.playerXleft){
            Values.playerX = Values.playerX - Values.playerSpeed;
        }
        if(Values.PlayerXright){
            Values.playerX = Values.playerX + Values.playerSpeed;
        }
    }
}