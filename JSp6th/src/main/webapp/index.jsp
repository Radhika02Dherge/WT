<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page 
import="java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet,java.sql.Statement" %>
<html>
<head>
<style>
* {
font-family: "Inter";
}
table {
width: 100%;
border-collapse: collapse;
}
th, td {
padding: 8px;
text-align: left;
border-bottom: 1px solid #ddd;
}
th {
background-color: #f2f2f2;
}
tr:hover {
background-color: #f5f5f5;
}
</style>
<title>Student Info</title>
</head>
<body>
<h1>Student Info</h1>
<table border='1'>
<tr>
<th>Id</th>
<th>Student Name</th>
<th>Class</th>
<th>Division</th>
<th>City</th>
</tr>
<%!
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
String url = "jdbc:mysql://localhost:3306/college";
String user = "root";
String pass = "";
%>
<%
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url, user, pass);
stmt = con.createStatement();
rs = stmt.executeQuery("SELECT * FROM stud_info");
while (rs.next()) {
%>
<tr>
<td><%= rs.getString("stud_id") %></td>
<td><%= rs.getString("stud_name") %></td>
<td><%= rs.getString("class") %></td>
<td><%= rs.getString("division") %></td>
<td><%= rs.getString("city") %></td>
</tr>
<%
}
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
if (rs != null) rs.close();
if (stmt != null) stmt.close();
if (con != null) con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
%>
</table>
</body>
</html>