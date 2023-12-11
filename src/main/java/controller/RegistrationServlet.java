package controller;

import connection.ConnectionProvider;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import pojo.Student;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve data from the registration form
        String name = request.getParameter("name");
        String sic = request.getParameter("sic");
        String dept = request.getParameter("dept");
        String marks = request.getParameter("marks");

        // Create a Student object
        Student student = new Student();
        student.setName(name);
        student.setSic(sic);
        student.setDept(dept);
        student.setMarks(marks);

        // Use the DAO to register the student
        StudentDAO.registerStudent(student);

        // Send a response to the client
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<body>" +
                "<h2>Registration Successful</h2><br/>" +
                "<a href='ViewServlet'>view Students</a>" +
                "</body>" +
                "</html>");
    }
}
