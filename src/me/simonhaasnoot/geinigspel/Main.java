package me.simonhaasnoot.geinigspel;

import me.simonhaasnoot.geinigspel.level.Level1;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import javax.swing.*;

import java.awt.*;
import java.io.File;


public class Main{


    public JFrame SelectFrame = new JFrame("Made by Simon Haasnoot");
    public  static JFrame GameFrame = new JFrame("Made by Simon Haasnoot");

    public static void main(String[] args) {

        new Main();
    }

        public Main() {


            SelectFrame.setTitle("Made by Simon Haasnoot");
            SelectFrame.setResizable(false);
            SelectFrame.setPreferredSize(new Dimension(Values.frameX, Values.frameY));
            SelectFrame.setVisible(true);
            SelectFrame.pack();
            SelectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SelectFrame.setLocationRelativeTo(null);

            initiateGame(SelectFrame);
        }

//        public void startScreen(JFrame frame){
//
//            JPanel panel = new JPanel();
//            panel.setLayout(new BorderLayout());
//
//            JLabel background = new JLabel();
//            background.setIcon(new ImageIcon("Images/Landscape/1028x768B.png"));
//
//            JButton start = new JButton("Start");
//            start.setBounds(frame.getWidth()/2 - 85, 150, 170, 80);
//
//            start.addActionListener(e -> {
//                if(e.getSource() == start){
//                   initiateGame();
//                    SelectFrame.setVisible(false);
//                }});
//
//            background.add(start);
//            panel.add(background);
//            frame.add(panel);
//
//            frame.validate();
//        }

        public static void initiateGame(JFrame frame){

            frame.setTitle("Made by Simon Haasnoot");
            frame.setResizable(false);
            frame.setPreferredSize(new Dimension(Values.frameX, Values.frameY));
            frame.setVisible(true);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            Values.level = new Level1();

            Tekenen tekenen = new Tekenen();
            Acties acties = new Acties();

            frame.addKeyListener(acties);
            frame.add(tekenen);
            frame.add(acties);

            Timer timer = new Timer(Values.Delay, acties);
            timer.start();
            play();

        }



         public static void play() {
        try {
            File file = new File("Songs/sound22.wav");
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
