package me.simonhaasnoot.geinigspel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Acties extends Tekenen implements KeyListener, ActionListener {

    public static long startTime;

    @Override
    public void actionPerformed(ActionEvent e) {

        // run a timer upon game start
        long currentTime = System.currentTimeMillis();


        // save this time once, so you get the starting time =: startTime;
        if(Values.uitLoop == 0) {
            startTime = currentTime;
            Values.uitLoop++;
        }

        // calculate the difference between the start and the actual in game time. so that you can get the actual current time of playing.
        Values.difference = currentTime - startTime;

        // Update the game level
        Values.level.update();

        // used for going left and right.
        if(Values.playerXleft){
            Values.playerXas = Values.playerXas - Values.playerSpeed;
        }
        if(Values.PlayerXright){
            Values.playerXas = Values.playerXas + Values.playerSpeed;
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

        // By pressing P you enter the pause menu.
        if (e.getKeyCode() == KeyEvent.VK_P) {

            // counts pauzeCount++ per time that you pause or unpause.
            Values.pauzeCount++;

            // if the pauzeCount's modulo is equal to 0(if P is pressed for the first time, or 3rd, or 5th etc.) Pause is true.
            // this means that you need to calculate the time between the time you paused and the actual game time thats still running.
            // set the values of certain speeds to 0 so that nothing can move.
            if(Values.pauzeCount % 2 == 0){
                Values.isPauze = true;
                Values.pauseTime = System.currentTimeMillis() - startTime;
                Values.fireballValsnelheid = 0;     Values.fireballValsnelheid2 = 0;    Values.playerSpeed = 0;

                //if P is pressed again, isPauze is false. The game continues. The actual time is getting calculated again and speeds are set to normal.
            }  else{

                Values.isPauze = false;
                startTime = System.currentTimeMillis() - Values.pauseTime;
                Values.fireballValsnelheid = 2;     Values.fireballValsnelheid2 = 3;    Values.playerSpeed = 5;
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
}