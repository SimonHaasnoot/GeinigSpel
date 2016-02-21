package me.simonhaasnoot.geinigspel.game.input.key;

import me.simonhaasnoot.geinigspel.game.input.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // Process the event in the input manager
        Input.processKeyEvent(e.getKeyCode(), KeyEventType.TYPED);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Process the event in the input manager
        Input.processKeyEvent(e.getKeyCode(), KeyEventType.PRESSED);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Process the event in the input manager
        Input.processKeyEvent(e.getKeyCode(), KeyEventType.RELEASED);
    }
}
