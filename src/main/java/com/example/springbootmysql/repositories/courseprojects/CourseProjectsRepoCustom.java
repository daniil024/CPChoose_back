package com.example.springbootmysql.repositories.courseprojects;

import com.example.springbootmysql.models.CourseProjectDTO;

import java.util.List;

public interface CourseProjectsRepoCustom {

    public List<CourseProjectDTO> findAllAvailableCourseProjects();
}
