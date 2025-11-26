package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.UserDAO;
import model.Student;
import model.Teacher;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String role = req.getParameter("role");

        UserDAO dao = new UserDAO();

        try {
            if ("student".equals(role)) {
                Student s = dao.studentLogin(email, pass);
                if (s != null) {
                    req.getSession().setAttribute("student", s);
                    res.sendRedirect("student/dashboard.jsp");
                    return;
                }
            } else if ("teacher".equals(role)) {
                Teacher t = dao.teacherLogin(email, pass);
                if (t != null) {
                    req.getSession().setAttribute("teacher", t);
                    res.sendRedirect("teacher/dashboard.jsp");
                    return;
                }
            } else if ("admin".equals(role)) {
                // implement admin login (similar)
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("error", "Invalid Credentials!");
        req.getRequestDispatcher("login.jsp").forward(req, res);
    }
}
