import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Calculator implements ActionListener {
    JFrame frame = new JFrame();
    JButton addBtn = new JButton("+");
    JButton subBtn = new JButton("-");
    JButton mulBtn = new JButton("*");
    JButton divBtn = new JButton("/");
    JButton resetBtn = new JButton("Reset");
    JTextField numberField = new JTextField();
    JLabel resultLabel = new JLabel();
    float result;


    Calculator() {
        result = 0;

        addBtn.setBounds(205, 200, 100, 20);
        addBtn.addActionListener(this);
        subBtn.setBounds(205, 225, 100, 20);
        subBtn.addActionListener(this);
        mulBtn.setBounds(205, 250, 100, 20);
        mulBtn.addActionListener(this);
        divBtn.setBounds(205, 275, 100, 20);
        divBtn.addActionListener(this);
        resetBtn.setBounds(205, 150, 100, 20);
        resetBtn.addActionListener(this);
        numberField.setBounds(155, 100, 200, 25);
        resultLabel.setBounds(255, 350, 250, 35);
        resultLabel.setFont(new Font(null, Font.ITALIC, 25));
        resultLabel.setText("0");

        frame.add(addBtn);
        frame.add(subBtn);
        frame.add(mulBtn);
        frame.add(divBtn);
        frame.add(numberField);
        frame.add(resetBtn);
        frame.add(resultLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(510, 510);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        float number;
        try {
            number = Float.parseFloat(numberField.getText());
        }
        catch(NumberFormatException | NullPointerException ex) {
            resultLabel.setText("Input a valid number!");
            return;
        }

        if (e.getSource() == addBtn) {
            result = result + number;
        }
        else if (e.getSource() == subBtn) {
            result = result - number;
        }
        else if (e.getSource() == mulBtn) {
            result = result * number;
        }
        else if (e.getSource() == divBtn) {
            result = result / number;
        }
        else if (e.getSource() == resetBtn) {
            result = 0;
            resultLabel.setText("0");
            numberField.setText("");
            return;
        }
        resultLabel.setText(Float.toString(result));
    }
}