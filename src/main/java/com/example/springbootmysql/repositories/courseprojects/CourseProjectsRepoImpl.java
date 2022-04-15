package com.example.springbootmysql.repositories.courseprojects;

import com.example.springbootmysql.models.CourseProjectDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CourseProjectsRepoImpl implements CourseProjectsRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CourseProjectDTO> findAllAvailableCourseProjects(int id, String professorSurname, String word) {
        String partQuery = "";
        if (professorSurname != null && !professorSurname.isBlank() && !professorSurname.isEmpty()) {
            partQuery += " and mentor_full_name LIKE '%" + professorSurname + "%'";
        }
        if (word != null && !word.isBlank() && !word.isEmpty()) {
            partQuery += " and title_rus LIKE '%" + word + "%'";
        }

        Query query = entityManager.createNativeQuery("SELECT * FROM course_projects " +
                "WHERE (status = \"APPROVED\" or status = \"SELECTED\" or status = \"PARTIALLYSELECTED\") " +
                "and user_id != " + id + partQuery, CourseProjectDTO.class);
        return query.getResultList();
    }
}
