import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Scanner input = new Scanner(System.in);
        int choice;
        String username;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:database/users.db");
            System.out.println("Connection succesfull!");
            while(true) {
                System.out.println("1.Insert an user 2.Delete an user 3.Show all users 0.Quit program");
                try {
                choice = input.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("Enter a valid choice !");
                    input.nextLine();
                    continue;
                }
                if (choice == 1) {
                    System.out.println("Insert an user with the username:");
                    input.nextLine();
                    username = input.nextLine();
                    insertUser(conn, username);
                }
                else if (choice == 2) {
                    System.out.println("Delete an user with the username:");
                    input.nextLine();
                    username = input.nextLine();
                    deleteUser(conn, username);
                }
                else if (choice == 3) {
                    System.out.println("All of the registered users:");
                    input.nextLine();
                    printUsers(conn);
                }
                else if (choice == 0) {
                    break;
                }
                else {
                    System.out.println("Invalid output!");
                    input.nextLine();
                }
            }
            
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            conn.close();
            input.close();
            System.out.println("Database closed!");
        }

    }
    public static void printUsers(Connection conn) {
        String query = "SELECT * FROM users";
        try {
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery(query);
        while(rs.next()) {
            System.out.println(rs.getString("username"));
        }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public static void insertUser(Connection conn, String username) {
        String query = "INSERT INTO users (username) VALUES(?)";
        try {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void deleteUser(Connection conn, String username ) {
        String query = "DELETE FROM users WHERE username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            int result = ps.executeUpdate();
            System.out.println(result >= 1 ? "Deleted succesfully" : "No such user in database");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
