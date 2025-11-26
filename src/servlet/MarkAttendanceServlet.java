package servlet;

import dao.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/markAttendance")
public class MarkAttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String studentId = req.getParameter("student_id");
        String subjectId = req.getParameter("subject_id");
        String status = req.getParameter("status");

        String sql = "INSERT INTO attendance (student_id, subject_id, date, status, marked_by) VALUES (?, ?, CURDATE(), ?, ?)";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(studentId));
            ps.setInt(2, Integer.parseInt(subjectId));
            ps.setString(3, status);
            // marked_by can be teacher id from session (placeholder 1)
            ps.setInt(4, 1);
            ps.executeUpdate();

            res.sendRedirect("teacher/mark.jsp?success=1");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("teacher/mark.jsp?error=1");
    }
}
