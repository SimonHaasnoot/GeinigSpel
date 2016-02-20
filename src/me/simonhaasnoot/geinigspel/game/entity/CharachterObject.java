package me.simonhaasnoot.geinigspel.game.entity;

import me.simonhaasnoot.geinigspel.Entiteiten.Character;
import me.simonhaasnoot.geinigspel.game.GameManager;

import java.awt.*;

public class CharachterObject extends ImageObject {

    /**
     * The width of the character.
     */
    public static final int SIZE_WIDTH = 70;

    /**
     * The height of the character.
     */
    public static final int SIZE_HEIGHT = 90;


    /**
     * The X of the character.
     */

    public static double SPEED_NORMAL = 200;

    /**
     * The Y of the character.
     */

    public static double SPEED_HIGH = 50;

    /**
     * character image.
     */
    public static Image characterImg;
    /**
     *
     * @param x set x position for Character.
     * @param y set y position for Character.
     */
    public CharachterObject(double x, double y) {
        this(x, y, SIZE_WIDTH, SIZE_HEIGHT, loadCharacterImage());

    }


    public CharachterObject(double x, double y, double width, double height, Image img) {
        super(x, y, width, height, img);


        //FIXME just a test speed, replace with actual memes.
        setSpeedX(SPEED_NORMAL);

    }

    /**
     * Load Character image.
     * @return character image.
     */

    public synchronized static Image loadCharacterImage() {
        // Return the fireball image if it's already loaded
        if(characterImg != null)
            return characterImg;

        // TODO: Move image path into a constant!
        characterImg = Toolkit.getDefaultToolkit().createImage("Images/Characters/Wizard.png");
        return characterImg;
    }


}
