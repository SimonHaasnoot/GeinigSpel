package me.simonhaasnoot.geinigspel.game.util;


import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PauseMenu {


    private String [] menuOptions = {"Resume", "Options", "Save", "Exit"};

    private int currentChoice = 0;

    public void paint(Graphics2D g){

        for (int i = 0; i < menuOptions.length; i++) {

            if(currentChoice == i){
                g.setColor(new Color(255, 100, 255));
            }
            else
                g.setColor(Color.black);

            g.drawString(menuOptions[i], GameManager.getGameFrame().getWidth()/3, GameManager.getGameFrame().getHeight()/3 + (i * 50));

        }

        System.out.println(currentChoice);

    }

    public void registerKeys(){

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
    }

}
