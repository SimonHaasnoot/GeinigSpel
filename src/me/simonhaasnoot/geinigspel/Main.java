package me.simonhaasnoot.geinigspel;

import me.simonhaasnoot.geinigspel.level.Level1;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.io.File;


public class Main {

    public static void main(String[] args) {

        new Main();

    }

        public Main() {

            Values.level = new Level1();


            JFrame frame = new JFrame("Made by Simon Haasnoot");
            frame.setResizable(false);
            frame.setPreferredSize(new Dimension(800, 600));
            frame.setVisible(true);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            Tekenen tekenen = new Tekenen();
            Acties acties = new Acties();

            frame.addKeyListener(acties);
            frame.add(tekenen);
            frame.add(acties);

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
