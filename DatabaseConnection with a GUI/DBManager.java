import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DBManager implements ActionListener{
    
    JFrame frame = new JFrame();
    JTextField usernameField = new JTextField();
    JButton AddBtn = new JButton("Add user");
    JButton DeleteBtn = new JButton("Delete user");
    JButton SaveBtn = new JButton("Save users");
    JLabel messagelabel = new JLabel();
    SQLiteConn conn = null;

    DBManager() {
        conn = new SQLiteConn();
        

        messagelabel.setBounds(125, 250, 250, 35);
        messagelabel.setFont(new Font(null, Font.ITALIC, 25));


        AddBtn.setBounds(125, 200, 100, 25);
        AddBtn.setFocusable(false);
        AddBtn.addActionListener(this);

        DeleteBtn.setBounds(225, 200, 100, 25);
        DeleteBtn.setFocusable(false);
        DeleteBtn.addActionListener(this);

        SaveBtn.setBounds(10, 100, 100, 25);
        SaveBtn.setFocusable(false);
        SaveBtn.addActionListener(this);

        usernameField.setBounds(125, 100, 200, 25);

        frame.add(AddBtn);
        frame.add(SaveBtn);
        frame.add(usernameField);
        frame.add(DeleteBtn);
        frame.add(messagelabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (conn.getStatus() != true) {
            messagelabel.setText("DB connection has failed");
            return;
        }

        if(e.getSource() == DeleteBtn) {
            String username = usernameField.getText();
            if (username.length() <= 0) {
                return;
            }
            boolean deleted = conn.deleteUser(username);
            messagelabel.setText(deleted ? "Deleted succesfully" : "No such user");
    
        }
        if(e.getSource() == AddBtn) {
            String username = usernameField.getText();
            if (username.length() <= 0) {
                return;
            }
            boolean added = conn.insertUser(username);
            messagelabel.setText(added ? "Inserted succesfully" : "Inserting failed");
        }
        if(e.getSource() == SaveBtn) {
            try {
                PrintWriter pw = new PrintWriter("users.txt");
                ResultSet users = conn.getUsers();
                if (users == null) {
                    messagelabel.setText("Saving failed");
                    pw.close();
                    return;
                }
                pw.print("");
                try{
                    while(users.next()) {
                        pw.println(users.getString("username"));
                    }
                }
                catch (SQLException ex) {
                    pw.close();
                    return;
                }
                pw.close();
                messagelabel.setText("Users saved");
            }
            catch (FileNotFoundException ex) {
                return;
            }
        }

    }
}