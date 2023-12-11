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

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        String sic=request.getParameter("sic");
        String dept=request.getParameter("dept");
        String marks=request.getParameter("marks");

        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setSic(sic);
        student.setDept(dept);
        student.setMarks(marks);

        int status= StudentDAO.updateStudent(student);
        if(status>0){
            response.sendRedirect("ViewServlet");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}