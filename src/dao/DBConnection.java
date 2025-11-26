package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Simple DB connection helper.
// Update URL, USER, PASS before running.
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/attendance_system?useSSL=false&serverTimezone=UTC";
    // DB credentials are now read from environment variables for safety.
    // Set ATTENDANCE_DB_USER and ATTENDANCE_DB_PASS in your system/env.
    private static final String USER = System.getenv("ATTENDANCE_DB_USER") != null
            ? System.getenv("ATTENDANCE_DB_USER")
            : "root";
    private static final String PASS = System.getenv("ATTENDANCE_DB_PASS");

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
