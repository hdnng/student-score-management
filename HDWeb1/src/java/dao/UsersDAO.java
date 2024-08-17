/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.Faculty;
import model.Users;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import model.Clazz;

/**
 *
 * @author Admin
 */
public class UsersDAO extends DBConnection {

    public List<Users> getALLStudent() {
        List<Users> list = new ArrayList<>();
        String sql = "select users_id, name, birthday, "
                + "addrezz, email, phone_number, faculty_id from "
                + "users where is_deleted = 0 and role = 1";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Users s = new Users();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setBirthday(rs.getString(3));
                s.setAddress(rs.getString(4));
                s.setEmail(rs.getString(5));
                s.setPhoneNumber(rs.getString(6));
                FacultyDAO fdb = new FacultyDAO();
                Faculty f = fdb.getFacultyByID(rs.getInt(7));
                s.setFaculty(f);
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Users> getUsersByFID(int id) throws ClassNotFoundException {
        List<Users> list = new ArrayList<>();
        String sql = "select users_id, name, birthday, "
                + "addrezz, email, phone_number, faculty_id from "
                + "users where is_deleted = 0 and faculty_id = ? ";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Users s = new Users();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setBirthday(rs.getString(3));
                s.setAddress(rs.getString(4));
                s.setEmail(rs.getString(5));
                s.setPhoneNumber(rs.getString(6));
                FacultyDAO fdb = new FacultyDAO();
                Faculty f = fdb.getFacultyByID(rs.getInt(7));
                s.setFaculty(f);
                list.add(s);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Users getUsersByID(int id) {

        String sql = "select users_id, name, birthday, "
                + "addrezz, email, phone_number, faculty_id from "
                + "users where is_deleted = 0 and users_id = ? ";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Users s = new Users();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setBirthday(rs.getString(3));
                s.setAddress(rs.getString(4));
                s.setEmail(rs.getString(5));
                s.setPhoneNumber(rs.getString(6));
                FacultyDAO fdb = new FacultyDAO();
                Faculty f = fdb.getFacultyByID(rs.getInt(7));
                s.setFaculty(f);
                return s;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

//    public List<Users> getStudentClass(int id) {
//        List<Users> students = new ArrayList<>();
//        String sql = "select u.users_id, u.name, u.birthday, u.addrezz, u.email, u.phone_number\n"
//                + "from student_class sc\n"
//                + "join users u on sc.student_id = u.users_id\n"
//                + "join class c on sc.class_id = c.class_id\n"
//                + "where c.class_id = ?";
//        try {
//            PreparedStatement st = getConnection().prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                Users s = new Users();
//                s.setId(rs.getInt(1));
//                s.setName(rs.getString(2));
//                s.setBirthday(rs.getString(3));
//                s.setAddress(rs.getString(4));
//                s.setEmail(rs.getString(5));
//                s.setPhoneNumber(rs.getString(6));
//                students.add(s);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return null;
//
//    }
    public List<Users> getStudentsByClassID(int classID) throws ClassNotFoundException {
        List<Users> students = new ArrayList<>();
        String sql = "SELECT u.users_id, u.name, u.birthday, u.addrezz, u.email, u.phone_number "
                + "FROM student_class sc "
                + "JOIN users u ON sc.student_id = u.users_id "
                + "JOIN class c ON sc.class_id = c.class_id "
                + "WHERE c.class_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, classID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Users student = new Users();
                student.setId(rs.getInt("users_id"));
                student.setName(rs.getString("name"));
                student.setBirthday(rs.getString("birthday"));
                student.setAddress(rs.getString("addrezz"));
                student.setEmail(rs.getString("email"));
                student.setPhoneNumber(rs.getString("phone_number"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return students;
    }

    public List<Users> getStudentByFID(int id) throws ClassNotFoundException {
        List<Users> students = new ArrayList<>();
        String sql = "select users_id, name, birthday, addrezz, email, phone_number\n"
                + "from users u \n"
                + "where u.role = 1 and u.is_deleted = 0 and u.faculty_id = ? ";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Users student = new Users();
                student.setId(rs.getInt("users_id"));
                student.setName(rs.getString("name"));
                student.setBirthday(rs.getString("birthday"));
                student.setAddress(rs.getString("addrezz"));
                student.setEmail(rs.getString("email"));
                student.setPhoneNumber(rs.getString("phone_number"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return students;
    }

    public List<Users> getLecturerByFID(int id) throws ClassNotFoundException {
        List<Users> students = new ArrayList<>();
        String sql = "select users_id, name, birthday, addrezz, email, phone_number\n"
                + "from users u \n"
                + "where u.role = 2 and is_deleted = 0 and u.faculty_id = ?";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Users lecturer = new Users();
                lecturer.setId(rs.getInt("users_id"));
                lecturer.setName(rs.getString("name"));
                lecturer.setBirthday(rs.getString("birthday"));
                lecturer.setAddress(rs.getString("addrezz"));
                lecturer.setEmail(rs.getString("email"));
                lecturer.setPhoneNumber(rs.getString("phone_number"));
                students.add(lecturer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return students;
    }
//

    public void insertStudent(Users s) throws Exception {
        String sql = "insert into users (username, password, name, birthday, addrezz,"
                + " email, phone_number, role, faculty_id) values(?,?,?,?,?,?,?,1,?)";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, s.getUsername());
            st.setString(2, s.getPassword());
            st.setString(3, s.getName());
            st.setString(4, s.getBirthday());
            st.setString(5, s.getAddress());
            st.setString(6, s.getEmail());
            st.setString(7, s.getPhoneNumber());
            st.setInt(8, s.getFaculty().getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("adasdasdasd");
        }
    }

    public void insertLecturer(Users s) throws Exception {
        String sql = "insert into users (username, password, name, birthday, addrezz,"
                + " email, phone_number, role, faculty_id) values(?,?,?,?,?,?,?,2,?)";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, s.getUsername());
            st.setString(2, s.getPassword());
            st.setString(3, s.getName());
            st.setString(4, s.getBirthday());
            st.setString(5, s.getAddress());
            st.setString(6, s.getEmail());
            st.setString(7, s.getPhoneNumber());
            st.setInt(8, s.getFaculty().getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("adasdasdasd");
        }
    }

    public void update(Users s) {

        String sql = "update users set name = ?, birthday = ?, addrezz = ?, "
                + "email = ?, phone_number = ?, faculty_id = ? where users_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, s.getName());
            st.setString(2, s.getBirthday());
            st.setString(3, s.getAddress());
            st.setString(4, s.getEmail());
            st.setString(5, s.getPhoneNumber());
            st.setInt(6, s.getFaculty().getId());
            st.setInt(7, s.getId());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatePersonalInfo(Users s) {
        String sql = "update users set addrezz = ?, email = ?, phone_number = ? where users_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, s.getAddress());
            st.setString(2, s.getEmail());
            st.setString(3, s.getPhoneNumber());
            st.setInt(4, s.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//

    public void delete(String id) {
        String sqll = "update users set is_deleted = 1 where users_id = ?";
        PreparedStatement st;
        try {
            st = getConnection().prepareStatement(sqll);
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, Exception {
        UsersDAO c = new UsersDAO();
//        List<Users> list = c.getUsersByFID(1);
//        System.out.println(list.get(0).getRole());
//        List<Users> list = c.getStudentsByClassID(1);
//        System.out.println(list.get(0).getName());

        Faculty b = new Faculty();
        b.setId(6);
        c.insertStudent(new Users("ub", "pua", "dnh", "02/23/2003", "hn", "ab@gmail.com", "00003123416", b));
//        List<Users> list2 = c.getStudentByFID(1);
//        System.out.println(list2.get(0).getClazz().getClassName());

    }

}
