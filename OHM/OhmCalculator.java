import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OhmCalculator implements ActionListener{
    
    JFrame frame = new JFrame();
    JButton calculateBtn = new JButton("Calculate");
    JButton resetBtn = new JButton("Reset");
    JTextField voltsField = new JTextField();
    JTextField ohmsField = new JTextField();
    JLabel voltsLabel = new JLabel("Volts:");
    JLabel ohmsLabel = new JLabel("Ohms:");
    

    OhmCalculator() {
       
        voltsLabel.setBounds(50, 100, 75, 25);
        ohmsLabel.setBounds(50, 150, 75, 25);

        voltsField.setBounds(125, 100, 200, 25);
        ohmsField.setBounds(125, 150, 200, 25);

        calculateBtn.setBounds(125, 200, 100, 25);
        calculateBtn.setFocusable(false);
        calculateBtn.addActionListener(this);

        resetBtn.setBounds(225, 200, 100, 25);
        resetBtn.setFocusable(false);
        resetBtn.addActionListener(this);

        frame.add(calculateBtn);
        frame.add(resetBtn);
        frame.add(voltsField);
        frame.add(ohmsField);
        frame.add(voltsLabel);
        frame.add(ohmsLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetBtn) {
            voltsField.setText("");
            ohmsField.setText("");
        }
        if(e.getSource() == calculateBtn) {
            String volts = voltsField.getText();
            String ohms = ohmsField.getText();
            ResultsPage welcomepage = new ResultsPage(Float.valueOf(volts) / Float.valueOf(ohms));
        }
    }
}
