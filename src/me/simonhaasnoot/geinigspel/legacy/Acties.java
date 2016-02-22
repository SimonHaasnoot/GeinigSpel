package me.simonhaasnoot.geinigspel.legacy;

import java.awt.event.*;

public class Acties extends Tekenen implements KeyListener, ActionListener{

    public static long startTime;

            Fireball    fireball    = new Fireball();
            Shield      shield      = new Shield();
            Character   character   = new Character();
            Thunder     thunder     = new Thunder();
            Meteorite   meteorite   = new Meteorite();

    public void actionPerformed(ActionEvent e) {

        // start game loop
        gameLoop();

        // call level + objects.
        //Values.level.update();
        fireball.collision();

        shield.collision();
        character.collision();
        character.move();
        character.isDead();
        thunder.collision();
        meteorite.collision();
    }

    public void gameLoop(){

        // run a timer upon game start
        long currentTime = System.currentTimeMillis();

        if(Values.uitLoop == 0) {
            startTime = currentTime;
            Values.uitLoop++;
        }
        //calculate time diff
        Values.timeDifference = currentTime - startTime;
    }

    public void keyTyped(KeyEvent e) { }

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

                Values.cloneArray = Values.fallingSpeed.clone();
                for (int i = 0; i < Values.fallingSpeed.length; i++) {
                    Values.fallingSpeed[i] = 0;
                }

                Values.playerSpeed = 0;
                Values.isPauze = true;

                //if P is pressed again, isPauze is false. The game continues. The actual time is getting calculated again and speeds are set to normal.
            }  else{

                Values.isPauze = false;
                startTime = System.currentTimeMillis() - Values.pauseTime;
                // Copy the array
                System.arraycopy(Values.cloneArray, 0, Values.fallingSpeed, 0, Values.fallingSpeed.length);
                Values.playerSpeed = 5;
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
}