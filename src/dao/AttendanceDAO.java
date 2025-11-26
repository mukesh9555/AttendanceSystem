package dao;
import java.sql.*;
public class AttendanceDAO {
    public boolean markAttendance(int studentId, int subjectId, java.sql.Date date, String status, int markedBy) {
        String sql = "INSERT INTO attendance(student_id, subject_id, date, status, marked_by) VALUES(?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, subjectId);
            ps.setDate(3, date);
            ps.setString(4, status);
            ps.setInt(5, markedBy);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch(Exception e){ e.printStackTrace(); }
        return false;
    }
}
