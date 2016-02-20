package me.simonhaasnoot.geinigspel.game.util;

public class FrameTime {

    /**
     * The time in seconds the frame started rendering.
     */
    public static double time = 0;

    /**
     * The time in nanoseconds the frame started rendering.
     */
    public static long timeNano = 0;

    /**
     * The time between the last frame and this frame in seconds.
     */
    public static double deltaTime = 0;

    /**
     * The time between the last frame and this frame in nanoseconds.
     */
    public static long deltaTimeNano = 0;

    private static boolean isFirst = true;

    /**
     * Update the frame times.
     *
     * @param t The timer.
     */
    public static void updateFrameTime(Timer t) {
        // Move the time and nano time to the last time
        double lastTime = time;
        long lastTimeNano = timeNano;

        // Store the current times
        time = t.getElapsedTime();
        timeNano = t.getElapsedNano();

        // Calculate the delta times
        if(!isFirst) {
            deltaTime = time - lastTime;
            deltaTimeNano = timeNano - lastTimeNano;

        } else {
            deltaTime = 0;
            deltaTimeNano = 0;
            isFirst = false;
        }
    }
}
