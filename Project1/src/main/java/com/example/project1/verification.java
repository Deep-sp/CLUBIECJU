package com.example.project1;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "verification", urlPatterns = "/verification")
public class verification extends HttpServlet {
    private String message;

    public void init() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Schedule", "root", "root");
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'");
            System.out.println("Done");

            if (resultSet.next()){
                response.sendRedirect("index.html");
                System.out.println("Redirect");
            }
            else {
                response.sendRedirect("The_code_is_wrong.jsp");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("log_in.jsp");
    }

    public void destroy() {
    }
}