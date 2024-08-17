/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Clazz {
    private int id;
    private String className;
    private Faculty faculty;
    private Users Lecturer;

    public Clazz() {
    }

    public Clazz(int id, String className, Faculty faculty, Users Lecturer) {
        this.id = id;
        this.className = className;
        this.faculty = faculty;
        this.Lecturer = Lecturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Users getLecturer() {
        return Lecturer;
    }

    public void setLecturer(Users Lecturer) {
        this.Lecturer = Lecturer;
    }
    
    
}
