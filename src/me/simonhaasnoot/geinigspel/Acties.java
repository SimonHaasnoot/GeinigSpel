package me.simonhaasnoot.geinigspel;

import me.simonhaasnoot.geinigspel.level.Level1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Acties extends Tekenen implements KeyListener, ActionListener {

    public static long currentTime;

    @Override
    public void actionPerformed(ActionEvent e) {

        long startTime = System.currentTimeMillis();

        if(Values.uitLoop == 0) {
            currentTime = startTime;
            Values.uitLoop++;
        }
        Values.difference = startTime - currentTime;

        GameLevel1();

        // used for going left and right.
        if(Values.playerXleft){
            Values.playerXas = Values.playerXas - Values.playerSpeed;
        }
        if(Values.PlayerXright){
            Values.playerXas = Values.playerXas + Values.playerSpeed;
        }


        // pausing the game
        if(Values.isPauze){
            Values.pauseTime = startTime;
            Values.fireballValsnelheid = 0;
            Values.fireballValsnelheid2 = 0;
            Values.playerSpeed = 0;

        }

        // resuming the game
        if(!Values.isPauze){
            Values.pauseDifference = startTime - Values.pauseTime;
        //    me.simonhaasnoot.geinigspel.Values.difference - me.simonhaasnoot.geinigspel.Values.pauseDifference;

            Values.fireballValsnelheid = 2;
            Values.fireballValsnelheid2 = 3;
            Values.playerSpeed = 5;
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        // if Left or A is pressed, you initiate playerXleft, what means that u'll go left.
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            Values.playerXleft = true;
            Values.PlayerXright = false;
        }
        // if Left or A is pressed, you initiate playerXright, what means that u'll go right.
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            Values.PlayerXright = true;
            Values.playerXleft = false;
        }
        repaint();

        // logische boolean om de game op pauze te zetten
        if (e.getKeyCode() == KeyEvent.VK_P) {

            Values.pauzeCount++;
            if(Values.pauzeCount % 2 == 0){
                Values.isPauze = true;
                System.out.println("true");
            }
                else{
                    Values.isPauze = false;
                System.out.println("false");
                }
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            Values.playerXleft = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            Values.PlayerXright = false;
        }

    }


    public void GameLevel1(){

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