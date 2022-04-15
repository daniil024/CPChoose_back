package com.example.springbootmysql.controllers;

import com.example.springbootmysql.models.UserDTO;
import com.example.springbootmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PostMapping("/checkCode")
    public Boolean isRightCode(@RequestBody UserDTO userDTO) {
        return userService.isRightCode(userDTO);
    }

    @GetMapping("/getProfessorData/{userEmail}")
    UserDTO getProfessor(@PathVariable String userEmail){
        return userService.findUserByEmail(userEmail);
    }

    @PostMapping("/updateProfessor")
    public UserDTO updateProfessor(@RequestBody UserDTO userDTO){
        // If updated data in professor object will not appear in user then update here user
        return userService.updateUser(userDTO);
    }

    // TODO: create method to get user by id

    @GetMapping("/users")
    public List<UserDTO> users() {
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
