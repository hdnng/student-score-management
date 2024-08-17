/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.util.ArrayList;
import java.util.List;
import model.Grade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Subject;

/**
 *
 * @author Admin
 */
public class GradesDAO extends DBConnection {

    public List<Grade> getGradesByUID(int id) throws ClassNotFoundException, SQLException {
        List<Grade> list = new ArrayList<>();
        String sql = "select sb.subject_id, sb.subject_name, sb.credit_hour, "
                + "g.grade1, g.grade2, g.grade3 "
                + "from grades g "
                + "join semester s on g.semester_id = s.semester_id "
                + "join subjects sb on g.subject_id = sb.subject_id "
                + "join users u on g.student_id = u.users_id "
                + "where u.users_id = ? and s.semester_id = 1";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Grade g = new Grade();
                Subject s = new Subject();
                s.setId(rs.getInt("subject_id"));
                s.setSubjectName(rs.getString("subject_name"));
                s.setCreditHour(rs.getInt("credit_hour"));
                g.setSubject(s);
                g.setGrade1(rs.getDouble("grade1"));
                g.setGrade2(rs.getDouble("grade2"));
                g.setGrade3(rs.getDouble("grade3"));
                list.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Grade> getGradesByUID2(int id) throws ClassNotFoundException, SQLException {
        List<Grade> list = new ArrayList<>();
        String sql = "select sb.subject_id, sb.subject_name, sb.credit_hour, "
                + "g.grade1, g.grade2, g.grade3 "
                + "from grades g "
                + "join semester s on g.semester_id = s.semester_id "
                + "join subjects sb on g.subject_id = sb.subject_id "
                + "join users u on g.student_id = u.users_id "
                + "where u.users_id = ? and s.semester_id = 2";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Grade g = new Grade();
                Subject s = new Subject();
                s.setId(rs.getInt("subject_id"));
                s.setSubjectName(rs.getString("subject_name"));
                s.setCreditHour(rs.getInt("credit_hour"));
                g.setSubject(s);
                g.setGrade1(rs.getDouble("grade1"));
                g.setGrade2(rs.getDouble("grade2"));
                g.setGrade3(rs.getDouble("grade3"));
                list.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Grade> getGradesByUID3(int id) throws ClassNotFoundException, SQLException {
        List<Grade> list = new ArrayList<>();
        String sql = "select sb.subject_id, sb.subject_name, sb.credit_hour, "
                + "g.grade1, g.grade2, g.grade3 "
                + "from grades g "
                + "join semester s on g.semester_id = s.semester_id "
                + "join subjects sb on g.subject_id = sb.subject_id "
                + "join users u on g.student_id = u.users_id "
                + "where u.users_id = ? and s.semester_id = 3";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Grade g = new Grade();
                Subject s = new Subject();
                s.setId(rs.getInt("subject_id"));
                s.setSubjectName(rs.getString("subject_name"));
                s.setCreditHour(rs.getInt("credit_hour"));
                g.setSubject(s);
                g.setGrade1(rs.getDouble("grade1"));
                g.setGrade2(rs.getDouble("grade2"));
                g.setGrade3(rs.getDouble("grade3"));
                list.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
