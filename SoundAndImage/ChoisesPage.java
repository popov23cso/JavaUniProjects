import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.io.*;




public class ChoisesPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton dogbtn = new JButton("Dawg");
    JButton catbtn = new JButton("Kitty");
    JButton stopbtn = new JButton("STOP");
    ImageIcon image = new ImageIcon("static/doggy.jpg");
    JLabel showdog = new JLabel(image);
    URL file;
    AudioInputStream ais;
    Clip clip;
    

    ChoisesPage() {
        dogbtn.setBounds(0, 200, 100, 25);
        dogbtn.setFocusable(false);
        dogbtn.addActionListener(this);

        catbtn.setBounds(310, 200, 100, 25);
        catbtn.setFocusable(false);
        catbtn.addActionListener(this);

        stopbtn.setBounds(0, 0, 100, 25);
        stopbtn.setFocusable(false);
        stopbtn.addActionListener(this);

        showdog.setBounds(60, 10, 200, 200);

        frame.add(dogbtn);
        frame.add(catbtn);
        frame.add(stopbtn);
        frame.add(showdog);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dogbtn){
            if (clip != null) {
                clip.stop();
            }
            try{
                changeSound("doggy");
                image = new ImageIcon("static/doggy.jpg");
                showdog.setIcon(image);
            }
            catch(Exception w) {
                return;
            }
            clip.setFramePosition(0);
            clip.start();
        }
        else if(e.getSource() == catbtn) {
            if (clip != null) {
                clip.stop();
            }
            try{
                changeSound("kitty");
                image = new ImageIcon("static/cat.jpg");
                showdog.setIcon(image);
            }
            catch(Exception w) {
                return;
                }
            clip.setFramePosition(0);
            clip.start();
        }
        else if (e.getSource() == stopbtn) {
            if (clip != null) {
                clip.stop();
            }
            else {
                return;
            }
        }
    }


    private void changeSound(String mode) throws Exception {
        file = new URL("file:static/" + mode + ".wav");
        ais = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(ais);
    }
}
