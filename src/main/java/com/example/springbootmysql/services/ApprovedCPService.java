package com.example.springbootmysql.services;

import com.example.springbootmysql.models.ApprovedCourseProjectDTO;
import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.repositories.UserRepo;
import com.example.springbootmysql.repositories.approvedcp.ApprovedCourseProjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovedCPService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ApprovedCourseProjectsRepo approvedCourseProjectsRepo;

    public List<ApprovedCourseProjectDTO> findApprovedCPByProfessorId(int id) {
        return approvedCourseProjectsRepo.findAllApprovedCPByProfessorId(id);
    }

    public List<ApprovedCourseProjectDTO> getWaitingForApproving(String email) {
        UserDTO professor = userRepo.findByEmail(email);
        return approvedCourseProjectsRepo.getWaitingForApproving(professor);
    }

    public void updateApprovingCP(ApprovedCourseProjectDTO approvedCourseProjectDTO) {
        approvedCourseProjectsRepo.save(approvedCourseProjectDTO);
    }
}
