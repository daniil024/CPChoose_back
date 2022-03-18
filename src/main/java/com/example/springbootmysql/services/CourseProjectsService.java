package com.example.springbootmysql.services;

import com.example.springbootmysql.models.CourseProjectDTO;
import com.example.springbootmysql.repositories.courseprojects.CourseProjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseProjectsService {

    @Autowired
    CourseProjectsRepo courseProjectRepo;

    public List<CourseProjectDTO> findCourseProjectByUserId(int id) {
        return courseProjectRepo.findAllByUserId(id);
    }

    public Optional<CourseProjectDTO> findCourseProjectById(int id) {
        return courseProjectRepo.findById(id);
    }

    public List<CourseProjectDTO> findAllAvailableCourseProjects() {
        return courseProjectRepo.findAllAvailableCourseProjects();
    }

    public CourseProjectDTO saveCourseProject(CourseProjectDTO courseProjectDTO) {
        return courseProjectRepo.save(courseProjectDTO);
    }
}
