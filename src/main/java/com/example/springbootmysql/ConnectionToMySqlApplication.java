package com.example.springbootmysql;

import com.example.springbootmysql.models.*;
import com.example.springbootmysql.models.enums.CPStatus;
import com.example.springbootmysql.repositories.UserRepo;
import com.example.springbootmysql.repositories.approvedcp.ApprovedCourseProjectsRepo;
import com.example.springbootmysql.repositories.courseprojects.CourseProjectsRepo;
import com.example.springbootmysql.services.ApprovedCPService;
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
    ApprovedCourseProjectsRepo approvedCourseProjectsRepo;

    @Autowired
    CourseProjectsRepo courseProjectRepo;


    @Autowired
    ApprovedCPService approvedCPService;

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
//
//        UserDTO userDTO = new UserDTO();
//        StudentDTO studentDTO = new StudentDTO();
//        userDTO.setStudent(studentDTO);
//        UserDTO userDTO1 = new UserDTO();
//        ProfessorDTO professorDTO = new ProfessorDTO();
//        userDTO1.setProfessor(professorDTO);
//        userDTO1.setEmail("test");
//        userRepo.save(userDTO1);
//        ApprovedCourseProjectDTO approvedCourseProjectDTO = new ApprovedCourseProjectDTO();
//        approvedCourseProjectDTO.setProfessor(professorDTO);
//        Set<StudentDTO> s = new HashSet<>();
//        s.add(studentDTO);
//        CourseProjectDTO courseProjectDTO = new CourseProjectDTO();
//        courseProjectRepo.save(courseProjectDTO);
//        approvedCourseProjectDTO.setStudent(s);
//        approvedCourseProjectDTO.setCourseProject(courseProjectDTO);
//
//        approvedCourseProjectsRepo.save(approvedCourseProjectDTO);
        // ===========================

        //approvedCPService.generatePdf(new ApprovedCourseProjectDTO());

        UserDTO user1 = new UserDTO();
        user1.setEmail("dtsurkan@edu.hse.ru");
        user1.setFirstName("test112222");
        user1.setLastName("lastname222");
        user1.setPatronymic("patronymic2222");

        StudentDTO studentDTO = new StudentDTO();
        user1.setStudent(studentDTO);

        ProfessorDTO professor = new ProfessorDTO(4,"companyName", "subdivision", "position");
        user1.setProfessor(professor);
        Set<CourseProjectDTO> s = new HashSet<>();

        userRepo.save(user1);


        for (int i = 0; i < 2; i++) {
            CourseProjectDTO courseProjectDTO = new CourseProjectDTO();
            courseProjectDTO.setStatus(CPStatus.APPROVED);
            courseProjectDTO.setTitleRus("TitleRus");
            courseProjectDTO.setAnnotation("В связи с обширной цифровизацией всевозможных процессов и технологий, в нашем обществе у людей возникает потребность и желание оптимизировать все процессы, доверив вычисления, сбор и обработку информации автоматизированным сервисам управления данными. В период выбора курсовых проектов, у преподавателей и студентов появляется острая необходимость в надежном инструменте, классифицирующем все имеющиеся курсовые проекты. Получении всех необходимых данных для быстрого заполнения отчетностей и иной документации также является необходимым функционалом для пользователей.\n" +
                    "Проект, о котором идет речь в документе, предназначен для помощи студентам, преподавателям и другим сотрудникам в период выбора и защиты курсовых проектов. В текущий момент проект будет развиваться для сотрудников и студентов факультета компьютерных наук. Android-приложение предназначено для работы преподавателей и студентов с курсовыми проектами на этапе создания и выбора тем курсовых работ.\n");
            s.add(courseProjectDTO);
            courseProjectDTO.setUserId(1);

            courseProjectRepo.save(courseProjectDTO);
            ApprovedCourseProjectDTO approvedCourseProjectDTO = new ApprovedCourseProjectDTO();
            approvedCourseProjectDTO.setCourseProject(courseProjectDTO);
            approvedCourseProjectDTO.setProfessor(userRepo.findByEmail(user1.getEmail()));
            approvedCourseProjectDTO.setStudent(user1);
            approvedCourseProjectDTO.setStatus(courseProjectDTO.getStatus());
            approvedCourseProjectsRepo.save(approvedCourseProjectDTO);
            //courseProjectRepo.save(courseProjectDTO);
        }

        for (int i = 0; i < 2; i++) {
            CourseProjectDTO courseProjectDTO = new CourseProjectDTO();
            courseProjectDTO.setStatus(CPStatus.CREATED);
            courseProjectDTO.setTitleRus("TitleRus");
            courseProjectDTO.setAnnotation("В связи с обширной цифровизацией всевозможных процессов и технологий, в нашем обществе у людей возникает потребность и желание оптимизировать все процессы, доверив вычисления, сбор и обработку информации автоматизированным сервисам управления данными. В период выбора курсовых проектов, у преподавателей и студентов появляется острая необходимость в надежном инструменте, классифицирующем все имеющиеся курсовые проекты. Получении всех необходимых данных для быстрого заполнения отчетностей и иной документации также является необходимым функционалом для пользователей.\n" +
                    "Проект, о котором идет речь в документе, предназначен для помощи студентам, преподавателям и другим сотрудникам в период выбора и защиты курсовых проектов. В текущий момент проект будет развиваться для сотрудников и студентов факультета компьютерных наук. Android-приложение предназначено для работы преподавателей и студентов с курсовыми проектами на этапе создания и выбора тем курсовых работ.\n");
            s.add(courseProjectDTO);
            courseProjectDTO.setUserId(1);
            //courseProjectRepo.save(courseProjectDTO);
        }



        user1.setOnApprovingCourseProjects(s);




        //userRepo.save(user1);

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
