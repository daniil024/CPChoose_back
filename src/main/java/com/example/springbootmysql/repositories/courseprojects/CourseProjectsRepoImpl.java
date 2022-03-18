package com.example.springbootmysql.repositories.courseprojects;

import com.example.springbootmysql.models.CourseProjectDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CourseProjectsRepoImpl implements CourseProjectsRepoCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CourseProjectDTO> findAllAvailableCourseProjects() {
        Query query = entityManager.createNativeQuery("SELECT * FROM course_projects " +
                "WHERE status = \"APPROVED\"", CourseProjectDTO.class);
        return query.getResultList();
    }
}
