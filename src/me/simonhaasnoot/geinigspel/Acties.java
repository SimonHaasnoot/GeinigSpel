package me.simonhaasnoot.geinigspel;
import java.awt.event.*;

public class Acties extends Tekenen implements KeyListener, ActionListener{

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
        shieldCollision();
        thunderCollision();

        if(Values.lives == 0){
            Values.deadChar = true;
        }

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
                for (int i = 0; i < Values.fallingSpeed.length; i++) {
                    Values.fallingSpeed[i] = Values.cloneArray[i];

                }
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

    public void shieldCollision(){

        if(Values.playerX + 25 >= Values.randomXshieldSpawn -30 && Values.playerX + 25 <= Values.randomXshieldSpawn +30 && Values.spawnShield){
            Values.activateShield = true;
        }
    }

    public void thunderCollision(){
        if(Values.thunderCollide == true){
            if((Values.playerX + 30 > Values.randomXthunderSpawn && Values.playerX < Values.randomXthunderSpawn + 150) && Values.spawnThunder && (Values.timeDifferenceThunder > 2000 && Values.timeDifferenceThunder < 2400)) {

            Values.lives -= 1;
            Values.thunderCollide = false;
            }
        }
    }

    public void fireballCollisionCheck() {

        // if the object reaches the outers of the field, reset them to spawn from above again
        for (int i = 0; i < Values.objects; i++) {
            if (Values.yObject[i] > 610) {
                if(Values.timeDifference < 30000) {
                    Values.yObject[i] = (int) (Math.random() * -160 - 50);
                    Values.xObject[i] = (int) (Math.random() * 765 + 10);
                    Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 1);
                }
                else if(Values.timeDifference >= 30000){
                    Values.yObject[i] = (int) (Math.random() * -160 - 50);
                    Values.xObject[i] = (int) (Math.random() * 765 + 10);
                    Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 2);
                }
            }
        }

        // check if an object hits the character.
        for (int i = 0; i < Values.objects; i++) {
            if (Values.yObject[i] <= Values.playerY + 50 && Values.yObject[i] > Values.playerY - 30 &&
                    (Values.xObject[i] <= Values.playerX + 50 && Values.xObject[i] >= Values.playerX - 15))
            {

                // resets the object that hit the character, you lose 1 life, falling speed randomised from 1 to 5 again. first 30secs.
                if(Values.timeDifference < 30000) {
                    Values.yObject[i] = (int) (Math.random() * -160 - 50);
                        Values.xObject[i] = (int) (Math.random() * 765 + 10);
                            Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 1);

                                // if you have a shield up, break the shield first.
                                if(Values.activateShield){
                                    Values.activateShield = false;
                                        break;
                                }
                                // lose a life if you dont have shield.
                                            Values.lives -= 1;
                }

                // resets the object that hit the character, you lose 1 life, falling speed randomised from 2 to 5 again. after 30secs.
                     else if(Values.timeDifference >= 30000){
                         Values.yObject[i] = (int) (Math.random() * -160 - 50);
                            Values.xObject[i] = (int) (Math.random() * 765 + 10);
                                Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 2);

                                // if you have a shield up, break the shield first.
                                if(Values.activateShield){
                                    Values.activateShield = false;
                                        break;
                                }
                                // lose a life if you dont have shield.
                                        Values.lives -= 1;
                    }
            }
        }
    }
}