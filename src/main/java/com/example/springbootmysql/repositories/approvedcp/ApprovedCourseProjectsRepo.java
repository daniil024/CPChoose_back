package com.example.springbootmysql.repositories.approvedcp;

import com.example.springbootmysql.models.ApprovedCourseProjectDTO;
import com.example.springbootmysql.models.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprovedCourseProjectsRepo extends
        JpaRepository<ApprovedCourseProjectDTO, Integer>,
        ApprovedCourseProjectsRepoCustom {

    List<ApprovedCourseProjectDTO> findAllApprovedCPByProfessorId(int id);

    List<ApprovedCourseProjectDTO> getWaitingForApproving(UserDTO professor);
}
