package me.simonhaasnoot.geinigspel;

import me.simonhaasnoot.geinigspel.game.level.BaseLevel;

public class Values {

    public static BaseLevel level;


    // X and Y of the actual Frame
    public static int       frameX = 1024,
                            frameY = 768;

    // the X and Y of the Player(character)
    public static int       playerX =                   frameX/2 - 50,
                            playerY =                   frameY - 188;

    // player Left and Right button press boolean
    public static boolean   playerXleft =               false,
                            PlayerXright =              false,
                            deadChar =                  false;

    // Player Height and Width
    public static int       playerWidth =               70,
                            playerHeight =              80;

    // Timer delay in MS
    public static int       Delay =                     10;

    // speed of the objects and the player; define lives
    public static int playerSpeed =                     5,
                        maxRandom =                     3,
                            lives =                     3;

    // create value that defines array size
    public static int objects =                         50;

    // create 2 arrays, containing x and y of all objects.
    public static int []    xObject = new int[objects],
                            yObject = new int[objects],
                            fallingSpeed = new int[objects],
                            thunderRandomTime = new int[objects];

    // lets the game create the X and Y array once; lets the game start the timeDifference timer ONCE; create pauzeCounter
    public static int       startGame =                 1,
                            uitLoop =                   0,
                            uitLoop2 =                  0,
                            pauzeCount =                1;

    // calculates the time your playing the game; calculate time while pausing
    public static long      timeDifference =            0,
                            timeDifferenceThunder =     0,
                            pauseTime =                 0;

    // create pause boolean
    public static boolean   isPauze =                    false;

    // drops
    public static boolean   spawnShield =                  false,
                            activateShield =               false,
                            spawnThunder =                 false,
                            thunderCollide =               false;

    // shieldDropSpawntime X for Shield drop
    public static int randomXshieldSpawn = (int)(Math.random()* frameX - 50 + 1);
    public static int randomXthunderSpawn = (int)(Math.random()*frameX - 214 + 150);

    // make a clone array for the speeds, for if you pause.
    public static int [] cloneArray;


    public static int       meteoriteX =                    1050;
    public static int       meteoriteY =                    -300;

    public static boolean   spawnMeteoriteWarning =         false;
    public static boolean   spawnMeteorite =                false;

}
