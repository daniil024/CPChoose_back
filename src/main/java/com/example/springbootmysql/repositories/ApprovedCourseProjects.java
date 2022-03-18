package com.example.springbootmysql.repositories;

import com.example.springbootmysql.models.ApprovedCourseProjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovedCourseProjects extends JpaRepository<ApprovedCourseProjectDTO, Integer> {
}
