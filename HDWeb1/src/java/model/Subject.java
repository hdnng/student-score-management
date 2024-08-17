/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Subject {
    private int id;
    private String subjectName;
    private String describe;
    private int creditHour;
    private Faculty faculty;

    public Subject() {
    }

    public Subject(String subjectName, String describe, int creditHour, Faculty faculty) {
        this.subjectName = subjectName;
        this.describe = describe;
        this.creditHour = creditHour;
        this.faculty = faculty;
    }

    public Subject(int id, String subjectName, String describe, int creditHour, Faculty faculty) {
        this.id = id;
        this.subjectName = subjectName;
        this.describe = describe;
        this.creditHour = creditHour;
        this.faculty = faculty;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    
    
}
