package com.example.springbootmysql;

import com.example.springbootmysql.models.CourseProjectDTO;
import com.example.springbootmysql.models.ProfessorDTO;
import com.example.springbootmysql.models.StudentDTO;
import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.models.enums.CPStatus;
import com.example.springbootmysql.repositories.courseprojects.CourseProjectsRepo;
import com.example.springbootmysql.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ConnectionToMySqlApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ConnectionToMySqlApplication.class, args);
    }

    @Autowired
    UserRepo userRepo;

    @Autowired
    CourseProjectsRepo courseProjectRepo;

    @Override
    public void run(String... args) throws Exception {
//        String sql = "INSERT INTO users (email, first_name, last_name, patronymic, email_code, user_type) " +
//                "VALUES (?, ?, ?, ?, ?, ?)";
//        int result = jdbcTemplate.update(sql, "test", "test", "test", "test", "test", "test");

//        User user = new User();
//        user.setEmail("email_update66666");
//        user.setFirstName("test111");
//        user.setLastName("lastname1111");
//        user.setPatronymic("patronymic11111");
//
//        Student student = new Student("facultyRRRRRR", "speciality11111", 4);
//        student.setUser(user);
//        user.setStudent(student);
//
//        userRepo.save(user);

        //==========================

//        UserDTO user1 = new UserDTO();
//        user1.setEmail("dtsurkan@edu.hse.ru");
//        user1.setFirstName("test112222");
//        user1.setLastName("lastname222");
//        user1.setPatronymic("patronymic2222");
//
//        StudentDTO studentDTO = new StudentDTO();
//        user1.setStudent(studentDTO);
//
//        ProfessorDTO professor = new ProfessorDTO(4, "subdivision", "position");
//        user1.setProfessor(professor);
//        Set<CourseProjectDTO> s = new HashSet<>();
//        CourseProjectDTO courseProjectDTO = new CourseProjectDTO();
//        courseProjectDTO.setStatus(CPStatus.APPROVED);
//        courseProjectDTO.setTitleRus("TitleRus");
//        s.add(courseProjectDTO);
//        courseProjectDTO.setUserId(1);
//
//        user1.setOnApprovingCourseProjects(s);
//
//        userRepo.save(user1);
//
//
//        courseProjectRepo.save(courseProjectDTO);
//
//        System.out.println(user1.getOnApprovingCourseProjects().toString());
//        System.out.println(user1);



        // ====================

//        try {
//            User user2 = new User();
//            user2.setEmail("professor_test4");
//            user2.setFirstName("test112222");
//            user2.setLastName("lastname222");
//            user2.setPatronymic("patronymic2222");
//
//            Professor professor2 = new Professor(4, "subdivision", "position");
//            professor2.setUser(user2);
//            user2.setProfessor(professor2);
//
//            userRepo.save(user2);
//        }catch (Exception e){
//            System.out.println("could not insert user");
//        }


//        String sql1 = "INSERT INTO Students (user_id, faculty, speciality, year_of_study) " +
//                "VALUES (?, ?, ?, ?)";
//        int result1 = jdbcTemplate.update(sql1, student.getId(), student.getFaculty(),
//                student.getSpeciality(), student.getYear_of_study());

//        if (result > 0 /*&& result1 > 0*/) {
//            System.out.println("A new row has been inserted.");
//            System.out.println("A new row has been inserted to Students.");
//        }
    }
}
