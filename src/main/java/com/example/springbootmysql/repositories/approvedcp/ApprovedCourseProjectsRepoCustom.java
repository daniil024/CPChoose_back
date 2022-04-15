package com.example.springbootmysql.repositories.approvedcp;

import com.example.springbootmysql.models.ApprovedCourseProjectDTO;
import com.example.springbootmysql.models.UserDTO;

import java.util.List;

public interface ApprovedCourseProjectsRepoCustom {

    List<ApprovedCourseProjectDTO> findAllApprovedCPByProfessorId(int id);

    List<ApprovedCourseProjectDTO> getWaitingForApproving(UserDTO professor);

}
