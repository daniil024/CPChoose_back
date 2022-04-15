package com.example.springbootmysql.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "professors")
public class ProfessorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "cp_count")
    private int cpCount;

    @Column(name = "subdivision")
    private String subdivision;

    @Column(name = "position")
    private String position;


    public ProfessorDTO() {
    }

    public ProfessorDTO(int cp_count, String companyName, String subdivision, String position) {
        super();
        this.companyName = companyName;
        this.cpCount = cp_count;
        this.subdivision = subdivision;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpCount() {
        return cpCount;
    }

    public void setCpCount(int cpCount) {
        this.cpCount = cpCount;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
