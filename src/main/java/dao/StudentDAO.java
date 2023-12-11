package dao;

import connection.ConnectionProvider;
import pojo.Student;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    public static void registerStudent(Student student) {
        try {
            Connection connection = ConnectionProvider.getConnection();

            String query = "INSERT INTO students (name, sic, dept, marks) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSic());
            preparedStatement.setString(3, student.getDept());
            preparedStatement.setString(4, student.getMarks());
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int updateStudent(Student student){
        int status=0;
        try {
            Connection connection = ConnectionProvider.getConnection();
            String query = "UPDATE students SET name=?, sic=?, dept=?, marks=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSic());
            preparedStatement.setString(3, student.getDept());
            preparedStatement.setString(4, student.getMarks());
            preparedStatement.setInt(5, student.getId());
            status=preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteStudents(int id){
        int status = 0;
        try{
            Connection connection = ConnectionProvider.getConnection();
            String query = "DELETE from students WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public static Student getStudentById (int id){
        Student student = new Student();
        try{
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from students where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setSic(resultSet.getString(3));
                student.setDept(resultSet.getString(4));
                student.setMarks(resultSet.getString(5));
            }
            connection.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return student;
    }

    public static List<Student> getAllStudent(){
        List<Student> list=new ArrayList<Student>();

        try{
            Connection con=ConnectionProvider.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from students");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setSic(rs.getString(3));
                student.setDept(rs.getString(4));
                student.setMarks(rs.getString(5));
                list.add(student);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
}
