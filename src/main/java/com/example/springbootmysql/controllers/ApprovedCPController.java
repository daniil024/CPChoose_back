package com.example.springbootmysql.controllers;

import com.example.springbootmysql.models.ApprovedCourseProjectDTO;
import com.example.springbootmysql.models.CourseProjectDTO;
import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.services.ApprovedCPService;
import com.example.springbootmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ApprovedCPController {

    @Autowired
    private ApprovedCPService approvedCPService;

    @Autowired
    private UserService userService;

    @PostMapping("/applyCPRequest/{userEmail}")
    public Boolean applyCPRequest(@PathVariable String userEmail,
                                  @RequestBody CourseProjectDTO courseProjectDTO) {
        UserDTO userStudent = userService.findUserByEmail(userEmail);
        UserDTO professorDTO = userService.findUserByEmail(courseProjectDTO.getProfessorEmail());
        if (userStudent.getStudent().getCpChoseCount() >= 3) {
            return false;
        } else {
            userStudent.getStudent().setCpChoseCount(userStudent.getStudent().getCpChoseCount() + 1);
            ApprovedCourseProjectDTO approvedCourseProjectDTO = new ApprovedCourseProjectDTO();
            approvedCourseProjectDTO.setProfessor(professorDTO);
            approvedCourseProjectDTO.setStudent(userStudent);
            approvedCourseProjectDTO.setCourseProject(courseProjectDTO);
            approvedCourseProjectDTO.setStatus(courseProjectDTO.getStatus());
            userService.updateUser(userStudent);
            approvedCPService.updateApprovingCP(approvedCourseProjectDTO);
            return true;
        }
    }

    @PostMapping("/approveCP")
    public List<ApprovedCourseProjectDTO> approveCP(
            @RequestBody ApprovedCourseProjectDTO approvedCourseProjectDTO
    ) {
        // TODO
        return getWaitingForApproving(approvedCourseProjectDTO.getProfessor().getEmail());
    }

    @GetMapping("/getWaitingForApprovingCP/{userEmail}")
    public List<ApprovedCourseProjectDTO> getWaitingForApproving(@PathVariable String userEmail){
        return approvedCPService.getWaitingForApproving(userEmail);
    }

    @GetMapping("/getProposedCP/{id}")
    public List<ApprovedCourseProjectDTO> findApprovedCPByProfessorId(@PathVariable int id) {
        return approvedCPService.findApprovedCPByProfessorId(id);
    }
}
