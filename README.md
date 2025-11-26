# Student Attendance Management System (Java + JSP + Servlet + MySQL)

Premium project skeleton — production-style structure, ready to import into Eclipse/IntelliJ (Dynamic Web Project / Tomcat).

## What's included
- Java model, DAO and servlet templates
- JSP pages (login, dashboards, mark attendance)
- SQL schema file
- Sample QR servlet and PDF export placeholder
- web.xml and project structure

## How to use
1. Import `AttendanceSystem` as a Dynamic Web Project to your IDE.
2. Add the JDBC driver (mysql-connector-java) into WEB-INF/lib.
3. Create the database using `sql/attendance_schema.sql`.
4. Configure DB connection in `src/dao/DBConnection.java`.
5. Deploy to Tomcat and access `/AttendanceSystem/`.
