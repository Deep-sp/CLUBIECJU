<%@ page import="java.sql.*" %>
<%
    String url = "jdbc:mysql://localhost:3306/schedule";
    String username = "root";
    String password = "";

    Connection connection = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        // Connection successful
    } catch (Exception e) {
        e.printStackTrace();
        // Connection failed

    }
    request.setAttribute("connection", connection);
%>
