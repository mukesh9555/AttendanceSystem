package dao;
import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    public Student getByEmailAndPassword(String email, String pass) {
        try (Connection c = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students WHERE email=? AND password=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setRollNo(rs.getString("roll_no"));
                return s;
            }
        } catch(Exception e) { e.printStackTrace(); }
        return null;
    }
}
