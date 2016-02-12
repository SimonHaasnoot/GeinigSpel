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
        g.drawImage(img, 0, 0, 800, 500, this);

        // draw game character
        g.drawImage(img2, Values.playerX, Values.playerY, Values.playerWidth, Values.playerHeight, this);

        // draw ground where the character is walking on
        g.drawImage(img3, 0, 480, 800, 100, this);

        // draw all the dropping fireballs[objects]
        for(int i = 0; i < Values.objects; i++){
            g.drawImage(img4, Values.xObject[i], Values.yObject[i], 30, 35, this);
        }

        // draw life hearts and
        if(Values.lives >= 3) {
            g.drawImage(img5, 635, 20, 40, 40, this);
        }
        if(Values.lives >=2) {
            g.drawImage(img6, 685, 20, 40, 40, this);
        }
        if(Values.lives >=1) {
            g.drawImage(img7, 735, 20, 40, 40, this);
        }


        // Show time in left corner and make a different font for it.
        Font font = new Font("Serif", Font.BOLD, 40);
        long seconden = Values.timeDifference / 1000;

        // keep pause time steady during the actual pause time.
        if(Values.isPauze) {
            seconden = Values.pauseTime / 1000;
        }

        String verschil = String.valueOf(seconden);
        g.setFont(font);
        g.drawString(verschil, 30, 50);

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
            for (int i = 0; i < Values.objects; i++) {
                Values.xObject[i] = (int) (Math.random() * 770 + 1);
            }
        }

        Values.startGame++;
    }

    // run this method once, Array is getting created once. then the game skips this after.
    // this creates all Y's for the Fireball Objects. (all the same)
    public void createYarray(){

        if(Values.startGame == 2) {
            for (int i = 0; i < Values.objects; i++) {
                Values.yObject[i] = -50;
            }
        }

        Values.startGame++;
    }


// used for checking if player leaves the actual game screen.
    public void playerBoundaryCheck(){

        // als de player verder dan 710px gaat kan hij niet meer verder
        if(Values.playerX >= 730){
            Values.playerX = 730;
        }
        // als de player lager gaat dan 10px kan hij niet meer verder
        if(Values.playerX <= 0){
            Values.playerX = 0;
        }
    }

    // used for checking if any fireballs collide with the character, or have left the game window.
    public void fireballCollisionCheck() {


        for (int i = 0; i < Values.objects; i++) {
            if (Values.yObject[i] > 610) {
                Values.yObject[i] = (int)(Math.random() * -80 -30);
                Values.xObject[i] = (int) (Math.random() * 765 + 10);
            }
        }

        for (int i = 0; i < Values.objects; i++) {
            if (Values.yObject[i] <= Values.playerY + 50 && Values.yObject[i] > Values.playerY - 30 &&
                    (Values.xObject[i] <= Values.playerX + 50 && Values.xObject[i] >= Values.playerX - 15)) {

                Values.yObject[i] =(int)(Math.random() * -80 -30);
                Values.xObject[i] = (int) (Math.random() * 765 + 10);
                Values.lives = Values.lives - 1;
            }
        }
    }
}
