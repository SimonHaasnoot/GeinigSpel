package me.simonhaasnoot.geinigspel.game.input;

import me.simonhaasnoot.geinigspel.game.input.key.KeyEventType;

import java.util.ArrayList;
import java.util.List;

public class Input {

    /**
     * List of keys that is currently pressed.
     */
    public static List<Integer> pressedKeys = new ArrayList<>();

    /**
     * List of keys that has been pressed once, but not consumed yet.
     * As soon as {@see isPressedOnce()} is called, the given key is removed from this list.
     */
    public static List<Integer> pressedOnceKeys = new ArrayList<>();

    /**
     * Check whether a key is currently pressed.
     *
     * @param keyCode Code of the key.
     *
     * @return True if pressed, false if not.
     */
    public static boolean isPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    /**
     * Check whether a key is pressed once.
     * Calling this method will consume the 'pressed once' state for the given key.
     * The state of the key will be reset when the key is released, and is then pressed again.
     *
     * @param keyCode Code of the key.
     *
     * @return True if pressed, false if not.
     */
    public static boolean isPressedOnce(int keyCode) {
        // If the given key is in the list, the remove statement below will return true, false otherwise
        return pressedOnceKeys.remove((Integer) keyCode);
    }

    /**
     * Process a key event.
     * Key events from AWT/Swing can be routed to this method.
     *
     * @param keyCode Code of the key that was pressed.
     * @param eventType Key press event.
     */
    public static void processKeyEvent(int keyCode, KeyEventType eventType) {
        // Process the key
        switch(eventType) {
            case PRESSED:
                // Add the key to the list if it isn't in the list already
                if(!pressedKeys.contains(keyCode)) {
                    pressedKeys.add(keyCode);
                    pressedOnceKeys.add(keyCode);
                    break;
                }

            case RELEASED:
                // Remove the key from the list if it's currently in the list
                pressedKeys.remove((Integer) keyCode);
                pressedOnceKeys.remove((Integer) keyCode);
                break;

            default:
        }
    }

    /**
     * Flush all registered keys.
     * This will reset the state of each tracked key, until it's pressed again.
     */
    @SuppressWarnings("unused")
    public static void flush() {
        pressedKeys.clear();
        pressedOnceKeys.clear();
    }
}
