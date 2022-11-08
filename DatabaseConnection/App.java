import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:database/users.db");
            System.out.println("Connection succesfull!");
            insertUser(conn, "petko");
            printUsers(conn);
            
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            conn.close();
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
}
