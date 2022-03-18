package com.example.springbootmysql.repositories.courseprojects;

import com.example.springbootmysql.models.CourseProjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseProjectsRepo extends JpaRepository<CourseProjectDTO, Integer>, CourseProjectsRepoCustom {

    List<CourseProjectDTO> findAllByUserId(int id);
}
