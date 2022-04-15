package com.example.springbootmysql.models;


import com.example.springbootmysql.models.enums.CPMode;
import com.example.springbootmysql.models.enums.CPStatus;
import com.example.springbootmysql.models.enums.CPType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_projects")
public class CourseProjectDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private int userId;

    @Column(name = "professor_email")
    private String professorEmail;

    @Column(name = "title_rus")
    private String titleRus;

    @Column(name = "title_eng")
    private String titleEng;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CPType type;

    @Column(name = "mode")
    @Enumerated(EnumType.STRING)
    private CPMode mode;

    @Column(name = "members_count")
    private String membersCount;

    @Column(name = "project_initiator")
    private String projectInitiator;

    @Column(name = "company_subdivision")
    private String companySubdivision;

    @Column(name = "mentor_full_name")
    private String mentorFullName;

    @Column(name = "annotation", length = 4096)
    private String annotation;

    @Column(name = "project_goal")
    private String projectGoal;

    @Column(name = "project_tasks")
    private String projectTasks;

    @Column(name = "participants_tasks")
    private String participantsTasks;

    @Column(name = "project_results")
    private String projectResults;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "work_place")
    private String workPlace;

    @Column(name = "student_requirements")
    private String studentsRequirements;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "finish_date")
    private String finishDate;

    @Column(name = "selection_form")
    private String selectionForm;

    @Column(name = "evaluation_criteria")
    private String evaluationCriteria;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CPStatus status;

    public CourseProjectDTO() {
    }

    public CourseProjectDTO(int user_id, String titleRus,
                            String titleEng, CPType type,
                            String professorEmail,
                            CPMode mode, String membersCount,
                            String projectInitiator, String companySubdivision,
                            String mentorFullName, String annotation,
                            String projectGoal, String projectTasks,
                            String participantsTasks, String projectResults,
                            String additionalInfo, String workPlace,
                            String studentsRequirements, String contacts,
                            String startDate, String finishDate,
                            String selectionForm, String evaluationCriteria, CPStatus status) {
        super();
        this.userId = user_id;
        this.titleRus = titleRus;
        this.titleEng = titleEng;
        this.professorEmail = professorEmail;
        this.type = type;
        this.mode = mode;
        this.membersCount = membersCount;
        this.projectInitiator = projectInitiator;
        this.companySubdivision = companySubdivision;
        this.mentorFullName = mentorFullName;
        this.annotation = annotation;
        this.projectGoal = projectGoal;
        this.projectTasks = projectTasks;
        this.participantsTasks = participantsTasks;
        this.projectResults = projectResults;
        this.additionalInfo = additionalInfo;
        this.workPlace = workPlace;
        this.studentsRequirements = studentsRequirements;
        this.contacts = contacts;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.selectionForm = selectionForm;
        this.evaluationCriteria = evaluationCriteria;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitleRus() {
        return titleRus;
    }

    public void setTitleRus(String titleRus) {
        this.titleRus = titleRus;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public void setTitleEng(String titleEng) {
        this.titleEng = titleEng;
    }

    public CPType getType() {
        return type;
    }

    public void setType(CPType type) {
        this.type = type;
    }

    public CPMode getMode() {
        return mode;
    }

    public void setMode(CPMode mode) {
        this.mode = mode;
    }

    public String getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(String membersCount) {
        this.membersCount = membersCount;
    }

    public String getProjectInitiator() {
        return projectInitiator;
    }

    public void setProjectInitiator(String projectInitiator) {
        this.projectInitiator = projectInitiator;
    }

    public String getCompanySubdivision() {
        return companySubdivision;
    }

    public void setCompanySubdivision(String companySubdivision) {
        this.companySubdivision = companySubdivision;
    }

    public String getMentorFullName() {
        return mentorFullName;
    }

    public void setMentorFullName(String mentorFullName) {
        this.mentorFullName = mentorFullName;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getProjectGoal() {
        return projectGoal;
    }

    public void setProjectGoal(String projectGoal) {
        this.projectGoal = projectGoal;
    }

    public String getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(String projectTasks) {
        this.projectTasks = projectTasks;
    }

    public String getParticipantsTasks() {
        return participantsTasks;
    }

    public void setParticipantsTasks(String participantsTasks) {
        this.participantsTasks = participantsTasks;
    }

    public String getProjectResults() {
        return projectResults;
    }

    public void setProjectResults(String projectResults) {
        this.projectResults = projectResults;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getStudentsRequirements() {
        return studentsRequirements;
    }

    public void setStudentsRequirements(String studentsRequirements) {
        this.studentsRequirements = studentsRequirements;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getSelectionForm() {
        return selectionForm;
    }

    public void setSelectionForm(String selectionForm) {
        this.selectionForm = selectionForm;
    }

    public String getEvaluationCriteria() {
        return evaluationCriteria;
    }

    public void setEvaluationCriteria(String evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
    }

    public CPStatus getStatus() {
        return status;
    }

    public void setStatus(CPStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseProjectDTO that = (CourseProjectDTO) o;
        return id == that.id && Objects.equals(userId, that.userId) && Objects.equals(titleRus, that.titleRus) && Objects.equals(titleEng, that.titleEng) && type == that.type && mode == that.mode && Objects.equals(membersCount, that.membersCount) && Objects.equals(projectInitiator, that.projectInitiator) && Objects.equals(companySubdivision, that.companySubdivision) && Objects.equals(mentorFullName, that.mentorFullName) && Objects.equals(annotation, that.annotation) && Objects.equals(projectGoal, that.projectGoal) && Objects.equals(projectTasks, that.projectTasks) && Objects.equals(participantsTasks, that.participantsTasks) && Objects.equals(projectResults, that.projectResults) && Objects.equals(additionalInfo, that.additionalInfo) && Objects.equals(workPlace, that.workPlace) && Objects.equals(studentsRequirements, that.studentsRequirements) && Objects.equals(contacts, that.contacts) && Objects.equals(startDate, that.startDate) && Objects.equals(finishDate, that.finishDate) && Objects.equals(selectionForm, that.selectionForm) && Objects.equals(evaluationCriteria, that.evaluationCriteria) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, titleRus, titleEng, type, mode, membersCount, projectInitiator, companySubdivision, mentorFullName, annotation, projectGoal, projectTasks, participantsTasks, projectResults, additionalInfo, workPlace, studentsRequirements, contacts, startDate, finishDate, selectionForm, evaluationCriteria, status);
    }

    @Override
    public String toString() {
        return "CourseProject{" +
                "id=" + id +
                ", user_id=" + userId +
                ", titleRus='" + titleRus + '\'' +
                ", titleEng='" + titleEng + '\'' +
                ", type=" + type +
                ", mode=" + mode +
                ", membersCount='" + membersCount + '\'' +
                ", projectInitiator='" + projectInitiator + '\'' +
                ", companySubdivision='" + companySubdivision + '\'' +
                ", mentorFullName='" + mentorFullName + '\'' +
                ", annotation='" + annotation + '\'' +
                ", projectGoal='" + projectGoal + '\'' +
                ", projectTasks='" + projectTasks + '\'' +
                ", participantsTasks='" + participantsTasks + '\'' +
                ", projectResults='" + projectResults + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", studentsRequirements='" + studentsRequirements + '\'' +
                ", contacts='" + contacts + '\'' +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", selectionForm='" + selectionForm + '\'' +
                ", evaluationCriteria='" + evaluationCriteria + '\'' +
                ", status=" + status +
                '}';
    }
}
