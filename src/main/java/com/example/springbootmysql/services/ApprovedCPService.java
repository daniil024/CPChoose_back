package com.example.springbootmysql.services;

import com.example.springbootmysql.models.ApprovedCourseProjectDTO;
import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.models.enums.CPMode;
import com.example.springbootmysql.models.enums.CPType;
import com.example.springbootmysql.repositories.UserRepo;
import com.example.springbootmysql.repositories.approvedcp.ApprovedCourseProjectsRepo;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.itextpdf.layout.element.Table;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Objects;

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

    @Autowired
    private JavaMailSender emailSender;

    public void sendAttachment(String email) {
        try {
            File file = new File("course_project.pdf");
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("Course project file");
            helper.setFrom("dtsurkan@edu.hse.ru");
            helper.setTo(email);
            helper.setReplyTo("dtsurkan@edu.hse.ru");
            helper.setText("Ваша заявка была одобрена научным руководителем. С информацией по " +
                    "курсовому проекту вы можете ознакомиться в прикрепленном файле.", false);
            helper.addAttachment("Описание проекта.pdf", file);
            emailSender.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generatePdf(ApprovedCourseProjectDTO approvedCourseProjectDTO) {
        String file = "course_project.pdf";

        try {
            PdfDocument pdfDoc
                    = new PdfDocument(new PdfWriter(file));

            // Step-2 Creating a Document object
            Document doc = new Document(pdfDoc);

            String FONT_CALIBRI = "calibri.ttf";
            PdfFont font_calibri = PdfFontFactory.createFont(FONT_CALIBRI, PdfEncodings.IDENTITY_H);

            String FONT_TNR = "timesnewromanpsmt.ttf";
            PdfFont font_TNR = PdfFontFactory.createFont(FONT_TNR, PdfEncodings.IDENTITY_H);
            doc.setFont(font_TNR);
            doc.add(new Paragraph("Описание проекта для студентов ФКН НИУ ВШЭ (2021/2022 уч. год)\n\n")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font_calibri)
                    .setBold()
                    .setFontSize(12));


            doc.setFontSize(11);
            doc.setFont(font_TNR);
            // Step-3 Creating a table
            float[] pointColumnWidths = {150F, 450F};
            Table table = new Table(pointColumnWidths);
            table.setMarginLeft(50);
            table.setMarginRight(15);

            table.addCell("Название проекта (на русском языке)");
            String titleRus = approvedCourseProjectDTO.getCourseProject().getTitleRus();
            table.addCell(Objects.requireNonNullElse(titleRus, ""));

            table.addCell("Название проекта (на английском языке)");
            String titleEng = approvedCourseProjectDTO.getCourseProject().getTitleEng();
            table.addCell(Objects.requireNonNullElse(titleEng, ""));

            table.addCell("Тип проекта");
            CPType type = approvedCourseProjectDTO.getCourseProject().getType();
            if (type != null)
                table.addCell(Objects.requireNonNullElse(type.name(), ""));
            else
                table.addCell("");

            table.addCell("Вид проекта");
            CPMode mode = approvedCourseProjectDTO.getCourseProject().getMode();
            if (mode != null)
                table.addCell(Objects.requireNonNullElse(mode.name(), ""));
            else
                table.addCell("");

            table.addCell("Инициатор проекта");
            String initiator = approvedCourseProjectDTO.getCourseProject().getProjectInitiator();
            table.addCell(Objects.requireNonNullElse(initiator, ""));

            table.addCell("Подразделение компании / НИУ ВШЭ");
            String subdivision = approvedCourseProjectDTO.getCourseProject().getCompanySubdivision();
            table.addCell(Objects.requireNonNullElse(subdivision, ""));

            table.addCell("ФИО ментора / руководителя проекта");
            String mentor = approvedCourseProjectDTO.getCourseProject().getMentorFullName();
            table.addCell(Objects.requireNonNullElse(mentor, ""));

            table.addCell("Аннотация проекта");
            String annotation = approvedCourseProjectDTO.getCourseProject().getAnnotation();
            table.addCell(Objects.requireNonNullElse(annotation, ""));

            table.addCell("Цель проекта");
            String goal = approvedCourseProjectDTO.getCourseProject().getProjectGoal();
            table.addCell(Objects.requireNonNullElse(goal, ""));

            table.addCell("Задачи проекта");
            String tasks = approvedCourseProjectDTO.getCourseProject().getProjectTasks();
            table.addCell(Objects.requireNonNullElse(tasks, ""));

            table.addCell("Планируемые результаты проекта");
            String results = approvedCourseProjectDTO.getCourseProject().getProjectResults();
            table.addCell(Objects.requireNonNullElse(results, ""));

            table.addCell("Иная информация");
            String additionalInfo = approvedCourseProjectDTO.getCourseProject().getAdditionalInfo();
            table.addCell(Objects.requireNonNullElse(additionalInfo, ""));

            table.addCell("Территория выполнения проекта");
            String workplace = approvedCourseProjectDTO.getCourseProject().getWorkPlace();
            table.addCell(Objects.requireNonNullElse(workplace, ""));

            table.addCell("Требования к студентам - участникам проекта");
            String requirements = approvedCourseProjectDTO.getCourseProject().getStudentsRequirements();
            table.addCell(Objects.requireNonNullElse(requirements, ""));

            table.addCell("Заявки студентов на проект принимаются");
            String contacts = approvedCourseProjectDTO.getCourseProject().getContacts();
            String startDate = approvedCourseProjectDTO.getCourseProject().getStartDate();
            String finishDate = approvedCourseProjectDTO.getCourseProject().getFinishDate();
            table.addCell(Objects.requireNonNullElse(contacts, "") + "\n"
                    + Objects.requireNonNullElse(startDate, "") + " - "
                    + Objects.requireNonNullElse(finishDate, ""));

            table.addCell("Формы отбора студентов (собеседование, тестирование, выполнение задания и т.п.)");
            String selectionForm = approvedCourseProjectDTO.getCourseProject().getSelectionForm();
            table.addCell(Objects.requireNonNullElse(selectionForm, ""));

            table.addCell("Критерии оценивания результатов выполнения проекта руководителем");
            String evaluationCriteria = approvedCourseProjectDTO.getCourseProject().getEvaluationCriteria();
            table.addCell(Objects.requireNonNullElse(evaluationCriteria, ""));


            // Step-6 Adding Table to document
            doc.add(table);

            // Step-7 Closing the document
            doc.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
