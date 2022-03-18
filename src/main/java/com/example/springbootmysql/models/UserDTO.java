package com.example.springbootmysql.models;

import com.example.springbootmysql.models.enums.UserType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email_code")
    private String emailCode;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private StudentDTO student;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    private ProfessorDTO professor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "on_app_cp", referencedColumnName = "id")
    private Set<CourseProjectDTO> onApprovingCourseProjects;


    public UserDTO() {
    }

    public UserDTO(String email, String name,
                   String lastname, String patronymic,
                   String email_code, UserType userType) {
        super();
        this.email = email;
        this.firstName = name;
        this.lastName = lastname;
        this.patronymic = patronymic;
        this.emailCode = email_code;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public Set<CourseProjectDTO> getOnApprovingCourseProjects() {
        return onApprovingCourseProjects;
    }

    public void setOnApprovingCourseProjects(Set<CourseProjectDTO> onApprovingCourseProjects) {
        this.onApprovingCourseProjects = onApprovingCourseProjects;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", emailCode='" + emailCode + '\'' +
                ", userType=" + userType +
                ", student=" + student +
                ", professor=" + professor +
                ", onApprovingCourseProjects=" + onApprovingCourseProjects +
                '}';
    }
}
