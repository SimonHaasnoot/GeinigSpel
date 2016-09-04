package me.simonhaasnoot.geinigspel.game.level;

import me.simonhaasnoot.geinigspel.game.GameManager;
import me.simonhaasnoot.geinigspel.game.GameStateManager;
import me.simonhaasnoot.geinigspel.game.entity.CharacterObject;
import me.simonhaasnoot.geinigspel.game.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SelectMenu extends BaseLevel {

    private int currentChoice = 0;

    private String [] menuOptions = {"Level 1", "Level 2", "Level 3", "Level 4"} ;

    @Override
    public void start(GameStateManager gsm) {

        gsm.setBackgroundImage(Toolkit.getDefaultToolkit().createImage("Images/Landscape/1028x768B.png"));

    }

    public void select() {

        if(currentChoice == 0)
            GameManager.getGameStateManager().loadLevel(new Level1());

        if(currentChoice == 1)
            GameManager.getGameStateManager().loadLevel(new Level2());

        if(currentChoice == 0)
            GameManager.getGameStateManager().loadLevel(new Level1());

        if(currentChoice == 0)
            GameManager.getGameStateManager().loadLevel(new Level1());

    }


        @Override
    public void update(GameStateManager gsm) {

    }

    @Override
    public CharacterObject getCharacter() {
        return null;
    }

    @Override
    public void registerKeys(GameStateManager gsm) {

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
        if(Input.isPressedOnce(KeyEvent.VK_ENTER) || Input.isPressedOnce(KeyEvent.VK_SPACE))
            select();
    }

    @Override
    public void paint(Graphics2D g) {

        g.setFont(new Font("Century Gothic", Font.PLAIN, GameManager.getGameFrame().getWidth()/15));

        for (int i = 0; i < menuOptions.length; i++) {
            if(currentChoice == i){
                g.setColor(new Color(134,209,132));
            } else
                g.setColor(Color.black);

            g.drawString(menuOptions[i], (int)(GameManager.getGameFrame().getWidth()/4) + (int)(GameManager.getGameFrame().getWidth()/10.28),
                    GameManager.getGameFrame().getHeight()/4 + (i * (int)(GameManager.getGameFrame().getHeight()/10)));

        }
    }
}
