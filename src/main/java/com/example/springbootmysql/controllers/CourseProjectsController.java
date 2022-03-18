package com.example.springbootmysql.controllers;

import com.example.springbootmysql.models.CourseProjectDTO;
import com.example.springbootmysql.services.CourseProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseProjectsController {

    @Autowired
    private CourseProjectsService courseProjectsService;

    /*
    Find all course projects to display in user's screen (all CP in all statuses)
    id - user's id
     */
    @GetMapping("/getCourseProjectByUserId/{id}")
    public List<CourseProjectDTO> findCourseProjectByUserId(@PathVariable int id) {
        return courseProjectsService.findCourseProjectByUserId(id);
    }

    /*
    Find exact course project by id
    id - course project's id
     */
    @GetMapping("/getCourseProjectById/{id}")
    public Optional<CourseProjectDTO> findCourseProjectById(@PathVariable int id) {
        return courseProjectsService.findCourseProjectById(id);
    }

    /*
    Find all course projects available for choose (for Student and Professor they are the same)
     */
    @GetMapping("/getCourseProjects")
    public List<CourseProjectDTO> findAllAvailableCourseProjects() {
        return courseProjectsService.findAllAvailableCourseProjects();
    }


    // TODO: create method to add course project to CourseProject table and
    //  add CP to USER field, if it is on status ONAPPROVING
    /*
    Update and add course projects
     */
    @PostMapping("/createCourseProject")
    public CourseProjectDTO saveCourseProject(@RequestBody CourseProjectDTO courseProjectDTO) {
        //TODO: create method to update existing course project by id, or check maybe its
        // possible to update with the same method when id exists
        return courseProjectsService.saveCourseProject(courseProjectDTO);
    }
}
