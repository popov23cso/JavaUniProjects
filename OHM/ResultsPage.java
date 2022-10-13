import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultsPage {
    JFrame frame = new JFrame();
    JLabel welcomelabel = new JLabel("Hi");

    ResultsPage(float result) {
        welcomelabel.setBounds(0, 0, 200, 35);
        welcomelabel.setFont(new Font(null, Font.PLAIN, 25));
        welcomelabel.setText("I = " + result + " A");


        frame.add(welcomelabel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
