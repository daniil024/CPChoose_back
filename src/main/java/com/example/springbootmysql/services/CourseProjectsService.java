package com.example.springbootmysql.services;

import com.example.springbootmysql.models.CourseProjectDTO;
import com.example.springbootmysql.models.enums.CPStatus;
import com.example.springbootmysql.repositories.courseprojects.CourseProjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseProjectsService {

    @Autowired
    private CourseProjectsRepo courseProjectRepo;

    public List<CourseProjectDTO> findCourseProjectByUserId(int id) {
        return courseProjectRepo.findAllByUserId(id);
    }

    public Optional<CourseProjectDTO> findCourseProjectById(int id) {
        return courseProjectRepo.findById(id);
    }

    public List<CourseProjectDTO> findAllAvailableCourseProjects(int id, String professorSurname, String word) {
        return courseProjectRepo.findAllAvailableCourseProjects(id, professorSurname, word);
    }

    public CourseProjectDTO saveCourseProject(CourseProjectDTO courseProjectDTO) {
        // here will be sent only new CP
        courseProjectDTO.setStatus(CPStatus.ONAPPROVING);
        return courseProjectRepo.save(courseProjectDTO);
    }
}
