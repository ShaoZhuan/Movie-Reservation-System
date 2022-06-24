package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnection {

    private ResultSet rs;

    static Connection conn;
    
    //Connect to the database.
    public DBConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?serverTimezone=UTC", "root", "hng.2000");
    }

    public ResultSet retrieve(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }


}
