package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Student;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Employee</h1>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);

        Student student= StudentDAO.getStudentById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+student.getId()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+student.getName()+"'/></td></tr>");
        out.print("<tr><td>SIC:</td><td><input type='text' name='sic' value='"+student.getSic()+"'/></td></tr>");
        out.print("<tr><td>Dept:</td><td><input type='text' name='dept' value='"+student.getDept()+"'/></td></tr>");
        out.print("<tr><td>Marks:</td><td><input type='text' name='marks' value='"+student.getMarks()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}