package com.example.springbootmysql.services;

import com.example.springbootmysql.models.ProfessorDTO;
import com.example.springbootmysql.models.StudentDTO;
import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.models.enums.UserType;
import com.example.springbootmysql.repositories.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    final Random random = new Random();
    private static final String messageText = "Your code: ";

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    UserRepo userRepo;

    public UserDTO findUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public UserDTO createUser(UserDTO userDTO) {
        String code = String.valueOf(random.nextInt(9000) + 1000);

        UserDTO existingUser = userRepo.findByEmail(userDTO.getEmail());

        if (existingUser == null) {
            existingUser = userDTO;
            if(userDTO.getUserType() == UserType.PROFESSOR){
                existingUser.setProfessor(new ProfessorDTO());
            }else{
                existingUser.setStudent(new StudentDTO());
            }
        }
        existingUser.setUserType(userDTO.getUserType());
        existingUser.setEmailCode(code);
        userRepo.save(existingUser);

        final UserDTO user = existingUser;
        new Thread(() -> sendConfirmationCode(user.getEmail(), user.getEmailCode())).start();

        return existingUser;
    }

    public UserDTO updateUser(UserDTO userDTO) {
        return userRepo.save(userDTO);
    }

    private void sendConfirmationCode(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dtsurkan@edu.hse.ru");
        message.setTo(email);
        message.setSubject("test");
        message.setText(messageText + code);
        emailSender.send(message);
    }

    public List<UserDTO> getUsers() {
        return userRepo.findAll();
    }

    public Boolean isRightCode(UserDTO userDTO) {
        UserDTO existingUser = userRepo.findByEmail(userDTO.getEmail());
        return existingUser.getEmailCode().equals(userDTO.getEmailCode());
    }
}
