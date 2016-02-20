package me.simonhaasnoot.geinigspel.legacy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Simon on 2/20/2016.
 */
public class KeyImputs implements KeyListener {

    public boolean moveLeft = false;
    public boolean moveRight = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
            moveLeft = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            moveRight = true;
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
            moveLeft = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            moveLeft = false;
        }
    }
}
