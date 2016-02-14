package me.simonhaasnoot.geinigspel;

import me.simonhaasnoot.geinigspel.level.Level1;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.io.File;


public class Main extends JFrame {

 //   public static JButton startKnop = new JButton("Start");

    public static void main(String[] args) {

        new Main();

    }

        public Main() {

            this.setTitle("Made by Simon Haasnoot");
            this.setResizable(false);
            this.setPreferredSize(new Dimension(Values.frameX, Values.frameY));
            this.setVisible(true);
            this.pack();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            initiateGame(this);
        }

//        public void startScreen(JFrame frame){
//
//            JLabel jl = new JLabel();
//
//            jl.setIcon(new ImageIcon("Images/800x600.jpg"));
//
//            startKnop.setBounds(Values.frameX/2 - 50, Values.frameY/2 - 150, 120, 60);
//
//
//            jl.add(startKnop);
//            this.add(jl);
//            validate();
//
//            startKnop.addActionListener(e -> {
//                if(e.getSource() == Main.startKnop){
//                    getContentPane().removeAll();
//                    getContentPane().repaint();
//
//                }});
//        }

        public void initiateGame(JFrame frame){

            Values.level = new Level1();

            Tekenen tekenen = new Tekenen();
            Acties acties = new Acties();

            this.addKeyListener(acties);
            this.add(tekenen);
            this.add(acties);

            Timer timer = new Timer(Values.Delay, acties);
            timer.start();
            play();

        }

         public void play() {
        try {
            File file = new File("Songs/sound2.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
            clip.start();
            Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
