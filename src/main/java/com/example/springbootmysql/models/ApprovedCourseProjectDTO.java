package com.example.springbootmysql.models;

import com.example.springbootmysql.models.enums.CPStatus;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "approved_course_projects")
public class ApprovedCourseProjectDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "professor_id")
    private UserDTO professor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "student_id")
    private UserDTO student;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "course_project_id")
    private CourseProjectDTO courseProject;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CPStatus status;

    public ApprovedCourseProjectDTO() {
    }

    public ApprovedCourseProjectDTO(UserDTO professor, UserDTO student,
                                    CourseProjectDTO courseProject, CPStatus status) {
        super();
        this.professor = professor;
        this.student = student;
        this.courseProject = courseProject;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getProfessor() {
        return professor;
    }

    public void setProfessor(UserDTO professor) {
        this.professor = professor;
    }

    public UserDTO getStudent() {
        return student;
    }

    public void setStudent(UserDTO student) {
        this.student = student;
    }

    public CourseProjectDTO getCourseProject() {
        return courseProject;
    }

    public void setCourseProject(CourseProjectDTO courseProject) {
        this.courseProject = courseProject;
    }

    public CPStatus getStatus() {
        return status;
    }

    public void setStatus(CPStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApprovedCourseProject{" +
                "id=" + id +
                ", professor=" + professor +
                ", student=" + student +
                ", courseProject=" + courseProject +
                '}';
    }
}
