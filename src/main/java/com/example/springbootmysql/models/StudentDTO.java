package com.example.springbootmysql.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students")
public class StudentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "year_of_study")
    private int yearOfStudy;

    @Column(name = "cp_chose_count")
    private int cpChoseCount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "has_approved_cp")
    private CourseProjectDTO courseProject;


    public StudentDTO() {
    }

    public StudentDTO(String faculty, String speciality, int year_of_study, int cpChoseCount) {
        super();
        this.faculty = faculty;
        this.speciality = speciality;
        this.yearOfStudy = year_of_study;
        this.cpChoseCount = cpChoseCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getCpChoseCount() {
        return cpChoseCount;
    }

    public void setCpChoseCount(int cpChoseCount) {
        this.cpChoseCount = cpChoseCount;
    }

    public CourseProjectDTO getCourseProject() {
        return courseProject;
    }

    public void setCourseProject(CourseProjectDTO courseProject) {
        this.courseProject = courseProject;
    }
}
