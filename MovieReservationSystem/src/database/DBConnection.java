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
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?serverTimezone=UTC", "root", "");
    }

    public ResultSet retrieve(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void insert(String table) throws SQLException {
        String sql = "INSERT INTO " + table + " ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }

    public void truncate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void update(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

}
