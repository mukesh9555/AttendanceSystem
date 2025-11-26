<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
            padding: 30px;
        }
        h2 {
            color: #333;
            margin-bottom: 10px;
            border-bottom: 3px solid #667eea;
            padding-bottom: 10px;
        }
        .description {
            color: #666;
            margin-bottom: 30px;
            font-size: 16px;
        }
        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-top: 30px;
        }
        .card {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 25px;
            border-radius: 8px;
            cursor: pointer;
            transition: transform 0.3s, box-shadow 0.3s;
            text-decoration: none;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.4);
        }
        .card h3 {
            margin-bottom: 10px;
            font-size: 20px;
        }
        .card p {
            font-size: 14px;
            opacity: 0.9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Admin Panel</h2>
        <p class="description">Manage teachers, students, and subjects</p>
        
        <div class="dashboard-grid">
            <div class="card">
                <h3>👨‍🏫 Teachers</h3>
                <p>Add, edit, or remove teacher records</p>
            </div>
            <div class="card">
                <h3>👨‍🎓 Students</h3>
                <p>Manage student information and records</p>
            </div>
            <div class="card">
                <h3>📚 Subjects</h3>
                <p>Create and organize subjects</p>
            </div>
            <div class="card">
                <h3>📊 Reports</h3>
                <p>View attendance and performance reports</p>
            </div>
        </div>
    </div>
</body>
</html>
