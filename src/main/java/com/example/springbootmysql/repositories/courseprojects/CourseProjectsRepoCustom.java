package com.example.springbootmysql.repositories.courseprojects;

import com.example.springbootmysql.models.CourseProjectDTO;

import java.util.List;

public interface CourseProjectsRepoCustom {

    List<CourseProjectDTO> findAllAvailableCourseProjects(int id, String professorSurname, String word);
}
