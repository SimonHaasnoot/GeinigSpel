package me.simonhaasnoot.geinigspel;
import javax.swing.*;
import java.awt.*;


public class Tekenen extends JPanel {

    private final Image img = Toolkit.getDefaultToolkit().createImage("Images/Landscape/AirB.jpg");
    private final Image img2 = Toolkit.getDefaultToolkit().createImage("Images/Characters/Wizard.png");
    private final Image img3 = Toolkit.getDefaultToolkit().createImage("Images/Landscape/GrassGround.png");
    private final Image img4 = Toolkit.getDefaultToolkit().createImage("Images/Objects/FIREBALL.gif");
    private final Image img5 = Toolkit.getDefaultToolkit().createImage("Images/Objects/gameHeart.png");
    private final Image img6 = Toolkit.getDefaultToolkit().createImage("Images/Landscape/Tree01.png");
    private final Image img7 = Toolkit.getDefaultToolkit().createImage("Images/Objects/Shield03.png");
    private final Image img8 = Toolkit.getDefaultToolkit().createImage("Images/Objects/bal.png");

    public Tekenen(){

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        // draw the sky
        g.drawImage(img, 0, 0, 800, 500, this);

        // draw trees
        g.drawImage(img6, 0, 195, 150, 300, this);
        g.drawImage(img6, 300, 195, 150, 300, this);

        // draw game character
        g.drawImage(img2, Values.playerX, Values.playerY, Values.playerWidth, Values.playerHeight, this);

        // draw ground where the character is walking on
        g.drawImage(img3, 0, 480, 800, 100, this);



        // draw all the [objects]
        for(int i = 0; i < Values.objects; i++){
            g.drawImage(img4, Values.xObject[i], Values.yObject[i], 30, 35, this);
        }

        // draw life hearts
        if(Values.lives >= 3) {
            g.drawImage(img5, 635, 20, 40, 40, this);
        }
        if(Values.lives >=2) {
            g.drawImage(img5, 685, 20, 40, 40, this);
        }
        if(Values.lives >=1) {
            g.drawImage(img5, 735, 20, 40, 40, this);
        }

        //draw shield drop
        if(Values.dropShield) {
            g.drawImage(img8, Values.RandomX, 450, 30, 30, this);
        }

        //draw shield
        if(Values.shieldActive){
            Values.dropShield = false;
            g.drawImage(img7, 580, 20, 35, 40, this);
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

    // runs this method once, fallingSpeed array is getting created once. then the game skips this after.
    // this creates all Fallspeeds from 1 to 5;
    public void fallingSpeed(){
        if(Values.startGame == 3){
            for (int i = 0; i < Values.objects; i++) {
                Values.fallingSpeed[i] = (int)(Math.random() * Values.maxRandom + 1);

            }
            Values.startGame++;
        }
    }
}
