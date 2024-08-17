/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Faculty;

public class FacultyDAO extends DBConnection {

    public List<Faculty> getALL() {
        List<Faculty> list = new ArrayList<>();
        String sql = "select faculty_id, faculty_name from faculty";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Faculty f = new Faculty(rs.getInt(1),
                        rs.getString(2));
                list.add(f);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public Faculty getFacultyByID(int id) {
        String sql = "select faculty_id, faculty_name from faculty where faculty_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Faculty f = new Faculty(rs.getInt(1),
                        rs.getString(2));
                return f;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        FacultyDAO c = new FacultyDAO();
        List<Faculty> list = c.getALL();
        System.out.println(list.get(0).getFacultyName());
    }


}
