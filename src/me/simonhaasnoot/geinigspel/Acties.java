package me.simonhaasnoot.geinigspel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Acties extends Tekenen implements KeyListener, ActionListener {

    public static long startTime;

    @Override
    public void actionPerformed(ActionEvent e) {

        long currentTime = System.currentTimeMillis();

        if(Values.uitLoop == 0) {
            startTime = currentTime;
            Values.uitLoop++;
        }

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

        // logische boolean om de game op pauze te zetten
        if (e.getKeyCode() == KeyEvent.VK_P) {

            Values.pauzeCount++;

            if(Values.pauzeCount % 2 == 0){
                Values.isPauze = true;
                Values.pauseTime = System.currentTimeMillis() - startTime;
                Values.fireballValsnelheid = 0;
                Values.fireballValsnelheid2 = 0;
                Values.playerSpeed = 0;

            }  else{

                Values.isPauze = false;
                startTime = System.currentTimeMillis() - Values.pauseTime;
                Values.fireballValsnelheid = 2;
                Values.fireballValsnelheid2 = 3;
                Values.playerSpeed = 5;
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