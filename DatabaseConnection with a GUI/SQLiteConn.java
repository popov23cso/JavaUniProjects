import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConn {
    private Connection conn = null;
    public boolean status;
    SQLiteConn() {
        try {
        conn = DriverManager.getConnection("jdbc:sqlite:database/users.db");
        status = true;
        }
        catch (SQLException e) {
            status = false;
        }
    }

    public boolean insertUser(String username) {
        String query = "INSERT INTO users (username) VALUES(?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }

    public boolean deleteUser(String username) {
        String query = "DELETE FROM users WHERE username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            int result = ps.executeUpdate();
            return (result >= 1 ? true : false);
        }
        catch (SQLException e) {
            return false;
        }
    }


    public ResultSet getUsers() {
        String query = "SELECT * FROM users";
        try {
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery(query);
        return rs;
        }
        catch (SQLException e)
        {
            return null;
        }
    }
}
