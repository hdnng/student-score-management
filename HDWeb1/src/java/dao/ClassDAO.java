///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package dao;
//
//import static db.DBConnection.getConnection;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import java.util.ArrayList;
//import java.util.List;
//import model.Clazz;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import model.Users;
//
///**
// *
// * @author Admin
// */
//@WebServlet(name = "ClassDAO", urlPatterns = {"/ClassDAO"})
//public class ClassDAO extends HttpServlet {
//
//    public List<Clazz> getClasssByFID(int id) throws ClassNotFoundException, SQLException {
//        List<Clazz> list = new ArrayList<>();
//        String sql = "select c.class_id, c.class_name, u.users_id from lecturer_class lc join class c \n"
//                + "on lc.class_id = c.class_id join users u \n"
//                + "on lc.lecturer_id = u.users_id \n"
//                + "where c.faculty_id = ?";
//        try {
//            PreparedStatement st = getConnection().prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Clazz s = new Clazz();
//                s.setId(rs.getInt(1));
//                s.setClassName(rs.getString(2));
//                UsersDAO udb = new UsersDAO();
//                Users u = udb.getUsersByID(rs.getInt(3));
//                list.add(s);
//            }
//        } catch (SQLException e) {
//        }
//        return list;
//    }
//
//    public Clazz getClassByID(int id) {
//
//        String sql = "select c.class_id, c.class_name, u.users_id from lecturer_class lc join class c \n"
//                + "on lc.class_id = c.class_id join users u \n"
//                + "on lc.lecturer_id = u.users_id \n"
//                + "where c.class_id = ?";
//
//        try {
//            PreparedStatement st = getConnection().prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Clazz s = new Clazz();
//                s.setId(rs.getInt(1));
//                s.setClassName(rs.getString(2));
//                UsersDAO udb = new UsersDAO();
//                Users u = udb.getUsersByID(rs.getInt(3));
//                s.setLecturer(u);
//                return s;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return null;
//    }
//
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ClassDAO c = new ClassDAO();
//        List<Clazz> list = c.getClasssByFID(1);
//        if (list.isEmpty()) {
//            System.out.println("No classes found for the given faculty ID.");
//        } else {
//            for (Clazz clazz : list) {
//                System.out.println("Class ID: " + clazz.getId());
//                System.out.println("Class Name: " + clazz.getClassName());
//                System.out.println("Lecturer ID: " + clazz.getLecturer().getId());
//            }
//        }
////        Faculty b = new Faculty();
////        b.setId("F002");
////        insert(new Subject("S2022", "A", "B", 1, b));
//
//    }
//}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.Faculty;
import model.Clazz;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import model.Users;

/**
 *
 * @author Admin
 */
public class ClassDAO extends DBConnection {

    public List<Clazz> getClassByFID(int id) throws ClassNotFoundException {
        List<Clazz> list = new ArrayList<>();
        String sql = "select c.class_id, c.class_name, u.users_id from lecturer_class lc join class c \n"
                + "on lc.class_id = c.class_id join users u \n"
                + "on lc.lecturer_id = u.users_id \n"
                + "where c.faculty_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Clazz s = new Clazz();
                s.setId(rs.getInt(1));
                s.setClassName(rs.getString(2));
                UsersDAO udb = new UsersDAO();
                Users u = udb.getUsersByID(rs.getInt(3));
                s.setLecturer(u);
                list.add(s);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Clazz getClassByID(int id) {

        String sql = "select c.class_id, c.class_name, u.users_id from lecturer_class lc join class c \n"
                + "on lc.class_id = c.class_id join users u \n"
                + "on lc.lecturer_id = u.users_id \n"
                + "where c.class_id = ?";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Clazz s = new Clazz();
                s.setId(rs.getInt(1));
                s.setClassName(rs.getString(2));
                UsersDAO udb = new UsersDAO();
                Users u = udb.getUsersByID(rs.getInt(3));
                s.setLecturer(u);
                return s;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void insert(Clazz s) throws Exception {
        String sql = "insert into class (class_name, faculty_id) values(?,?)";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, s.getClassName());
            st.setInt(2, s.getFaculty().getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("adasdasdasd");
        }
    }
//
//    public void update(Subject s) {
//
//        String sql = "update subjects set subjectName = ?, describe = ?, credit = ?, facultyID = ? where id=?";
//        try {
//            PreparedStatement st = getConnection().prepareStatement(sql);
//            st.setString(1, s.getSubjectName());
//            st.setString(2, s.getDescribe());
//            st.setInt(3, s.getCreditHour());
//            st.setInt(4, s.getFaculty().getId());
//            st.setInt(5, s.getId());
//            st.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void delete(String id) {
//        String sqll = "update subjects set is_deleted = 1 where id = ?";
//        PreparedStatement st;
//        try {
//            st = getConnection().prepareStatement(sqll);
//            st.setString(1, id);
//            st.executeUpdate();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//
//    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassDAO c = new ClassDAO();
        List<Clazz> list = c.getClassByFID(1);
//        if (list.isEmpty()) {
//            System.out.println("No classes found for the given faculty ID.");
//        } else {
//            for (Clazz clazz : list) {
//                System.out.println("Class ID: " + clazz.getId());
//                System.out.println("Class Name: " + clazz.getClassName());
//                System.out.println("Lecturer ID: " + clazz.getLecturer().getId());
//            }
//        }
        System.out.println(list.get(0).getFaculty());
    }

}
