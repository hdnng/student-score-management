/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.Faculty;
import model.Subject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class SubjectDAO extends DBConnection {

    public List<Subject> getSubjectsByFID(int id) throws ClassNotFoundException {
        List<Subject> list = new ArrayList<>();
        String sql = "select subject_id, subject_name, describe, credit_hour, faculty_id"
                + " from subjects where  is_deleted = 0 and faculty_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setId(rs.getInt(1));
                s.setSubjectName(rs.getString(2));
                s.setDescribe(rs.getString(3));
                s.setCreditHour(rs.getInt(4));
                FacultyDAO fdb = new FacultyDAO();
                Faculty f = fdb.getFacultyByID(rs.getInt(5));
                s.setFaculty(f);
                list.add(s);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Subject getSubjectByID(int id) {
        String sql = "select subject_id, subject_name, describe, credit_hour, faculty_id"
                + " from subjects where  is_deleted = 0 and subject_id = ?";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Subject s = new Subject();
                s.setId(rs.getInt(1));
                s.setSubjectName(rs.getString(2));
                s.setDescribe(rs.getString(3));
                s.setCreditHour(rs.getInt(4));
                FacultyDAO fdb = new FacultyDAO();
                Faculty f = fdb.getFacultyByID(rs.getInt(5));
                s.setFaculty(f);
                return s;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void insert(Subject s) throws Exception {
        String sql = "insert into subjects (subject_name, describe, "
                + "credit_hour, faculty_id) values(?,?,?,?)";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, s.getSubjectName());
            st.setString(2, s.getDescribe());
            st.setInt(3, s.getCreditHour());
            st.setInt(4, s.getFaculty().getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("adasdasdasd");
        }
    }

    public void update(Subject s) {

        String sql = "update subjects set subject_name = ?, describe = ?, "
                + "credit_hour = ?, faculty_id = ? where subject_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, s.getSubjectName());
            st.setString(2, s.getDescribe());
            st.setInt(3, s.getCreditHour());
            st.setInt(4, s.getFaculty().getId());
            st.setInt(5, s.getId());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(String id) {
        String sqll = "update subjects set is_deleted = 1 where subject_id = ?";
        PreparedStatement st;
        try {
            st = getConnection().prepareStatement(sqll);
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        SubjectDAO c = new SubjectDAO();
        List<Subject> list = c.getSubjectsByFID(1);
        System.out.println(list.get(0).getFaculty().getFacultyName());

//        Faculty b = new Faculty();
//        b.setId("F002");
//        insert(new Subject("S2022", "A", "B", 1, b));
    }

}
