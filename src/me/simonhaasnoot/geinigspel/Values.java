package me.simonhaasnoot.geinigspel;

import me.simonhaasnoot.geinigspel.level.BaseLevel;

public class Values {

    public static BaseLevel level;

    // the X and Y of the Player(character)
    public static int       playerX =                   360,
                            playerY =                   410;

    // player Left and Right button press boolean
    public static boolean   playerXleft =               false,
                            PlayerXright =              false;

    // Player Height and Width
    public static int       playerWidth =               70,
                            playerHeight =              80;

    // Timer delay in MS
    public static int       Delay =                     10;

    // speed of the objects and the player; define lives
    public static int       ObjectFallSpeed =           2,
                            ObjectFallSpeed2 =          3,
                            playerSpeed =               5,
                            lives =                     3;

    // create value that defines array size
    public static int objects =                         50;

    // create 2 arrays, containing x and y of all objects.
    public static int []    xObject = new int[objects],
                            yObject = new int[objects];

    // lets the game create the X and Y array once; lets the game start the timeDifference timer ONCE; create pauzeCounter
    public static int       startGame =                 1,
                            uitLoop =                    0,
                            pauzeCount =                1;

    // calculates the time your playing the game; calculate time while pausing
    public static long      timeDifference =            0,
                            pauseTime =                 0;

    // create pause boolean
    public static boolean isPauze =                     false;
}

