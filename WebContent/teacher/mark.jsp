<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head><title>Mark Attendance</title></head>
<body>
  <h2>Mark Attendance</h2>
  <form method="post" action="../markAttendance">
    <label>Student ID: <input name="student_id" required></label><br>
    <label>Subject ID: <input name="subject_id" required></label><br>
    <label>Status:
      <select name="status">
        <option>Present</option>
        <option>Absent</option>
        <option>Leave</option>
      </select>
    </label><br>
    <button type="submit">Save</button>
  </form>
  <p><img src="../generateQR?data=example_qr_for_class" alt="QR"/></p>
</body>
</html>
