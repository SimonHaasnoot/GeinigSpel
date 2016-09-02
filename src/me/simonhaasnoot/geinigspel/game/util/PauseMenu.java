package me.simonhaasnoot.geinigspel.game.util;


import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PauseMenu {


    private String [] menuOptions = {"Resume", "Options", "Save", "Exit"};

    private Image image = Toolkit.getDefaultToolkit().createImage("Images/Portraits/woodBg.png");

    private int currentChoice = 0;

    public void paint(Graphics2D g){

        g.drawImage(image, GameManager.getGameFrame().getWidth()/3 - 30, GameManager.getGameFrame().getHeight()/5,
                (int)(GameManager.getGameFrame().getWidth()/2.446), (int)(GameManager.getGameFrame().getHeight()/2.4) , null);

        g.setFont(new Font("Calibri", Font.PLAIN, GameManager.getGameFrame().getWidth()/20));
        for (int i = 0; i < menuOptions.length; i++) {

            if(currentChoice == i){
                g.setColor(new Color(134,209,132));
            }
            else
                g.setColor(Color.black);

            g.drawString(menuOptions[i], GameManager.getGameFrame().getWidth()/3 + (int)(GameManager.getGameFrame().getWidth()/10.28),
                    GameManager.getGameFrame().getHeight()/3 + (i * (int)(GameManager.getGameFrame().getHeight()/15.36)));

        }
    }

    public void select(){

        if(currentChoice == 0)
            GameManager.getGameStateManager().pauseGame();

        //TODO choice
        if(currentChoice == 1);

        //TODO choice
        if(currentChoice == 2);

        //TODO choice
        if(currentChoice == 3)
            System.exit(0);
    }

    public void registerKeys(){

        // navigate through pause menu
        if((Input.isPressedOnce(KeyEvent.VK_S) || Input.isPressedOnce(KeyEvent.VK_DOWN)))
                if(currentChoice < menuOptions.length - 1)
                    currentChoice++;
                else
                    currentChoice = 0;


        if((Input.isPressedOnce(KeyEvent.VK_W) || Input.isPressedOnce(KeyEvent.VK_UP)))
            if(currentChoice == 0)
            currentChoice = menuOptions.length - 1;
        else
            currentChoice--;

        // select the user's choice
        if(Input.isPressedOnce(KeyEvent.VK_ENTER))
            select();
    }

}
