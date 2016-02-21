package me.simonhaasnoot.geinigspel.game.input;

import me.simonhaasnoot.geinigspel.game.input.key.KeyEventType;

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
        flush();
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
     * Process a key event type, such as a key press or release.
     *
     * @param keyCode The key code to check for, see constants in KeyEvent class.
     * @param eventType The type of event.
     */
    public static void processKeyEvent(int keyCode, KeyEventType eventType) {
        // Process the key
        switch(eventType) {
            case PRESSED:
                // Add the key to the list if it isn't in the list already
                if(!pressedKeys.contains(keyCode))
                    pressedKeys.add(keyCode);
                break;

            case RELEASED:
                // Remove the key from the list if it's currently in the list
                pressedKeys.remove((Integer) keyCode);
                break;

            default:
        }
    }

    /**
     * Flush/reset all the input states.
     */
    public static void flush() {
        // Flush the pressed keys
        pressedKeys.clear();
    }
}
