package me.simonhaasnoot.geinigspel;

import javax.swing.*;
import java.awt.*;

public class Tekenen extends JPanel {

    private final Image img;
    private final Image img2;
    private final Image img3;
    private final Image img4;
    private final Image img5;
    private final Image img6;
    private final Image img7;

    public Tekenen(){

        // make an actual image object of the images, and rescale them.
        setLayout(null);
        img = Toolkit.getDefaultToolkit().createImage("Images/lucht.jpg");
        img2 = Toolkit.getDefaultToolkit().createImage("Images/poppetje.png");
        img3 = Toolkit.getDefaultToolkit().createImage("Images/grond2.png");
        img4 = Toolkit.getDefaultToolkit().createImage("Images/Fireball.png");

        img5 = Toolkit.getDefaultToolkit().createImage("Images/gameHeart.png");
        img6 = Toolkit.getDefaultToolkit().createImage("Images/gameHeart.png");
        img7 = Toolkit.getDefaultToolkit().createImage("Images/gameHeart.png");
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        // draw the sky
        g.drawImage(img, 10, 10, 765, 475, this);

        // draw game character
        g.drawImage(img2, Values.playerXas, Values.playerYas, Values.playerWidth, Values.playerHeight, this);

        // draw ground where the character is walking on
        g.drawImage(img3, 10, 480, 765, 70, this);

        // draw all the dropping fireballs[objects]
        for(int i = 0; i < 15; i++){
            g.drawImage(img4, Values.xArray[i], Values.yArray[i], 30, 35, this);
        }

        // draw life hearts and
        if(Values.lives >= 3) {
            g.drawImage(img5, 615, 25, 40, 40, this);
        }
        if(Values.lives >=2) {
            g.drawImage(img6, 665, 25, 40, 40, this);
        }
        if(Values.lives >=1) {
            g.drawImage(img7, 715, 25, 40, 40, this);
        }


        // Show time in left corner and make a different font for it.
        Font font = new Font("Serif", Font.BOLD, 40);
        long seconden = Values.difference / 1000;

        if(Values.isPauze) {
            seconden = Values.pauseTime / 1000;
        }

        String verschil = String.valueOf(seconden);
        g.setFont(font);
        g.drawString(verschil, 30, 50);




        //make borders
        g.fillRect(0, 0, 800, 10); //boven
        g.fillRect(0, 0, 10, 560); // links
        g.fillRect(0, 550, 800, 20); // onder
        g.fillRect(770, 0, 20, 780); // rechts


        // call methods, they both get filled once.
        createXarray();
        createYarray();

        // check if objects surpass a certain point
        playerBoundaryCheck();

        // check if object hit the character
        fireballCollisionCheck();

        repaint();

    }

    // run this method once, Array is getting created once. then the game skips this after.
    // this creates all random X's for the Fireball Objects.
    public void createXarray(){

        if(Values.startGame == 1) {
            for (int i = 0; i < 30; i++) {
                Values.xArray[i] = (int) (Math.random() * 765 + 10);
            }
        }

        Values.startGame++;
    }

    // run this method once, Array is getting created once. then the game skips this after.
    // this creates all Y's for the Fireball Objects. (all the same)
    public void createYarray(){

        if(Values.startGame == 2) {
            for (int i = 0; i < 30; i++) {
                Values.yArray[i] = -30;
            }
        }

        Values.startGame++;
    }


// used for checking if player leaves the actual game screen.
    public void playerBoundaryCheck(){

        // als de player verder dan 710px gaat kan hij niet meer verder
        if(Values.playerXas >= 710){
            Values.playerXas = 710;
        }
        // als de player lager gaat dan 10px kan hij niet meer verder
        if(Values.playerXas <= 10){
            Values.playerXas = 10;
        }
    }

    // used for checking if any fireballs collide with the character, or have left the game window.
    public void fireballCollisionCheck() {

        for (int i = 0; i < 30; i++) {
            if (Values.yArray[i] > 610) {
                Values.yArray[i] = (int)(Math.random() * -80 -30);
                Values.xArray[i] = (int) (Math.random() * 765 + 10);
            }
        }

        for (int i = 0; i < 30; i++) {
            if (Values.yArray[i] <= Values.playerYas + 50 && Values.yArray[i] > Values.playerYas - 30 &&
                    (Values.xArray[i] <= Values.playerXas + 50 && Values.xArray[i] >= Values.playerXas - 15)) {

                Values.yArray[i] =(int)(Math.random() * -80 -30);
                Values.xArray[i] = (int) (Math.random() * 765 + 10);
                Values.lives = Values.lives - 1;
            }
        }
    }
}
