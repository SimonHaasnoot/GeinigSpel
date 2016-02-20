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
     * Flush/reset all the input states.
     */
    public static void flushInputs() {
        // Flush the pressed keys
        pressedKeys.clear();
    }
}
