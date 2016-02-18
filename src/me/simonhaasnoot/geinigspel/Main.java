package me.simonhaasnoot.geinigspel;
import me.simonhaasnoot.geinigspel.level.Level1;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import javax.swing.*;

import java.awt.*;
import java.io.File;


public class Main{


    public static void main(String[] args) {

        new Main();
    }

        public Main() {

            JFrame frame = new JFrame();
            frame.setTitle("Made by Simon Haasnoot");
            frame.setResizable(false);
            frame.setPreferredSize(new Dimension(Values.frameX, Values.frameY));
            frame.setVisible(true);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            initiateGame(frame);

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

    public  void initiateGame(JFrame frame){

            frame.setTitle("Made by Simon Haasnoot");
            frame.setResizable(false);
            frame.setPreferredSize(new Dimension(Values.frameX, Values.frameY));
            frame.setVisible(true);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            createXarray();
            createYarray();
            fallingSpeed();
            createThunderRandoms();

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

    public void createXarray(){

            for (int i = 0; i < Values.objects; i++) {
                Values.xObject[i] = (int) (Math.random() * 1028 - 30 + 1);
            }
        }
    public void createYarray(){

            for (int i = 0; i < Values.objects; i++) {
                Values.yObject[i] = -50;
            }
        }
    public void fallingSpeed() {
        for (int i = 0; i < Values.objects; i++) {
            Values.fallingSpeed[i] = (int) (Math.random() * Values.maxRandom + 1);
        }
    }
    public void createThunderRandoms(){

        int R1 = 20000;
        int R2 = 10000;
            for (int i = 0; i < Values.objects; i++) {
                Values.thunderRandomTime[i] = (int)(Math.random() * R1) + R2;
                R1 = (int)((R1 + 30000)*0.90);
                int R3 = (int) (R1 * 0.9);
                R2 = R2 + R3;
                System.out.println(Values.thunderRandomTime[i]);
            }
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
