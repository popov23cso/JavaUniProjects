import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;




public class ChoisesPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton dogBtn = new JButton("Dawg");
    JButton catBtn = new JButton("Kitty");
    JButton stopBtn = new JButton("STOP");
    ImageIcon image = new ImageIcon("static/doggy.jpg");
    JLabel picture = new JLabel(image);
    URL file;
    AudioInputStream ais;
    Clip clip;
    

    ChoisesPage() {
        dogBtn.setBounds(0, 200, 100, 25);
        dogBtn.setFocusable(false);
        dogBtn.addActionListener(this);

        catBtn.setBounds(310, 200, 100, 25);
        catBtn.setFocusable(false);
        catBtn.addActionListener(this);

        stopBtn.setBounds(0, 0, 100, 25);
        stopBtn.setFocusable(false);
        stopBtn.addActionListener(this);

        picture.setBounds(60, 10, 200, 200);

        frame.add(dogBtn);
        frame.add(catBtn);
        frame.add(stopBtn);
        frame.add(picture);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dogBtn){
            if (clip != null) {
                clip.stop();
            }
            try{
                changeSound("doggy");
                image = new ImageIcon("static/doggy.jpg");
                picture.setIcon(image);
            }
            catch(Exception w) {
                return;
            }
            clip.setFramePosition(0);
            clip.start();
        }
        else if(e.getSource() == catBtn) {
            if (clip != null) {
                clip.stop();
            }
            try{
                changeSound("kitty");
                image = new ImageIcon("static/cat.jpg");
                picture.setIcon(image);
            }
            catch(Exception w) {
                return;
                }
            clip.setFramePosition(0);
            clip.start();
        }
        else if (e.getSource() == stopBtn) {
            if (clip != null) {
                clip.stop();
            }
            else {
                return;
            }
        }
    }


    private void changeSound(String sound) throws Exception {
        file = new URL("file:static/" + sound + ".wav");
        ais = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(ais);
        FloatControl adjustVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        adjustVolume.setValue(-20.0f);
    }
}
