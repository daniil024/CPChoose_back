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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "has_approved_cp")
    private CourseProjectDTO courseProject;


    public StudentDTO() {
    }

    public StudentDTO(String faculty, String speciality, int year_of_study) {
        super();
        this.faculty = faculty;
        this.speciality = speciality;
        this.yearOfStudy = year_of_study;
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

    public CourseProjectDTO getCourseProject() {
        return courseProject;
    }

    public void setCourseProject(CourseProjectDTO courseProject) {
        this.courseProject = courseProject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO student = (StudentDTO) o;
        return id == student.id && yearOfStudy == student.yearOfStudy
                && Objects.equals(faculty, student.faculty)
                && Objects.equals(speciality, student.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, faculty, speciality, yearOfStudy);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", faculty='" + faculty + '\'' +
                ", speciality='" + speciality + '\'' +
                ", year_of_study=" + yearOfStudy +
                '}';
    }
}
