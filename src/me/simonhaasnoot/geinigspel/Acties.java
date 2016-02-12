package me.simonhaasnoot.geinigspel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Acties extends Tekenen implements KeyListener, ActionListener {

    public static long startTime;

    public void actionPerformed(ActionEvent e) {

        // run a timer upon game start
        long currentTime = System.currentTimeMillis();


        // save this time once, so you get the starting time =: startTime;
        if(Values.uitLoop == 0) {
            startTime = currentTime;
            Values.uitLoop++;
        }

        // calculate the timeDifference between the start and the actual in game time. so that you can get the actual current time of playing.
        Values.timeDifference = currentTime - startTime;

        // Update the game level
        Values.level.update();
        playerBoundaryCheck();
        fireballCollisionCheck();

        // used for going left and right.
        if(Values.playerXleft){
            Values.playerX = Values.playerX - Values.playerSpeed;
        }
        if(Values.PlayerXright){
            Values.playerX = Values.playerX + Values.playerSpeed;
        }
    }

    public void keyTyped(KeyEvent e) {

    }

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
                Values.pauseTime = System.currentTimeMillis() - startTime;
                Values.ObjectFallSpeed = 0;     Values.ObjectFallSpeed2 = 0;    Values.playerSpeed = 0;
                Values.isPauze = true;

                //if P is pressed again, isPauze is false. The game continues. The actual time is getting calculated again and speeds are set to normal.
            }  else{

                Values.isPauze = false;
                startTime = System.currentTimeMillis() - Values.pauseTime;
                Values.ObjectFallSpeed = 2;     Values.ObjectFallSpeed2 = 3;    Values.playerSpeed = 5;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            Values.playerXleft = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            Values.PlayerXright = false;
        }

    }

    public void playerBoundaryCheck(){

        // als de player verder dan 710px gaat kan hij niet meer verder
        if(Values.playerX >= 730){
            Values.playerX = 730;
        }
        // als de player lager gaat dan 10px kan hij niet meer verder
        if(Values.playerX <= 0){
            Values.playerX = 0;
        }
    }

    public void fireballCollisionCheck() {


        for (int i = 0; i < Values.objects; i++) {
            if (Values.yObject[i] > 610) {
                Values.yObject[i] = (int)(Math.random() * -80 -30);
                Values.xObject[i] = (int) (Math.random() * 765 + 10);
            }
        }

        for (int i = 0; i < Values.objects; i++) {
            if (Values.yObject[i] <= Values.playerY + 50 && Values.yObject[i] > Values.playerY - 30 &&
                    (Values.xObject[i] <= Values.playerX + 50 && Values.xObject[i] >= Values.playerX - 15)) {

                Values.yObject[i] =(int)(Math.random() * -80 -30);
                Values.xObject[i] = (int) (Math.random() * 765 + 10);
                Values.lives -= 1;
            }
        }
    }
}