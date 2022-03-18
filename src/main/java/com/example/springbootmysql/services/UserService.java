package com.example.springbootmysql.services;

import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UserDTO createUser(UserDTO userDTO) {
        String code = String.valueOf(random.nextInt(9000) + 1000);

        UserDTO existingUser = userRepo.findByEmail(userDTO.getEmail());

        if (existingUser != null) {
            userDTO = existingUser;
        }
        userDTO.setEmailCode(code);
        userRepo.save(userDTO);

        sendConfirmationCode(userDTO.getEmail(), userDTO.getEmailCode());

        return userDTO;
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
}
