package me.simonhaasnoot.geinigspel;

import me.simonhaasnoot.geinigspel.level.BaseLevel;

public class Values {

    public static BaseLevel level;

    // the X and Y of the Player(character)
    public static int playerXas =                       360;
    public static int playerYas =                       410;

    // player Left and Right button press boolean
    public static boolean playerXleft =                 false;
    public static boolean PlayerXright =                false;

    // Speed of the Player, Height and Width
    public static int playerWidth =                     70;
    public static int playerHeight =                    80;

    public static int playerSpeed =                     5;

    // Timer delay in MS
    public static int Delay =                           10;

    // speed of the fireballs
    public static int fireballValsnelheid =             2;
    public static int fireballValsnelheid2 =            3;

    // lives u have
    public static int lives =                           3;

    // create fireball object arrays
    public static int [] xArray = new int[30];
    public static int [] yArray = new int[30];

    // lets the game create the X and Y array once
    public static int startGame =                       1;

    // lets the game start the difference timer ONCE
    public static int uitLoop =                         0;

    // calculates the time your playing the game
    public static long difference =                     0;
    public static long pauseTime =                      0;

    public static boolean isPauze =                     false;
    public static int pauzeCount =                      1;

}

