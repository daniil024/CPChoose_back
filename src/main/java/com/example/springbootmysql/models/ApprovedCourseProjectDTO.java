package com.example.springbootmysql.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "approved_course_projects")
public class ApprovedCourseProjectDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="professor_id")
    private ProfessorDTO professor;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    private Set<StudentDTO> student;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="course_project_id")
    private CourseProjectDTO courseProject;


    public ApprovedCourseProjectDTO() {
    }

    public ApprovedCourseProjectDTO(ProfessorDTO professor, Set<StudentDTO> student, CourseProjectDTO courseProject) {
        super();
        this.professor = professor;
        this.student = student;
        this.courseProject = courseProject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public Set<StudentDTO> getStudent() {
        return student;
    }

    public void setStudent(Set<StudentDTO> student) {
        this.student = student;
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
        ApprovedCourseProjectDTO that = (ApprovedCourseProjectDTO) o;
        return id == that.id && professor.equals(that.professor) && student.equals(that.student) && courseProject.equals(that.courseProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professor, student, courseProject);
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
