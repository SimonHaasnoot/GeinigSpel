package me.simonhaasnoot.geinigspel;

import javax.swing.*;
import java.awt.*;


public class Tekenen extends JPanel {

    private final Image img2 = Toolkit.getDefaultToolkit().createImage("Images/Characters/Wizard.png");

    private final Image img4 = Toolkit.getDefaultToolkit().createImage("Images/Objects/Gifs/FIREBALL.gif");

    private final Image img5 = Toolkit.getDefaultToolkit().createImage("Images/Objects/gameHeart.png");
    private final Image img7 = Toolkit.getDefaultToolkit().createImage("Images/Objects/Shield04.png");
    private final Image img8 = Toolkit.getDefaultToolkit().createImage("Images/Objects/Shield01.png");

    private final Image img = Toolkit.getDefaultToolkit().createImage("Images/Landscape/AirB.jpg");
    private final Image img3 = Toolkit.getDefaultToolkit().createImage("Images/Landscape/GrassGround2.png");
    private final Image img6 = Toolkit.getDefaultToolkit().createImage("Images/Landscape/Tree01.png");
    private final Image img9 = Toolkit.getDefaultToolkit().createImage("Images/Landscape/Volcano2.png");
    private final Image img10 = Toolkit.getDefaultToolkit().createImage("Images/Landscape/Cloud01.png");
    private final Image img12 = Toolkit.getDefaultToolkit().createImage("Images/Landscape/flower01.png");

    private final Image img11 = Toolkit.getDefaultToolkit().createImage("Images/Objects/Gifs/Thunder25.gif");
    private final Image img13 = Toolkit.getDefaultToolkit().createImage("Images/Objects/Meteorite02.png");

    private long currentTime = 0;

    public Tekenen(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        // draw the sky
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        // draw the volcano
        g.drawImage(img9, 350, 360, getWidth()/2 + 200, 300, this);


        // draw trees
        g.drawImage(img6, 0, 360, 150, 300, this);
        g.drawImage(img6, 300, 340, 150, 325, this);

        // draw game character
        g.drawImage(img2, Values.playerX, Values.playerY, Values.playerWidth, Values.playerHeight, this);

        // draw ground where the character is walking on
        g.drawImage(img3, 0, Values.frameY - 120, getWidth(), 100, this);

        // draw all the [objects]
        for(int i = 0; i < Values.objects; i++){
            g.drawImage(img4, Values.xObject[i], Values.yObject[i], 30, 35, this);
        }

        // draw flowers
        g.drawImage(img12, 150, 618, 30, 40, this);
        g.drawImage(img12, 250, 615, 30, 40, this);

        // draw cloud + thunder +  use counter
        if(Values.spawnThunder) {

            long startTime = System.currentTimeMillis();

            if(Values.uitLoop2 == 0){
                currentTime = startTime;
                Values.uitLoop2++;

            }
            Values.timeDifferenceThunder =  startTime - currentTime;
            g.drawImage(img10, Values.randomXthunderSpawn, 180, 200, 160, this);

            if(Values.timeDifferenceThunder > 1500 && Values.timeDifferenceThunder < 2400){
                g.drawImage(img11, Values.randomXthunderSpawn + 50, 250, 100, 415, this);
            }
                if(Values.timeDifferenceThunder > 2500){
                    Values.spawnThunder = false;
                    Values.uitLoop2 = 0;
                }
        }

        // draw meteorite
        g.drawImage(img13, Values.meteoriteX, Values.meteoriteY, 300, 300, this);

        // draw life hearts
        if(Values.lives >= 3) {
            g.drawImage(img5, getWidth() - 165, 20, 40, 40, this);
        }
        if(Values.lives >=2) {
            g.drawImage(img5, getWidth() - 115, 20, 40, 40, this);
        }
        if(Values.lives >=1) {
            g.drawImage(img5, getWidth() - 65, 20, 40, 40, this);
        }

        //draw shield drop
        if(Values.spawnShield) {
            g.drawImage(img8, Values.randomXshieldSpawn, getHeight() - 126, 44, 48, this);
        }

        //draw shield

        if(Values.activateShield){
            Values.spawnShield = false;
            g.drawImage(img7, getWidth() - 65, 70, 35, 40, this);
        }

        // Show time in left corner and make a different font for it.
        Font font = new Font("Serif", Font.BOLD, 40);
        Font font2= new Font("Times New Roman", Font.PLAIN, 72);
        long seconden = Values.timeDifference / 1000;

        // keep pause time steady during the actual pause time.
        if(Values.isPauze) {
            seconden = Values.pauseTime / 1000;
            g.setFont(font2);
            g.drawRect(Values.frameX/2 - 100, Values.frameY/2 - 100, 190, 80);
            g.drawString("Pause", Values.frameX /2 - 90, Values.frameY/2 - 40);
        }

        String verschil = String.valueOf(seconden);
        g.setFont(font);
        g.drawString(verschil, 30, 50);

        // call methods, they both get filled once.


        createXarray();
        createYarray();
        fallingSpeed();
        createThunderRandoms();

        repaint();

    }


    // run this method once, Array is getting created once. then the game skips this after.
    public void createXarray(){

        if(Values.startGame == 1) {
            for (int i = 0; i < Values.objects; i++) {
                Values.xObject[i] = (int) (Math.random() * getWidth() - 30 + 1);
            }
        }

        Values.startGame++;
    }

    // this creates all Y's for the Fireball Objects. (all the same)
    public void createYarray(){

        if(Values.startGame == 2) {
            for (int i = 0; i < Values.objects; i++) {
                Values.yObject[i] = -50;
            }
        }
        Values.startGame++;
    }

    // this creates all Fallspeeds from 1 to 5;
    public void fallingSpeed(){
        if(Values.startGame == 3){
            for (int i = 0; i < Values.objects; i++) {
                Values.fallingSpeed[i] = (int)(Math.random() * Values.maxRandom + 1);

            }
            Values.startGame++;
        }
    }

    public void createThunderRandoms(){

        int R1 = 20000;
        int R2 = 10000;
        if(Values.startGame == 4){
            for (int i = 0; i < Values.objects; i++) {
                Values.thunderRandomTime[i] = (int)(Math.random() * R1) + R2;
                R1 = (int)((R1 + 30000)*0.90);
                int R3 = (int) (R1 * 0.9);
                R2 = R2 + R3;
               System.out.println(Values.thunderRandomTime[i]);
            }
        }
    }
}
