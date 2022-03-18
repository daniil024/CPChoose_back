package com.example.springbootmysql.controllers;

import com.example.springbootmysql.models.ProfessorDTO;
import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.repositories.UserRepo;
import com.example.springbootmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    // TODO: create method to get user by id

    @GetMapping("/users")
    public List<UserDTO> user() {
//        String sql = "SELECT * FROM users;";
//
//        List<User> res = jdbcTemplate.query(sql,
//                (rs, rowNum) ->
//                        new User(
//                                rs.getString("email"),
//                                rs.getString("firstname"),
//                                rs.getString("lastname"),
//                                rs.getString("patronymic"),
//                                rs.getString("email_code"),
//                                (UserType) rs.getObject("user_type")
//                        ));
//
//        StringBuilder response = new StringBuilder();
//        for (User u : res) {
//            response.append(u.getId())
//                    .append(u.getEmail())
//                    .append(u.getFirstName())
//                    .append(u.getLastName())
//                    .append(u.getPatronymic())
//                    .append(u.getEmailCode())
//                    .append(u.getUserType()).append("\r\n");
//        }
//        return response.toString();

        return userService.getUsers();
    }
}
