/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Schedule {
    private int id;
    private Subject subject;
    private Users lecturer;
    private Classroom classroom;
    private String startTime;
    private String endTime;

    public Schedule() {
    }

    public Schedule(int id, Subject subject, Users lecturer, Classroom classroom, String startTime, String endTime) {
        this.id = id;
        this.subject = subject;
        this.lecturer = lecturer;
        this.classroom = classroom;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Users getLecturer() {
        return lecturer;
    }

    public void setLecturer(Users lecturer) {
        this.lecturer = lecturer;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
}


