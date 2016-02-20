package me.simonhaasnoot.geinigspel.game.input;

import java.util.ArrayList;
import java.util.List;

public class Input {

    /**
     * The list of keys that is currently pressed.
     */
    public static List<Integer> pressedKeys = new ArrayList<>();

    /**
     * Initialize.
     */
    public static void init() {
        // Flush all inputs
        flushInputs();
    }

    /**
     * Check whether a key is currently pressed.
     *
     * @param keyCode The key code to check for, see constants in KeyEvent class.
     *
     * @return True if the key is pressed, false if not.
     */
    public static boolean isPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    /**
     * Flush/reset all the input states.
     */
    public static void flushInputs() {
        // Flush the pressed keys
        pressedKeys.clear();
    }
}
