package com.example.springbootmysql.repositories.approvedcp;

import com.example.springbootmysql.models.ApprovedCourseProjectDTO;
import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.models.enums.CPStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ApprovedCourseProjectsRepoImpl implements ApprovedCourseProjectsRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApprovedCourseProjectDTO> findAllApprovedCPByProfessorId(int id) {
        Query query = entityManager.createNativeQuery("SELECT * FROM approved_course_projects " +
                "WHERE professor_id = " + id + " and (status = " + CPStatus.SELECTED +
                " or status = " + CPStatus.PARTIALLYSELECTED + ")", ApprovedCourseProjectDTO.class);
        return query.getResultList();
    }

    public List<ApprovedCourseProjectDTO> getWaitingForApproving(UserDTO professor){
        Query query = entityManager.createNativeQuery("SELECT * FROM approved_course_projects " +
                "WHERE professor_id = " + professor.getId()/* + " and (status = APPROVED"+
                " or status = PARTIALLYSELECTED)"*/, ApprovedCourseProjectDTO.class);
        return query.getResultList();
    }
}
